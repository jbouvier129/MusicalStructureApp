package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //variables
    boolean isPlaying;
    String selectedSong;
    String fromAlbum;
    String artist;
    String songAlbumImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //receive intents from the songs activity
        selectedSong = getIntent().getStringExtra("selectedSong");
        fromAlbum = getIntent().getStringExtra("fromAlbum");
        artist = getIntent().getStringExtra("byArtist");
        songAlbumImage = getIntent().getStringExtra("albumImage");
        isPlaying = getIntent().getBooleanExtra("isPlaying", isPlaying);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        /*this determines if the activity was opened from the songs activity
        if it was selected song will not be null so it then changes the image view from the default one to the album image for
        the selected song and populates the nulled text views
        */
        if (selectedSong != null) {
            ImageView albumArt = findViewById(R.id.albumImage);
            int id = getResources().getIdentifier(songAlbumImage, "drawable", MainActivity.this.getPackageName());
            Drawable test = MainActivity.this.getResources().getDrawable(id);
            albumArt.setImageDrawable(test);
            TextView songView = findViewById(R.id.song_name_text_view);
            songView.setText(selectedSong);
            TextView artistView = findViewById(R.id.artist_name_text_view);
            artistView.setText(artist);
            TextView albumView = findViewById(R.id.album_name_text_view);
            albumView.setText(fromAlbum);
        }

        // Finds the artist button used for navigation
        Button byArtist = findViewById(R.id.byArtist);

        // Set a click listener
        byArtist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // intent to open the artists activity
                Intent byArtistIntent = new Intent(MainActivity.this, ArtistsActivity.class);

                // Starts artists
                startActivity(byArtistIntent);
            }
        });

        // Find the album button used for navigation
        Button byAlbum = findViewById(R.id.byAlbum);

        // Set a click listener
        byAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // intent to start the albums activity
                Intent byAlbumIntent = new Intent(MainActivity.this, AlbumsActivity.class);

                // Starts albums
                startActivity(byAlbumIntent);
            }
        });

        // Find the song button used for navigation
        Button bySong = findViewById(R.id.bySong);

        // Set a click listener
        bySong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // intent to open the songs activity
                Intent bySongIntent = new Intent(MainActivity.this, SongsActivity.class);

                // Start songs
                startActivity(bySongIntent);
            }
        });
        //finds previous button used for song controls
        Button previous = findViewById(R.id.previous);

        //Set a click listener
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (selectedSong != null) {
                    Toast.makeText(MainActivity.this, "playing previous song", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(MainActivity.this, "No Track Playing. Function not available", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //finds play/Pause button used for song controls
        Button playPause = findViewById(R.id.playPause);

        //Set a click listener....This also will determine if the last state was play or pause and switch it accordingly
        playPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedSong != null) {
                    if (isPlaying) {
                        Toast.makeText(MainActivity.this, "Pausing Playback", Toast.LENGTH_SHORT).show();
                        isPlaying = false;
                    } else {
                        Toast.makeText(MainActivity.this, "Resuming Playback", Toast.LENGTH_SHORT).show();
                        isPlaying = true;
                    }
                }
                //used to insure the user selects a song
                else {
                    Toast.makeText(MainActivity.this, "Please select a song", Toast.LENGTH_SHORT).show();
                    Intent errorCatch = new Intent(MainActivity.this, SongsActivity.class);
                    startActivity(errorCatch);
                }

            }
        });

        //finds skip button used for song controls
        Button skip = findViewById(R.id.skip);

        //Set a click listener
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedSong != null) {
                    Toast.makeText(MainActivity.this, "Skipped to next song", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "No Track Playing. Function not available", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}