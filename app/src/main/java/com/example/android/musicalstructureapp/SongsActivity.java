package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

public class SongsActivity extends AppCompatActivity {
    //variables from other activities
    String albumNameFromAlbums;
    String artistNameFromArtists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        setTitle("Songs Activity");

        //gets extra's from the intents that launch this activity used to help determine displayed track list
        albumNameFromAlbums = getIntent().getStringExtra("albumNameFromAlbums");
        artistNameFromArtists = getIntent().getStringExtra("artistsNameFromArtists");

        // Find the artist button used for navigation
        Button byArtist = findViewById(R.id.byArtist);

        // Set a click listener
        byArtist.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // intent to launch the artists activity
                Intent byArtistIntent = new Intent(SongsActivity.this, ArtistsActivity.class);

                // Start artists
                startActivity(byArtistIntent);
                finish();
            }
        });

        // Find the album button used for navigation
        Button byAlbum = findViewById(R.id.byAlbum);

        // Set a click listener
        byAlbum.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the family category is clicked on.
            @Override
            public void onClick(View view) {
                // intent to launch the albums activity
                Intent byAlbumIntent = new Intent(SongsActivity.this, AlbumsActivity.class);

                // Start albums
                startActivity(byAlbumIntent);
                finish();
            }
        });

        //array containing song information and relevant info
        final ArrayList<BySongs> trackList = new ArrayList<BySongs>();

        trackList.add(new BySongs("track 1", "band 1", "band 1 album", "artist_1_album"));
        trackList.add(new BySongs("track 2", "band 1", "band 1 album", "artist_1_album"));
        trackList.add(new BySongs("track 3", "band 1", "band 1 album", "artist_1_album"));
        trackList.add(new BySongs("track 1", "band 2", "band 2 album", "artist_2_album"));
        trackList.add(new BySongs("track 2", "band 2", "band 2 album", "artist_2_album"));
        trackList.add(new BySongs("track 1", "band 3", "band 3 album", "artist_3_album"));
        trackList.add(new BySongs("track 2", "band 3", "band 3 album", "artist_3_album"));
        trackList.add(new BySongs("track 1", "band 4", "band 4 album", "artist_4_album"));
        trackList.add(new BySongs("track 2", "band 4", "band 4 album", "artist_4_album"));
        trackList.add(new BySongs("track 3", "band 4", "band 4 album", "artist_4_album"));
        trackList.add(new BySongs("track 1", "band 5", "band 5 album", "artist_5_album"));
        trackList.add(new BySongs("track 2", "band 5", "band 5 album", "artist_5_album"));
        trackList.add(new BySongs("track 1", "band 6", "band 6 album", "artist_6_album"));
        trackList.add(new BySongs("track 2", "band 6", "band 6 album", "artist_6_album"));
        trackList.add(new BySongs("track 1", "band 7", "band 7 album", "artist_7_album"));
        trackList.add(new BySongs("track 2", "band 7", "band 7 album", "artist_7_album"));
        trackList.add(new BySongs("track 1", "band 8", "band 8 album", "artist_8_album"));
        trackList.add(new BySongs("track 1", "band 9", "band 9 album", "artist_9_album"));
        trackList.add(new BySongs("track 2", "band 9", "band 9 album", "artist_9_album"));
        trackList.add(new BySongs("track 1", "band 10", "band 10 album", "artist_10_album"));
        trackList.add(new BySongs("track 2", "band 10", "band 10 album", "artist_10_album"));
        trackList.add(new BySongs("track 1", "band 11", "band 11 album", "artist_11_album"));
        trackList.add(new BySongs("track 2", "band 11", "band 11 album", "artist_11_album"));
        trackList.add(new BySongs("track 1", "band 12", "band 12 album", "artist_12_album"));
        trackList.add(new BySongs("track 2", "band 12", "band 12 album", "artist_12_album"));

        /*This determines if the activity was called from one of the activities that pass intents which are used here
        as parameters to alter the displayed songs list. If launched from main all will display. If launched from another
        activity, the selected item gets passed here. Then the array list is iterated over removing all values that do not
        contain the passed intent value effectively making it so only relevant songs to the selected album or artist are displayed
         */
        if (albumNameFromAlbums != null) {
            Iterator<BySongs> delete = trackList.iterator();
            while (delete.hasNext()) {
                if (!delete.next().getAlbumName().equals(albumNameFromAlbums)) {
                    delete.remove();
                }
            }
        } else if (artistNameFromArtists != null) {
            Iterator<BySongs> delete = trackList.iterator();
            while (delete.hasNext()) {
                if (!delete.next().getArtistName().equals(artistNameFromArtists)) {
                    delete.remove();
                }
            }
        }
        //starts the adapter used to take the array information and populate it in the list view
        BySongsAdapter songsAdapter = new BySongsAdapter(this, trackList);
        //finds the view and populates it using the adapter
        ListView listView = findViewById(R.id.linearList);
        listView.setAdapter(songsAdapter);

        //click listener to determine selected song, retrieve information from it and pass it back to main/now playing
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String artistSelection = trackList.get(position).getArtistName();
                String albumSelection = trackList.get(position).getAlbumName();
                String songSelection = trackList.get(position).getSongName();
                String albumCover = trackList.get(position).getAlbumImage();
                boolean isPlaying = true;

                Intent selectedSong = new Intent(SongsActivity.this, MainActivity.class);
                selectedSong.putExtra("selectedSong", songSelection);
                selectedSong.putExtra("fromAlbum", albumSelection);
                selectedSong.putExtra("byArtist", artistSelection);
                selectedSong.putExtra("albumImage", albumCover);
                selectedSong.putExtra("isPlaying", isPlaying);
                Toast.makeText(SongsActivity.this, "Now Playing: " + songSelection + " by: " + artistSelection, Toast.LENGTH_SHORT).show();
                startActivity(selectedSong);
                finish();
            }
        });
    }
}
