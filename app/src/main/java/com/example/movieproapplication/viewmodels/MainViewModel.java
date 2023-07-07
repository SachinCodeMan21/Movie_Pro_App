package com.example.movieproapplication.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.movieproapplication.model.MovieModel;
import com.example.movieproapplication.repository.MovieRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    MovieRepository movieRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        movieRepository = new MovieRepository(application);
    }

    public LiveData<List<MovieModel>> getAllMovies(){
        return movieRepository.getMovieList();
    }



}
