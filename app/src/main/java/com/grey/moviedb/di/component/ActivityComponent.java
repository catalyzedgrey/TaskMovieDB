package com.grey.moviedb.di.component;

import com.grey.moviedb.di.PerActivity;
import com.grey.moviedb.di.module.ActivityModule;
import com.grey.moviedb.ui.main.MainActivity;

import dagger.Component;

@PerActivity
@Component (dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity activity);

}
