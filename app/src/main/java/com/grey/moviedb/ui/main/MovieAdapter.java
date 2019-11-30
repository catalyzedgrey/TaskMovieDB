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
import com.grey.moviedb.data.network.model.MovieAPI;

import java.util.List;

import retrofit2.Callback;

public class MovieAdapter extends BaseAdapter {

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
        ViewHolder viewHolder = null;

        if (convertView == null) {
            viewHolder = new ViewHolder();

            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.movie_poster_img);
            viewHolder.title = (TextView) convertView.findViewById(R.id.movie_title_tv);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Movie movie = mMovieList.get(position);

        if (movie != null) {
            viewHolder.title.setText(movie.getTitle());

            String imgURL = MovieAPI.IMG_URL + movie.getImgPath();
            Glide.with(convertView.getContext()).load(imgURL).into(viewHolder.image);
        }

        return convertView;
    }

    public void refreshAdapter(List<Movie> movieList) {
        mMovieList = movieList;
        notifyDataSetChanged();
    }

    private static class ViewHolder {
        public ImageView image;
        public TextView title;
    }

}

