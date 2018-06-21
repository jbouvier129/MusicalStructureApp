package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;

public class ArtistsActivity extends AppCompatActivity {

    //variable to hold the value of the function used to determine the artist at the selected grid item
    String selection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_view);

        //listener activities to navigate to the other activities
        // Find album button for navigation
        Button byAlbum = findViewById(R.id.byAlbum);

        // Set a click listener
        byAlbum.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the family category is clicked on.
            @Override
            public void onClick(View view) {
                // intent to go to albums activity
                Intent byAlbumIntent = new Intent(ArtistsActivity.this, AlbumsActivity.class);

                // Start albums activity
                startActivity(byAlbumIntent);
            }
        });

        // Find songs button for navigation
        Button bySong = findViewById(R.id.bySong);

        // Set a click listener
        bySong.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the colors category is clicked on.
            @Override
            public void onClick(View view) {
                // intent to go to songs activity
                Intent bySongIntent = new Intent(ArtistsActivity.this, SongsActivity.class);

                // Start songs
                startActivity(bySongIntent);
            }
        });

        //array to hold artist information for the screen to be used via the adapter
        final ArrayList<ByAlbumOrArtist> albumArtistInfo = new ArrayList<ByAlbumOrArtist>();

        albumArtistInfo.add(new ByAlbumOrArtist("band 1", null, R.drawable.artist_1));
        albumArtistInfo.add(new ByAlbumOrArtist("band 2", null, R.drawable.artist_2));
        albumArtistInfo.add(new ByAlbumOrArtist("band 3", null, R.drawable.artist_3));
        albumArtistInfo.add(new ByAlbumOrArtist("band 4", null, R.drawable.artist_4));
        albumArtistInfo.add(new ByAlbumOrArtist("band 5", null, R.drawable.artist_5));
        albumArtistInfo.add(new ByAlbumOrArtist("band 6", null, R.drawable.artist_6));
        albumArtistInfo.add(new ByAlbumOrArtist("band 7", null, R.drawable.artist_7));
        albumArtistInfo.add(new ByAlbumOrArtist("band 8", null, R.drawable.artist_8));
        albumArtistInfo.add(new ByAlbumOrArtist("band 9", null, R.drawable.artist_9));
        albumArtistInfo.add(new ByAlbumOrArtist("band 10", null, R.drawable.artist_10));
        albumArtistInfo.add(new ByAlbumOrArtist("band 11", null, R.drawable.artist_11));
        albumArtistInfo.add(new ByAlbumOrArtist("band 12", null, R.drawable.artist_12));

        //populates adapter with information from the array
        ByAlbumOrArtistAdapter aAAdapter = new ByAlbumOrArtistAdapter(this, albumArtistInfo);
        //sets the view with information from the adapter
        GridView gridView = findViewById(R.id.gridList);
        gridView.setAdapter(aAAdapter);

        //listener to determine selected grid item and retrieve artist information
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //gets artist info from user selection
                selection = albumArtistInfo.get(position).getArtistName();

                //intent to call songs activity and pass it the artist parameter
                Intent artistSongs = new Intent(ArtistsActivity.this, SongsActivity.class);
                artistSongs.putExtra("artistsNameFromArtists", selection);

                //start songs
                startActivity(artistSongs);
            }
        });

    }

}
