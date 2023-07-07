package com.example.movieproapplication.service;

import com.example.movieproapplication.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieDataService {
    @GET("movie/popular")
    Call<Result> getResult(@Query("api_key") String apiKey);
}
