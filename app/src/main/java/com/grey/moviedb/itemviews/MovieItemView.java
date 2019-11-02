package com.grey.moviedb.itemviews;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.grey.moviedb.R;
import com.grey.moviedb.activities.MovieDetailActivity;
import com.grey.moviedb.models.Movie;
import com.grey.moviedb.utils.Constants;

public class MovieItemView implements View.OnClickListener{

    private ImageView imgView;
    private TextView movieNameTV;
    private View itemView;
    String imgURL, overview, year, voteAvg;

    public MovieItemView(View itemView) {

        this.itemView = itemView;
        movieNameTV = itemView.findViewById(R.id.movie_title_tv);
        imgView = itemView.findViewById(R.id.movie_poster_img);

        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(v.getContext(), MovieDetailActivity.class);
        i.putExtra("title", movieNameTV.getText().toString());
        i.putExtra("img", imgURL);
        i.putExtra("overview", overview);
        i.putExtra("year", year);
        i.putExtra("rating", voteAvg);
        v.getContext().startActivity(i);
    }

    public void bindMovie(Movie movie) {
        movieNameTV.setText(movie.getTitle());
        year = movie.getYear();
        imgURL = Constants.IMG_URL+movie.getImgPath();
        Glide.with(itemView).load(imgURL ).into(imgView);
        overview = movie.getOverview();
        voteAvg=movie.getVoteAvg();
    }
}
