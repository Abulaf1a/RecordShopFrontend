package com.northcoders.recordshopfrontend.model;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.northcoders.recordshopfrontend.service.AlbumApiService;
import com.northcoders.recordshopfrontend.service.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumRepository {

    private MutableLiveData<List<Album>> mutableLiveData = new MutableLiveData<>();

    private Application application;
    AlbumApiService albumApiService;

    public AlbumRepository(Application application){
        this.application = application;

        albumApiService = RetrofitInstance.getService();

    }

    public MutableLiveData<List<Album>> getMutableLiveData(){


        //this calls the api!
        Call<List<Album>> call = albumApiService.getAlbums();

        call.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {

                List<Album> albums = response.body();

                mutableLiveData.setValue(albums);

                if(albums != null){
                    albums.forEach(album -> Log.i("Album retrieved", album.toString()));
                }
                else{
                    Log.e("NULL ALBUMS ERROR", "no albums to print");
                }

            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {
                Log.e("Error in AlbumRepository", t.getMessage(), t);
            }
        });

        return mutableLiveData;

    }

    public void addNewAlbum(Album album){

        Log.i("PETER", album.toString());

        Call<Album> albumCall = albumApiService.postAlbum(album);

        albumCall.enqueue(new Callback<Album>() {
            @Override
            public void onResponse(Call<Album> call, Response<Album> response) {

                Toast.makeText(application, "New album added: " + album.title, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Album> call, Throwable t) {

                Log.i("PETER", "FAILURE to add book, exception is: " + t.getMessage());

                Toast.makeText(application, "Album failed to add: " + album.title +
                        " reason: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

    public void updateAlbum(Long id, Album album){

        Log.i("PETER", "updating album:" + album);

        Call<Album> albumCall = albumApiService.updateAlbum(id, album);

        albumCall.enqueue(new Callback<Album>() {
            @Override
            public void onResponse(Call<Album> call, Response<Album> response) {
                Toast.makeText(application, "Album updated: " + album.title, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Album> call, Throwable t) {
                Toast.makeText(application, "Album failed to update: " + album.title
                        + " Reason: " + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void deleteAlbum(Long id){

        Call<String> stringCall = albumApiService.deleteAlbum(id);

        stringCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Toast.makeText(application, "Album deleted: " + id, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(application, "Album failed to delete: " + id
                        + " Reason: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
