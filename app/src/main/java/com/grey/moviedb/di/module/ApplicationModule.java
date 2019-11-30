package com.grey.moviedb.di.module;

import android.app.Application;
import android.content.Context;

import com.grey.moviedb.BuildConfig;
import com.grey.moviedb.data.AppDataManager;
import com.grey.moviedb.data.DataManager;
import com.grey.moviedb.data.network.ApiHeader;
import com.grey.moviedb.data.network.ApiHelper;
import com.grey.moviedb.data.network.AppApiHelper;
import com.grey.moviedb.di.ApiInfo;
import com.grey.moviedb.di.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application app){
        mApplication = app;
    }

    @Provides
    @ApplicationContext
    Context provideContext(){
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return BuildConfig.API_KEY;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(@ApiInfo String apiKey) {
        return new ApiHeader.ProtectedApiHeader(
                apiKey, (long)1, apiKey);
    }
}
