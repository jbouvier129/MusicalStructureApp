package com.example.android.musicalstructureapp;


public class BySongs {

    private String mSongName;
    private String mArtistName;
    private String mAlbumName;
    private String mAlbumImage;

    public BySongs(String songName, String artistName, String albumName, String albumImage) {
            mSongName = songName;
            mArtistName = artistName;
            mAlbumName = albumName;
        mAlbumImage = albumImage;
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

    public String getmAlbumImage() {
        return mAlbumImage;
    }
}
