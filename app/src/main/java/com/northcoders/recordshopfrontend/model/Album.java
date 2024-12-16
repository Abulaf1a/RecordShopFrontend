package com.northcoders.recordshopfrontend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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


}
