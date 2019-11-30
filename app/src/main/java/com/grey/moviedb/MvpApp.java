package com.grey.moviedb;

import android.app.Application;
import android.content.Context;

import com.grey.moviedb.data.DataManager;
import com.grey.moviedb.di.component.ApplicationComponent;
import com.grey.moviedb.di.component.DaggerApplicationComponent;
import com.grey.moviedb.di.module.ApplicationModule;

import javax.inject.Inject;

public class MvpApp extends Application {

    @Inject
    DataManager mDataManager;

    protected ApplicationComponent applicationComponent;

    public static MvpApp get(Context context){
        return (MvpApp) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);
    }

    public ApplicationComponent getComponent(){
        return applicationComponent;
    }
}
