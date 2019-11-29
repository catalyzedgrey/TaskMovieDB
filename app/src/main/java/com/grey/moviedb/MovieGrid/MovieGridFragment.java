package com.grey.moviedb.MovieGrid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.grey.moviedb.R;
import com.grey.moviedb.adapters.MovieAdapter;
import com.grey.moviedb.main.MainActivity;
import com.grey.moviedb.models.Movie;

import java.util.ArrayList;

public class MovieGridFragment extends Fragment implements MovieGridContract.View {

    private MovieGridContract.Presenter mPresenter;
    private MovieAdapter mListAdapter;

    MainActivity.MovieItemListener movieItemListener = new MainActivity.MovieItemListener() {
        @Override
        public void onTaskClick(Movie clickedMovie) {
            mPresenter.openMovieDetails(clickedMovie);
        }
    };

    public MovieGridFragment(){

    }

    public static MovieGridFragment newInstance() {
        return new MovieGridFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mListAdapter = new MovieAdapter(getActivity(), new ArrayList<Movie>(0), movieItemListener);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.frag_movie_grid, container, false);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void setPresenter(@NonNull MovieGridContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showMovieDetailsUi(Movie movie) {

    }
}
