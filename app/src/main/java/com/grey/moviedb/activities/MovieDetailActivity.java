package com.grey.moviedb.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.grey.moviedb.R;

import java.util.List;

public class MovieDetailActivity extends DataHoldingActivity {
    ImageView imgView;
    TextView titleTV, yearTV, overviewTV, ratingTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        initViews();
        prepareData();
    }

    protected void initViews() {
        imgView = findViewById(R.id.movie_poster_img);
        titleTV = findViewById(R.id.movie_title_tv);
        yearTV = findViewById(R.id.date_tv);
        overviewTV = findViewById(R.id.overview_tv);
        ratingTV = findViewById(R.id.rating_tv);
    }

    protected void prepareData() {
        Intent i = getIntent();
        titleTV.setText(i.getStringExtra("title"));
        yearTV.setText(i.getStringExtra("year"));
        Glide.with(this).load(i.getStringExtra("img")).into(imgView);
        overviewTV.setText(i.getStringExtra("overview"));
        ratingTV.setText(i.getStringExtra("rating"));
    }
}


