package com.grey.moviedb.MovieGrid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ProgressBar;

import com.grey.moviedb.R;
import com.grey.moviedb.activities.MovieDetailActivity;
import com.grey.moviedb.adapters.MovieAdapter;
import com.grey.moviedb.main.MainActivity;
import com.grey.moviedb.models.Movie;
import com.grey.moviedb.utils.ActivityUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MovieGridActivity extends AppCompatActivity {

    GridView gridView;
    List<Movie> movieList = new ArrayList<>();
    private static ProgressBar progressBar;
    MovieAdapter adapter;

    @Inject
    MovieGridPresenter mPresenter;

    MainActivity.MovieItemListener movieItemListener = new MainActivity.MovieItemListener() {
        @Override
        public void onTaskClick(Movie clickedMovie) {
            mPresenter.openMovieDetails(clickedMovie);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_grid);

        MovieGridFragment gridFragment =
                (MovieGridFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (gridFragment == null) {
            // Create the fragment
            gridFragment = MovieGridFragment.newInstance();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), gridFragment, R.id.contentFrame);
        }

        // Create the presenter
//        mPresenter = new MovieGridPresenter(
//                Injection.provideTasksRepository(getApplicationContext()), gridFragment);
    }

    protected void initViews() {
        gridView = findViewById(R.id.grid);
        adapter = new MovieAdapter(this, movieList, movieItemListener);
        gridView.setAdapter(adapter);
        progressBar = findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);
    }

}
