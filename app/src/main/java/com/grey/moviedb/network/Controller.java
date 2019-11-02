package com.grey.moviedb.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.grey.moviedb.activities.MainActivity;
import com.grey.moviedb.adapters.MovieAdapter;
import com.grey.moviedb.models.Result;
import com.grey.moviedb.utils.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.grey.moviedb.utils.Constants.BASE_URL;

public class Controller implements Callback<Result> {
    MovieAdapter adapter;

    public void start(MovieAdapter adapter) {
        this.adapter = adapter;
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        MovieAPI movieAPI = retrofit.create(MovieAPI.class);

        Call<Result> call = movieAPI.getMovies(Constants.API_KEY, Constants.popularitySort);
        call.enqueue(this);

    }

    @Override
    public void onResponse(Call<Result> call, Response<Result> response) {
        if (response.isSuccessful()) {
//            System.out.println(response);
            if (response.body().getResults() != null) {
                adapter.refreshAdapter(response.body().getResults());
                MainActivity.hideSpinner();
            }


        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<Result> call, Throwable t) {
        t.printStackTrace();
    }
}
