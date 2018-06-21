package com.example.android.musicalstructureapp;

//custom class to work with the array list
public class ByAlbumOrArtist {
    //variables
    private String mArtistName;
    private String mAlbumName;
    private int mAlbumArtistImage;

    //function to accept parameters from activity and set them
    public ByAlbumOrArtist(String artistName, String albumName, int albumArtistImage) {
        mArtistName = artistName;
        mAlbumName = albumName;
        mAlbumArtistImage = albumArtistImage;
    }

    //creation of getters
    public String getArtistName() {
        return mArtistName;
    }

    public String getAlbumName() {
        return mAlbumName;
    }

    public int getAlbumArtistImage() {
        return mAlbumArtistImage;
    }
}
