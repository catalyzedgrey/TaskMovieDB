package com.grey.moviedb.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ProgressBar;

import com.grey.moviedb.R;
import com.grey.moviedb.adapters.MovieAdapter;
import com.grey.moviedb.models.Movie;
import com.grey.moviedb.network.Controller;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    List<Movie> movieList = new ArrayList<>();
    private static ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews(){
        gridView = findViewById(R.id.grid);
        MovieAdapter adapter = new MovieAdapter(this, movieList);
        gridView.setAdapter(adapter);
        progressBar = findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);
        //adapter.notifyDataSetChanged();
        Controller controller = new Controller();
        controller.start(adapter);
    }

    public static void hideSpinner(){
        progressBar.setVisibility(View.GONE);
    }
}
