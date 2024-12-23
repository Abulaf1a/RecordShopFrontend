package com.northcoders.recordshopfrontend.ui.addalbum;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.northcoders.recordshopfrontend.R;
import com.northcoders.recordshopfrontend.databinding.ActivityAddNewAlbumBinding;
import com.northcoders.recordshopfrontend.model.Album;
import com.northcoders.recordshopfrontend.ui.mainactivity.MainActivityViewModel;

public class AddNewAlbumActivity extends AppCompatActivity {

    AddNewAlbumClickHandler clickHandler;

    ActivityAddNewAlbumBinding addNewAlbumBinding;

    Album album = new Album();

    MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_new_album);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        addNewAlbumBinding = DataBindingUtil.setContentView(this,
                R.layout.activity_add_new_album);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        clickHandler = new AddNewAlbumClickHandler(album, this, viewModel);

        addNewAlbumBinding.setClickHandlers(clickHandler);

        addNewAlbumBinding.setAlbum(album);
    }




}