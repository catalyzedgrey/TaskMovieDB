package com.grey.moviedb.di.module;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.grey.moviedb.di.ActivityContext;
import com.grey.moviedb.di.PerActivity;
import com.grey.moviedb.ui.main.MainMvpPresenter;
import com.grey.moviedb.ui.main.MainMvpView;
import com.grey.moviedb.ui.main.MainPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext(){return mActivity;}

    @Provides
    AppCompatActivity provideActivity(){return mActivity;}

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(MainPresenter<MainMvpView> presenter) {
        return presenter;
    }

}
