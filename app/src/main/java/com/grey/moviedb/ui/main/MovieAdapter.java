package com.grey.moviedb.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.grey.moviedb.R;
import com.grey.moviedb.data.network.model.Movie;

import java.util.List;

import retrofit2.Callback;

public class MovieAdapter extends BaseAdapter {
    public static final String IMG_URL = "https://image.tmdb.org/t/p/w500/";
    private List<Movie> mMovieList;

    public MovieAdapter(List<Movie> movieList) {
        mMovieList = movieList;
    }

    @Override
    public int getCount() {
        return mMovieList.size();
    }

    @Override
    public Object getItem(int position) {
        return mMovieList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            view = inflater.inflate(R.layout.item_movie, parent, false);
        }
        final Movie movie = mMovieList.get(position);

        TextView title = view.findViewById(R.id.movie_title_tv);
        title.setText(movie.getTitle());
        ImageView poster = view.findViewById(R.id.movie_poster_img);
        String imgURL = IMG_URL + movie.getImgPath();
        Glide.with(view.getContext()).load(imgURL).into(poster);

        return view;
    }

    public void refreshAdapter(List<Movie> movieList){
        mMovieList = movieList;
        notifyDataSetChanged();
    }

}

