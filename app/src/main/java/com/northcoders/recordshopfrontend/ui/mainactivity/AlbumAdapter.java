package com.northcoders.recordshopfrontend.ui.mainactivity;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.northcoders.recordshopfrontend.R;
import com.northcoders.recordshopfrontend.databinding.AlbumItemBinding;
import com.northcoders.recordshopfrontend.model.Album;
import com.northcoders.recordshopfrontend.model.AlbumRepository;

import java.util.ArrayList;
import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {

    //https://developer.android.com/develop/ui/views/layout/recyclerview

    List<Album> albums;

    Context context;

    public AlbumAdapter(List<Album> albums, Context context) {
        this.albums = albums;
        this.context = context;

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
        return new AlbumViewHolder(albumItemBinding);
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

        Album album = albums.get(position);

        Glide.with(context)
        .load(album.getImgUrl())
        .into(holder.albumItemBinding.albumArt);

        holder.albumItemBinding.setAlbum(album);

    }

    /*returns the count/size of the list of items*/
    @Override
    public int getItemCount() {
        if (albums == null) {
            return 0;
        }
        return albums.size();
    }


    public static class AlbumViewHolder extends RecyclerView.ViewHolder{

        /*
        The ViewHolder is a Java class that stores the reference
        to the card layout views that have to be dynamically modified
        during the execution of the program by a list of data
        obtained either by online databases or added in some other
        way. In this case, it will be from the HTTP call to the backend API.
        */

        private AlbumItemBinding albumItemBinding;

        public AlbumViewHolder(AlbumItemBinding albumItemBinding){
            super(albumItemBinding.getRoot());
            this.albumItemBinding = albumItemBinding;
        }
    }
}
