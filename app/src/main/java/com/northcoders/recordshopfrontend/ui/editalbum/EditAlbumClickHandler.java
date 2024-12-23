package com.northcoders.recordshopfrontend.ui.editalbum;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.northcoders.recordshopfrontend.model.Album;
import com.northcoders.recordshopfrontend.ui.mainactivity.MainActivity;
import com.northcoders.recordshopfrontend.ui.mainactivity.MainActivityViewModel;

public class EditAlbumClickHandler {

    Album album;

    Context context;

    MainActivityViewModel viewModel;


    public EditAlbumClickHandler(Album album, Context context, MainActivityViewModel viewModel) {
        this.album = album;
        this.context = context;
        this.viewModel = viewModel;
    }

    public void submitBtnClick(View view){

        viewModel.updateAlbum(album);

        backBtnClick(view);

    }

    public void deleteBtnClick(View view){

        viewModel.deleteAlbum(album.getId());

        backBtnClick(view);

    }

    public void backBtnClick(View view){

        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);

    }
}
