package com.example.movieproapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Result extends BaseObservable implements Parcelable {

    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("results")
    @Expose
    private List<MovieModel> results;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;
    @SerializedName("total_results")
    @Expose
    private Integer totalResults;



    // Parcelable Creator
    public final static Parcelable.Creator<Result> CREATOR = new Creator<Result>() {
        @Override
        public Result createFromParcel(Parcel parcel) {
            return new Result(parcel);
        }

        @Override
        public Result[] newArray(int i) {
            return (new Result[i]);
        }
    };






    @Bindable
    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
        notifyPropertyChanged(BR.page);
    }

    @Bindable
    public List<MovieModel> getResults() {
        return results;
    }

    public void setResults(List<MovieModel> results) {
        this.results = results;
        notifyPropertyChanged(BR.results);
    }

    @Bindable
    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
        notifyPropertyChanged(BR.totalPages);
    }

    @Bindable
    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
        notifyPropertyChanged(BR.totalResults);
    }


    // Constructors of MovieModel

    public Result() {
    }

    public Result(Parcel in) {
        this.page = ((Integer) in.readValue(Integer.class.getClassLoader()));
        this.totalResults = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.totalPages = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.results,com.example.movieproapplication.model.MovieModel.class.getClassLoader());
    }



    // Ovveriding the Parcelable methods

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int flags) {
        parcel.writeValue(page);
        parcel.writeValue(totalResults);
        parcel.writeValue(totalPages);
        parcel.writeList(results);
    }
}
