package com.example.movieproapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieproapplication.MovieActivity;
import com.example.movieproapplication.R;
import com.example.movieproapplication.databinding.MovieListItemBinding;
import com.example.movieproapplication.model.MovieModel;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    Context context;
    ArrayList<MovieModel> movieArrayList;

    public MovieAdapter(Context context, ArrayList<MovieModel> movieArrayList) {
        this.context = context;
        this.movieArrayList = movieArrayList;
    }

    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MovieListItemBinding movieListItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.movie_list_item,
                parent,false);
        return new ViewHolder(movieListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.ViewHolder holder, int position) {
        MovieModel movie = movieArrayList.get(position);
        holder.movieListItemBinding.setMovie(movie);

    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        MovieListItemBinding movieListItemBinding;
        public ViewHolder(@NonNull MovieListItemBinding movieListItemBinding) {
            super(movieListItemBinding.getRoot());
            this.movieListItemBinding = movieListItemBinding;
            movieListItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if (position != RecyclerView.NO_POSITION){
                        MovieModel selectedMovie = movieArrayList.get(position);

                        Intent i = new Intent(context, MovieActivity.class);
                        i.putExtra("movie", selectedMovie);
                        context.startActivity(i);

                    }
                }
            });
        }

    }
}
