package com.grey.moviedb.MovieGrid;

import androidx.annotation.NonNull;

import com.grey.moviedb.BasePresenter;
import com.grey.moviedb.BaseView;
import com.grey.moviedb.models.Movie;

public interface MovieGridContract {

    interface View extends BaseView<Presenter> {
        void showMovieDetailsUi(Movie movie);

    }

    interface Presenter extends BasePresenter {

        void openMovieDetails(@NonNull Movie requestedMovie);
    }
}
