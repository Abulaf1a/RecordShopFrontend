package com.northcoders.recordshopfrontend.model;


import androidx.databinding.Bindable;

public class Album {

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

    String genre;

    Stock stock;


    public Album(long id, String title, int releaseYear, String artist, String genre, Stock stock) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.artist = artist;
        this.genre = genre;
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
    public Stock getStock() {
        return stock;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
