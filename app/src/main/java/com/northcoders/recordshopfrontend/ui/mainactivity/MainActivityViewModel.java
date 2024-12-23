package com.northcoders.recordshopfrontend.ui.mainactivity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.northcoders.recordshopfrontend.model.Album;
import com.northcoders.recordshopfrontend.model.AlbumRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    //viewmodel gets data from repository
    private AlbumRepository albumRepository;


    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.albumRepository = new AlbumRepository(application);
    }

    //this caches the data so if there are any config changes, it doesnt need to make
    //another api call.
    public LiveData<List<Album>> getAllAlbums(){return albumRepository.getMutableLiveData();
    }

    public void addAlbum(Album album){

        albumRepository.addNewAlbum(album);
    }

    public void updateAlbum(Album album){
        albumRepository.updateAlbum(album.getId(), album);
    }

    //update and delete mehtods here!
    public void deleteAlbum(Long id){
        albumRepository.deleteAlbum(id);
    }
}
