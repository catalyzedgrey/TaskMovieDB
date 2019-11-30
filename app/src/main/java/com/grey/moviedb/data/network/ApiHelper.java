package com.grey.moviedb.data.network;

import com.grey.moviedb.data.network.model.*;

import retrofit2.Call;

public interface ApiHelper {
    ApiHeader getApiHeader();

    Call<Result> doMovieSearch();
//
//    Single<LoginResponse> doFacebookLoginApiCall(LoginRequest.FacebookLoginRequest request);
//
//    Single<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request);
//
//    Single<LogoutResponse> doLogoutApiCall();
//
//    Single<BlogResponse> getBlogApiCall();
//
//    Single<OpenSourceResponse> getOpenSourceApiCall();
}
