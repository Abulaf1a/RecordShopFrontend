package com.northcoders.recordshopfrontend.ui.editalbum;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.northcoders.recordshopfrontend.R;
import com.northcoders.recordshopfrontend.databinding.ActivityEditAlbumBinding;
import com.northcoders.recordshopfrontend.model.Album;
import com.northcoders.recordshopfrontend.model.Stock;
import com.northcoders.recordshopfrontend.ui.mainactivity.MainActivityViewModel;

public class EditAlbumActivity extends AppCompatActivity {

    EditAlbumClickHandler clickHandler;

    ActivityEditAlbumBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_album);

        binding = DataBindingUtil.setContentView(this,
                R.layout.activity_edit_album);

        MainActivityViewModel viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        Album album = getIntent().getParcelableExtra("ALBUM_PARCEL", Album.class);

        clickHandler = new EditAlbumClickHandler(album, this, viewModel);

        binding.setAlbum(album);

        binding.setClickHandlers(clickHandler);

    }
}