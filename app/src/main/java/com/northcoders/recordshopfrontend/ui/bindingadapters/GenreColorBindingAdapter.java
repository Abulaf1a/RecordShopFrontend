package com.northcoders.recordshopfrontend.ui.bindingadapters;

import android.content.Context;
import android.util.Log;
import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;
import com.northcoders.recordshopfrontend.R;
import java.lang.annotation.Annotation;

public class GenreColorBindingAdapter implements BindingAdapter {
    Context context;

    public GenreColorBindingAdapter(Context context) {
        this.context = context;
    }

    public int getGenreColour(String genre){

        switch (genre){
            case "POP":
                return ContextCompat.getColor(context, R.color.genrePop);
            case "ROCK":
                return ContextCompat.getColor(context, R.color.genreRock);
            case "INDIE":
                return ContextCompat.getColor(context,R.color.genreIndie);
            case "HIPHOP":
                return ContextCompat.getColor(context, R.color.genreHipHop);
            case "SOUL":
                return ContextCompat.getColor(context, R.color.genreSoul);
            case "FUNK":
                return ContextCompat.getColor(context, R.color.genreFunk);
            default:
                Log.i("GENRE COLOUR ERROR", "No colour assigned for genre: " + genre);
                return ContextCompat.getColor(context,R.color.white);
        }
    }

    @Override
    public String[] value() {
        return new String[0];
    }

    @Override
    public boolean requireAll() {
        return false;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
