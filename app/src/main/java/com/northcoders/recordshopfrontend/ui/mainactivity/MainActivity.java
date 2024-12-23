package com.northcoders.recordshopfrontend.ui.mainactivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.SearchView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.northcoders.recordshopfrontend.R;
import com.northcoders.recordshopfrontend.databinding.ActivityMainBinding;
import com.northcoders.recordshopfrontend.model.Album;
import com.northcoders.recordshopfrontend.model.AlbumRepository;
import com.northcoders.recordshopfrontend.ui.editalbum.EditAlbumActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Album> albums;
    AlbumAdapter albumAdapter;
    MainActivityViewModel mainActivityViewModel;
    ActivityMainBinding activityMainBinding;
    MainActivityClickHandler clickHandler;

    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        clickHandler = new MainActivityClickHandler(this);

        if(clickHandler != null){
            Log.i("PETER", "Main activity click handler initialised");
        }

        activityMainBinding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_main);

        activityMainBinding.setClickHandler(clickHandler);

        searchView = findViewById(R.id.searchView);
        searchView.clearFocus(); //not sure what this does.

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                Log.i("PETER", "TEXT submitted");
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                Log.i("PETER","text changed");
                if(newText != null){
                    filterItems(newText);
                }

                return false;
            }
        });

        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        Application application = this.getApplication();
        AlbumRepository repository = new AlbumRepository(application);


        repository.getMutableLiveData();

        getAllAlbums();
    }

    private void filterItems(String query){

        if(query != null){
            String queryLower = query.toLowerCase();

            List<Album> filteredAlbums
                = albums.stream()
                .filter(a ->
                        a.getTitle().toLowerCase()
                        .contains(queryLower))
                        .collect(Collectors.toList());

            Log.i("PETER", "filtered items ln = " + filteredAlbums.size());

            albumAdapter.setFilteredAlbums(filteredAlbums);
            displayInRecyclerView();

        }


    }

    private void getAllAlbums(){
        mainActivityViewModel.getAllAlbums().observe(this, albumsLive -> {
            albums = albumsLive;
            displayInRecyclerView();
        });
    }

    private void displayInRecyclerView(){

        if(recyclerView == null){
            recyclerView = activityMainBinding.recyclerView;
            recyclerView.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
            recyclerView.setHasFixedSize(true);
            albumAdapter = new AlbumAdapter(albums, this.getApplicationContext(),  clickHandler);
            recyclerView.setAdapter(albumAdapter);
        }

        albumAdapter.notifyDataSetChanged();
    }


}