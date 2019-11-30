package com.grey.moviedb.data.network.model;

import com.grey.moviedb.BuildConfig;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieAPI {
    public final String IMG_URL = "https://image.tmdb.org/t/p/w500/";
    public final String popularitySort =  "popularity.desc";

    @GET("3/discover/movie?")
    Call<Result> getMovies(
            @Query("api_key") String apiKey,
            @Query("sort_by") String sortingOption
    );
}
