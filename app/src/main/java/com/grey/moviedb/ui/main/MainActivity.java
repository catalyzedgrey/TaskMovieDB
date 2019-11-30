package com.grey.moviedb.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;

import com.grey.moviedb.R;
import com.grey.moviedb.data.network.model.Movie;
import com.grey.moviedb.ui.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends BaseActivity implements MainMvpView {

    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;

    @BindView(R.id.grid)
    GridView grid;
    private Unbinder mUnBinder;

    private MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        movieAdapter = new MovieAdapter(new ArrayList<>(0));
        grid.setAdapter(movieAdapter);
        mPresenter.onAttach(this);
        mPresenter.onViewInitialized();

    }
    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    public void onError(int resId) {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showMessage(int resId) {

    }

    @Override
    public boolean isNetworkConnected() {
        return false;
    }

    @Override
    public void hideKeyboard() {

    }

    public void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }

    @Override
    public void openMovieDetailsActivity() {

    }

    @Override
    public void updateMovieList(List<Movie> movieList) {
        movieAdapter.refreshAdapter(movieList);
    }
}
