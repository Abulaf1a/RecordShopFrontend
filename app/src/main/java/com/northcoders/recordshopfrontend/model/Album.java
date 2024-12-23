package com.northcoders.recordshopfrontend.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

public class Album extends BaseObservable implements Parcelable {

    Long id;

    String title;

    int releaseYear;

    String artist;

    String genre;

    String imgUrl;

    Stock stock;

    public Album(Long id, String title, int releaseYear, String artist, String genre , Stock stock, String imgUrl) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.artist = artist;
        this.genre = genre;
        this.imgUrl = imgUrl;
        this.stock = stock;
    }

    public Album() {
    }


    protected Album(Parcel in) {
        id = in.readLong();
        title = in.readString();
        releaseYear = in.readInt();
        artist = in.readString();
        genre = in.readString();
        imgUrl = in.readString();
        stock = in.readParcelable(Stock.class.getClassLoader(), Stock.class);
    }

    public static final Creator<Album> CREATOR = new Creator<Album>() {
        @Override
        public Album createFromParcel(Parcel in) {
            return new Album(in);
        }

        @Override
        public Album[] newArray(int size) {
            return new Album[size];
        }
    };

    @Bindable
    public long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public String getTitle() {
        return title;
    }
    @Bindable
    public String getReleaseYear() {
        return String.valueOf(releaseYear);
    }
    @Bindable
    public String getArtist() {
        return artist;
    }
    @Bindable
    public String getGenre() {
        return genre;
    }

    @Bindable
    public Stock getStock() {
        return stock;
    }

    public void setTitle(String title) {
        this.title = title;
        this.notifyPropertyChanged(BR.title);
    }

    public void setReleaseYear(String releaseYear) {
        if(releaseYear.isEmpty()){
            this.releaseYear = 0;
        }
        else{
            this.releaseYear = Integer.parseInt(releaseYear);
        }
        this.notifyPropertyChanged(BR.releaseYear);
    }

    public void setArtist(String artist) {
        this.artist = artist;
        this.notifyPropertyChanged(BR.artist);
    }

    public void setGenre(String genre) {
        this.genre = genre;
        this.notifyPropertyChanged(BR.genre);
    }

    public void setStock(Stock stock) {
        this.stock = stock;
        this.notifyPropertyChanged(BR.stock);
    }

    @Bindable
    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        this.notifyPropertyChanged(BR.imgUrl);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(title);
        dest.writeInt(releaseYear);
        dest.writeString(artist);
        dest.writeString(genre);
        dest.writeString(imgUrl);
        dest.writeParcelable(stock, flags);
    }

    @Override
    public String toString() {
        String stockStr = "null";

        if(stock != null){
             stockStr = getStock().toString();

        }

        return "Album{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                ", artist='" + artist + '\'' +
                ", genre='" + genre + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", stock=" + stockStr +
                '}';
    }
}
