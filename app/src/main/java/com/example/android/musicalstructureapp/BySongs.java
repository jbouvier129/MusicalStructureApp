package com.example.android.musicalstructureapp;


public class BySongs {

    private String mSongName;
    private String mArtistName;
    private String mAlbumName;

    public BySongs(String songName, String artistName, String albumName){
            mSongName = songName;
            mArtistName = artistName;
            mAlbumName = albumName;
        }

        public String getSongName(){
            return mSongName;
        }

        public String getArtistName(){
            return mArtistName;
        }

        public String getAlbumName(){
            return mAlbumName;
        }
}
