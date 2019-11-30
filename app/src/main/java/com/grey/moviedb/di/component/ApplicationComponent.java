package com.grey.moviedb.di.component;

import android.app.Application;
import android.content.Context;

import com.grey.moviedb.MvpApp;
import com.grey.moviedb.data.DataManager;
import com.grey.moviedb.di.ApplicationContext;
import com.grey.moviedb.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(MvpApp app);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}
