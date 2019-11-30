package com.grey.moviedb.ui.main;

import com.grey.moviedb.di.PerActivity;
import com.grey.moviedb.ui.base.MvpPresenter;
import com.grey.moviedb.ui.base.MvpView;

@PerActivity
public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V> {
    void onViewInitialized();

}
