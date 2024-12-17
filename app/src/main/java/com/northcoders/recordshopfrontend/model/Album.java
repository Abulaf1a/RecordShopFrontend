package com.northcoders.recordshopfrontend.model;




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
}
