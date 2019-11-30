package com.grey.moviedb.ui.main;

import com.grey.moviedb.data.network.model.Movie;
import com.grey.moviedb.ui.base.MvpView;

import java.util.List;

public interface MainMvpView extends MvpView {
    void openMovieDetailsActivity();

    void updateMovieList(List<Movie> movieList);
}
