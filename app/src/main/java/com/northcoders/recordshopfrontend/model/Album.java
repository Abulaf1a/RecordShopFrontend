package com.northcoders.recordshopfrontend.model;


import android.graphics.Color;
import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

public class Album extends BaseObservable {

    //JSON structure
    /*
        "id": 1,
        "title": " ",
        "releaseYear": ,
        "artist": "",
        "genre": "POP",
        "stock": {
            "id": 1,
            "quantity": 22
        }
    */

    long id;

    String title;

    int releaseYear;

    String artist;

    String imgUrl;

    String genre;

    Stock stock;


    public Album(long id, String title, int releaseYear, String artist, String genre , Stock stock, String imgUrl) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.artist = artist;
        this.genre = genre;
        this.imgUrl = imgUrl;
        this.stock = stock;
    }

    public Album() {
    }

    //if any field names differ from model attribute names, use @SerializedName(value = "")
    @Bindable
    public long getId() {
        return id;
    }
    @Bindable
    public String getTitle() {
        return title;
    }
    @Bindable
    public int getReleaseYear() {
        return releaseYear;
    }
    @Bindable
    public String getArtist() {
        return artist;
    }
    @Bindable
    public String getGenre() {
        return genre;
    }

    @Bindable
    public int getColour(){
        String colour = "#FFFFFF";
        switch (genre){
            case "POP":
                colour = "#B300FF";
                break;

            case "ROCK":

                colour = "#EC00FF";

                break;

            default:

                Log.i("GENRE COLOUR ERROR", "No colour assigned for genre " + genre);
        }
        return Color.parseColor(colour);

    }
    @Bindable
    public Stock getStock() {
        return stock;
    }

    public void setId(long id) {
        this.id = id;
        this.notifyPropertyChanged(BR.id);
    }

    public void setTitle(String title) {
        this.title = title;
        this.notifyPropertyChanged(BR.title);
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
        this.notifyPropertyChanged(BR.releaseYear);
    }

    public void setArtist(String artist) {
        this.artist = artist;
        this.notifyPropertyChanged(BR.artist);
    }

    public void setGenre(String genre) {
        this.genre = genre;
        this.notifyPropertyChanged(BR.genre);
    }

    public void setStock(Stock stock) {
        this.stock = stock;
        this.notifyPropertyChanged(BR.stock);
    }

    @Bindable
    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        this.notifyPropertyChanged(BR.imgUrl);
    }
}
