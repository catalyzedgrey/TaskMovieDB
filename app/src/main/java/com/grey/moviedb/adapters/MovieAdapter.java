package com.grey.moviedb.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.grey.moviedb.R;
import com.grey.moviedb.itemviews.MovieItemView;
import com.grey.moviedb.models.Movie;

import java.util.List;

public class MovieAdapter extends BaseAdapter {

    private LayoutInflater layoutinflater;
    private List<Movie> movieList;
    private Context context;

    public MovieAdapter(Context context, List<Movie> customizedListView) {
        this.context = context;
        movieList = customizedListView;
    }

    @Override
    public int getCount() {
        return movieList.size();
    }

    @Override
    public Object getItem(int position) {
        return movieList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        layoutinflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView;

        if (convertView == null) {
            itemView = layoutinflater.inflate(R.layout.item_movie, parent, false);
        } else {
            itemView= (View) convertView;
        }
        new MovieItemView(itemView).bindMovie(movieList.get(position));
        return itemView;

    }

    public void refreshAdapter(List<Movie> movieList) {
        this.movieList = movieList;
        notifyDataSetChanged();
    }
}