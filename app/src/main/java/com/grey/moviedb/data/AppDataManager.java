package com.grey.moviedb.data;

import android.content.Context;

import com.grey.moviedb.data.network.ApiHeader;
import com.grey.moviedb.data.network.model.Movie;
//import com.grey.moviedb.data.network.ApiHeader;
import com.grey.moviedb.data.network.ApiHelper;
import com.grey.moviedb.data.network.model.Result;
import com.grey.moviedb.di.ApplicationContext;

import javax.inject.Inject;

import retrofit2.Call;

public class AppDataManager implements DataManager {

    private static final String TAG = "AppDataManager";
    private final Context mContext;
    private final ApiHelper mApiHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          ApiHelper apiHelper){
        mContext = context;
        mApiHelper = apiHelper;
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHelper.getApiHeader();
    }

    @Override
    public Call<Result> doMovieSearch() {
        return mApiHelper.doMovieSearch();
    }
}
