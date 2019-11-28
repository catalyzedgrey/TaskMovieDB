package com.grey.moviedb.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ProgressBar;

import com.grey.moviedb.R;
import com.grey.moviedb.adapters.MovieAdapter;
import com.grey.moviedb.interfaces.IService;
import com.grey.moviedb.models.Movie;
import com.grey.moviedb.network.Controller;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends OnlineDataHoldingActivity {

    GridView gridView;
    List<Movie> movieList = new ArrayList<>();
    private static ProgressBar progressBar;
    MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        prepareData();
    }

    protected void initViews() {
        gridView = findViewById(R.id.grid);
        adapter = new MovieAdapter(this, movieList);
        gridView.setAdapter(adapter);
        progressBar = findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);
    }

    protected void prepareData() {
        Controller controller = new Controller();
        controller.setService(this);
        controller.start();
    }

    public static void hideSpinner() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onTaskCompleted(List objects) {
        adapter.refreshAdapter(objects);
        hideSpinner();
    }
}
