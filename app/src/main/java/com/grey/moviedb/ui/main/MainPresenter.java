package com.grey.moviedb.ui.main;

import com.grey.moviedb.data.DataManager;
import com.grey.moviedb.data.network.model.Movie;
import com.grey.moviedb.data.network.model.Result;
import com.grey.moviedb.ui.base.BasePresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import javax.inject.Inject;

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V>
        implements MainMvpPresenter<V>, Callback<Result> {

    private static final String TAG = "MainPresenter";

    @Inject
    public MainPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void onViewInitialized() {
        getMvpView().showLoading();
        getDataManager().doMovieSearch().enqueue(this);
    }

    @Override
    public void onResponse(Call<Result> call, Response<Result> response) {
        if (response.isSuccessful()) {
            getMvpView().hideLoading();
            System.out.println(response);

            if (response.body().getResults() != null) {
                //Movie responses = response.body();
                getMvpView().updateMovieList(response.body().getResults());
            }
        }

    }


    @Override
    public void onFailure(Call<Result> call, Throwable t) {
        t.printStackTrace();


    }
}
