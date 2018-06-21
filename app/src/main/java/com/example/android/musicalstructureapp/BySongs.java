package com.example.android.musicalstructureapp;

//custom class to be used to populate information in the list view that displays song information
public class BySongs {

    //variables
    private String mSongName;
    private String mArtistName;
    private String mAlbumName;
    private String mAlbumImage;

    //method that accepts values from the array and sets them
    public BySongs(String songName, String artistName, String albumName, String albumImage) {
        mSongName = songName;
        mArtistName = artistName;
        mAlbumName = albumName;
        mAlbumImage = albumImage;
    }

    //getters
    public String getSongName() {
        return mSongName;
    }

    public String getArtistName() {
        return mArtistName;
    }

    public String getAlbumName() {
        return mAlbumName;
    }

    public String getAlbumImage() {
        return mAlbumImage;
    }
}
