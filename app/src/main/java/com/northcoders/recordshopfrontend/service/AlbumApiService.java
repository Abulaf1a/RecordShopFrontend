package com.northcoders.recordshopfrontend.service;

import com.northcoders.recordshopfrontend.model.Album;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AlbumApiService {

    @GET("album")
    Call<List<Album>> getAlbums();

    //could be void -- we don't really need it to return anything.
    @POST("album")
    Call<Album> postAlbum(@Body Album album);

    @PUT("album/{id}")
    Call<Album> updateAlbum(@Path("id") Long id, @Body Album albumNoId);

    @DELETE("album/{id}")
    Call<String> deleteAlbum(@Path("id") Long id);

}
