package com.northcoders.recordshopfrontend.service;

import com.northcoders.recordshopfrontend.model.Album;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AlbumApiService {

    @GET("album")
    public Call<List<Album>> getAlbums();
}
