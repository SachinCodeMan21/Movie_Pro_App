package com.example.movieproapplication.repository;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.example.movieproapplication.R;
import com.example.movieproapplication.model.MovieModel;
import com.example.movieproapplication.model.Result;
import com.example.movieproapplication.service.MovieDataService;
import com.example.movieproapplication.service.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {
    ArrayList<MovieModel> movieList = new ArrayList<>();
    MutableLiveData<List<MovieModel>> mutableLiveDataList = new MutableLiveData<>();
    MovieDataService movieDataService;
    Application application;

    public MovieRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<MovieModel>> getMovieList(){
        movieDataService = RetrofitInstance.getService();
        Call<Result> call = movieDataService.getResult(application.getApplicationContext().getString(R.string.api_key));
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Result result = response.body();
                if (result != null && result.getResults() != null){
                    movieList = (ArrayList<MovieModel>) result.getResults();
                    mutableLiveDataList.setValue(movieList);
                }
            }
            @Override
            public void onFailure(Call<Result> call, Throwable t) {
            }
        });
        return mutableLiveDataList;
    }
}
