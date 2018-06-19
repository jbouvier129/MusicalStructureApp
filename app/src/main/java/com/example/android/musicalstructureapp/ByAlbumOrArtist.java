package com.example.android.musicalstructureapp;

public class ByAlbumOrArtist {
    private String mArtistName;
    private String mAlbumName;
    private int mAlbumArtistImage;

    public ByAlbumOrArtist(String artistName, String albumName, int albumArtistImage){
        mArtistName = artistName;
        mAlbumName = albumName;
        mAlbumArtistImage = albumArtistImage;
    }

    public String getArtistName(){
        return mArtistName;
    }

    public String getAlbumName(){
        return mAlbumName;
    }

    public int getAlbumArtistImage() { return mAlbumArtistImage; }
}
