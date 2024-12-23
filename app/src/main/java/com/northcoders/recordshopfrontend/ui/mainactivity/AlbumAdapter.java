package com.northcoders.recordshopfrontend.ui.mainactivity;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.northcoders.recordshopfrontend.R;
import com.northcoders.recordshopfrontend.databinding.AlbumItemBinding;
import com.northcoders.recordshopfrontend.model.Album;
import com.northcoders.recordshopfrontend.ui.bindingadapters.GenreColorBindingAdapter;

import java.util.List;
import java.util.Objects;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {

    //https://developer.android.com/develop/ui/views/layout/recyclerview

    List<Album> albums;

    Context context;

    private RecyclerViewInterface recyclerViewInterface;

    MainActivityClickHandler clickHandler;

    public AlbumAdapter(List<Album> albums, Context context,  MainActivityClickHandler clickHandler) {
        this.albums = albums;
        this.context = context;
        this.clickHandler = clickHandler;

    }

    /*
    * Called to create the view holder
    * and return it*/
    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        AlbumItemBinding albumItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(
                    parent.getContext()),
                R.layout.album_item,
                parent,
                false);

        return new AlbumViewHolder(albumItemBinding, recyclerViewInterface);
    }

    /*
    * The onBindViewHolder() method is responsible for binding the
    * data from your dataset to the views within the ViewHolder.
    * It is called by the RecyclerView when an item is about to be
    * displayed in the UI (when it's scrolled on, or if the contents
    * of the item need to be updated) and fetches the appropriate data.
     */
    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {

        Log.i("PETER", "ALBUMS size in onBindViewHolder = " + albums.size());

        Album album = albums.get(position);

        if(album.getImgUrl() == null || album.getImgUrl().isEmpty()){
            Glide.with(context)
                    .load(R.drawable.question)
                    .into(holder.albumItemBinding.albumArt);
        }
        else{
            Glide.with(context)
                    .load(album.getImgUrl())
                    .into(holder.albumItemBinding.albumArt);
        }

        holder.albumItemBinding.setAlbum(album);

        GenreColorBindingAdapter colourAdapter = new GenreColorBindingAdapter(context);

        holder.albumItemBinding.setColourAdapter(colourAdapter);

        holder.albumItemBinding.setClickHandler(clickHandler);

    }

    /*returns the count/size of the list of items*/
    @Override
    public int getItemCount() {
        if (albums == null) {
            return 0;
        }
        return albums.size();
    }

    public void setFilteredAlbums(List<Album> filteredAlbums){
        Log.i("PETER", "FILTERED ITEMS = " + filteredAlbums.size());
        albums = filteredAlbums;
        Log.i("PETER", "ALBUMS = " + albums.size());
    }

    /*
           The ViewHolder is a Java class that stores the reference
           to the card layout views that have to be dynamically modified
           during the execution of the program by a list of data
           obtained either by online databases or added in some other
           way. In this case, it will be from the HTTP call to the backend API.
           */
    public static class AlbumViewHolder extends RecyclerView.ViewHolder{

        private AlbumItemBinding albumItemBinding;



        public AlbumViewHolder(AlbumItemBinding albumItemBinding, RecyclerViewInterface recyclerViewInterface){
            super(albumItemBinding.getRoot());
            this.albumItemBinding = albumItemBinding;
        }
    }
}
