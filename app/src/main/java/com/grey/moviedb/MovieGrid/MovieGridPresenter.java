package com.grey.moviedb.MovieGrid;

import androidx.annotation.NonNull;

import com.grey.moviedb.models.Movie;

    public class MovieGridPresenter implements MovieGridContract.Presenter {

        private final MovieGridContract.View mMovieGridView;

        public MovieGridPresenter(MovieGridContract.View mMovieGridView){
            this.mMovieGridView = mMovieGridView;
        }


        @Override
        public void openMovieDetails(@NonNull Movie requestedMovie) {
            mMovieGridView.showMovieDetailsUi(requestedMovie);
        }

    }
