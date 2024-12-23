package com.northcoders.recordshopfrontend.ui.addalbum;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.northcoders.recordshopfrontend.model.Stock;
import com.northcoders.recordshopfrontend.ui.mainactivity.MainActivity;
import com.northcoders.recordshopfrontend.ui.mainactivity.MainActivityViewModel;
import com.northcoders.recordshopfrontend.model.Album;


public class AddNewAlbumClickHandler {

    Album album;

    Context context;

    MainActivityViewModel mainActivityViewModel;


    public AddNewAlbumClickHandler(Album album, Context context, MainActivityViewModel mainActivityViewModel) {
        this.album = album;
        this.context = context;
        this.mainActivityViewModel = mainActivityViewModel;
    }

    public void submitBtnClick(View view){

        Log.i("ALBUM INFO", (album.getTitle() +  album.getArtist() + album.getReleaseYear()));

        if(album.getArtist() == null || album.getReleaseYear() == null ||  album.getTitle() == null){ //album.getGenre() == null ||
            Toast.makeText(context, "Please enter all fields", Toast.LENGTH_SHORT).show();
        }
        else{

            Stock stock = new Stock();

            stock.setQuantity(100);

            album.setStock(stock);

            mainActivityViewModel.addAlbum(album);

            switchToMain();
        }
    }

    public void backBtnClick(View view){

        Log.i("PETER","back button clicked from click handler!");

        switchToMain();

    }

    public void switchToMain(){

        //what context is this? do we need to use view.getContext() ?
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);

    }
}
