package com.grey.moviedb.data.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.grey.moviedb.BuildConfig;
import com.grey.moviedb.data.network.model.Movie;
import com.grey.moviedb.data.network.model.MovieAPI;
import com.grey.moviedb.data.network.model.Result;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppApiHelper implements ApiHelper {
    private ApiHeader mApiHeader;

    @Inject
    public AppApiHelper(ApiHeader apiHeader) {
        mApiHeader = apiHeader;
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHeader;
    }

    @Override
    public Call<Result> doMovieSearch() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        MovieAPI movieAPI = retrofit.create(MovieAPI.class);

        Call<Result> call = movieAPI.getMovies(BuildConfig.API_KEY, MovieAPI.popularitySort);

        return  call;

    }

}
