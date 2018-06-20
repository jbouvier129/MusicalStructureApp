package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    boolean isPlaying;
    String selectedSong;
    String fromAlbum;
    String artist;
    String albumImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        selectedSong = getIntent().getStringExtra("selectedSong");
        fromAlbum = getIntent().getStringExtra("fromAlbum");
        artist = getIntent().getStringExtra("byArtist");
        albumImage = getIntent().getStringExtra("albumImage");
        isPlaying = getIntent().getBooleanExtra("isPlaying", isPlaying);


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

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Find the View that shows the numbers category
        Button byArtist = findViewById(R.id.byArtist);

        // Set a click listener on that View
        byArtist.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent byArtistIntent = new Intent(MainActivity.this, Artists.class);

                // Start the new activity
                startActivity(byArtistIntent);
            }
        });

        // Find the View that shows the family category
        Button byAlbum = findViewById(R.id.byAlbum);

        // Set a click listener on that View
        byAlbum.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the family category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link FamilyActivity}
                Intent byAlbumIntent = new Intent(MainActivity.this, Albums.class);

                // Start the new activity
                startActivity(byAlbumIntent);
            }
        });

        // Find the View that shows the colors category
        Button bySong = findViewById(R.id.bySong);

        // Set a click listener on that View
        bySong.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the colors category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link ColorsActivity}
                Intent bySongIntent = new Intent(MainActivity.this, Songs.class);

                // Start the new activity
                startActivity(bySongIntent);
            }
        });
        Button previous = findViewById(R.id.previous);

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
        Button playPause = findViewById(R.id.playPause);

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
                } else {
                    Toast.makeText(MainActivity.this, "Please select a song", Toast.LENGTH_SHORT).show();
                    Intent errorCatch = new Intent(MainActivity.this, Songs.class);
                    startActivity(errorCatch);
                }

            }
        });

        Button skip = findViewById(R.id.skip);

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