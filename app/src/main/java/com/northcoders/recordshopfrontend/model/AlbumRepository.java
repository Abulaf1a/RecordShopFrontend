package com.northcoders.recordshopfrontend.model;

import android.app.Application;
import android.util.Log;

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

    public AlbumRepository(Application application){
        this.application = application;
    }

    public MutableLiveData<List<Album>> getMutableLiveData(){

        AlbumApiService albumApiService = RetrofitInstance.getService();

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
}
