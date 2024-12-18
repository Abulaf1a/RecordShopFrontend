package com.northcoders.recordshopfrontend.ui.mainactivity;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.northcoders.recordshopfrontend.R;
import com.northcoders.recordshopfrontend.databinding.ActivityMainBinding;
import com.northcoders.recordshopfrontend.model.Album;
import com.northcoders.recordshopfrontend.model.AlbumRepository;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Album> albums;
    AlbumAdapter albumAdapter;
    MainActivityViewModel mainActivityViewModel;
    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        activityMainBinding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_main);
        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        Application application = this.getApplication();
        AlbumRepository repository = new AlbumRepository(application);
        repository.getMutableLiveData();
        getAllAlbums();
    }

    private void getAllAlbums(){
        mainActivityViewModel.getAllAlbums().observe(this, albumsLive -> {
            albums = albumsLive;
            displayInRecyclerView();
        });
    }

    private void displayInRecyclerView(){

        //we're creating a new adapter every time!
        recyclerView = activityMainBinding.recyclerView;

        albumAdapter = new AlbumAdapter(albums, this.getApplicationContext());

        recyclerView.setAdapter(albumAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));

        recyclerView.setHasFixedSize(true);

        albumAdapter.notifyDataSetChanged();
    }
}