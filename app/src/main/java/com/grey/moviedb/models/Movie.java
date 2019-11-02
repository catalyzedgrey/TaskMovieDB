package com.grey.moviedb.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Movie {
    int imgID;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("release_date")
    @Expose
    private String year;
    @SerializedName("poster_path")
    @Expose
    private String imgPath;
    @SerializedName("overview")
    @Expose
    private String overview;
    @SerializedName("vote_average")
    @Expose
    private String voteAvg;


    public Movie(String title, String year, String img) {
        this.title = title;
        this.year = year;
        this.imgPath = img;
    }

    public Movie(String title, String year, int imgID) {
        this.title = title;
        this.year = year;
        this.imgID = imgID;
    }


    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getImgPath() {
        return imgPath;
    }

    public int getImgID() {
        return imgID;
    }

    public String getOverview() {
        return overview;
    }

    public String getVoteAvg() {
        return voteAvg;
    }
}
