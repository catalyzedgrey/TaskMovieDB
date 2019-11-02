package com.grey.moviedb.network;

import com.grey.moviedb.models.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieAPI {
    @GET("3/discover/movie?")
    Call<Result> getMovies(
            @Query("api_key") String apiKey,
            @Query("sort_by") String sortingOption
    );
}