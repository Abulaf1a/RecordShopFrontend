package com.northcoders.recordshopfrontend.ui.mainactivity;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.northcoders.recordshopfrontend.model.Album;
import com.northcoders.recordshopfrontend.ui.addalbum.AddNewAlbumActivity;
import com.northcoders.recordshopfrontend.ui.editalbum.EditAlbumActivity;

public class MainActivityClickHandler {

    Context context;

    public MainActivityClickHandler(Context context) {
        this.context = context;
        Log.i("PETER", "Main activity constructor");
    }

    public void addAlbumBtnClick(View view){
        Log.i("BUTTON", "add album button clicked");
        switchToAddNewAlbum(view);
    }

    public void switchToAddNewAlbum(View view){

        Intent intent = new Intent(context, AddNewAlbumActivity.class);
        context.startActivity(intent);

    }

    public void editAlbumCardClick(Album album) {
        Log.i("PETER", "click handler edit album card method called");
        Log.i("PETER", "clicked card is:" + album.toString());
        Intent intent = new Intent(context, EditAlbumActivity.class);
        intent.putExtra("ALBUM_PARCEL", album);
        context.startActivity(intent);
    }
}
