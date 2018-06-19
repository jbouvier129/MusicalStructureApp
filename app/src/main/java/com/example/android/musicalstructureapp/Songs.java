package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Songs extends AppCompatActivity {
    String albumNameFromAlbums;
    String artistNameFromArtists;
    String selection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        albumNameFromAlbums= getIntent().getStringExtra("albumNameFromAlbums");
        artistNameFromArtists = getIntent().getStringExtra("artistsNameFromArtists");

        // Find the View that shows the numbers category
        Button byArtist = findViewById(R.id.byArtist);

        // Set a click listener on that View
        byArtist.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent byArtistIntent = new Intent(Songs.this, Artists.class);

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
                Intent byAlbumIntent = new Intent(Songs.this, Albums.class);

                // Start the new activity
                startActivity(byAlbumIntent);
            }
        });

        ArrayList<BySongs> trackList = new ArrayList<BySongs>();

        trackList.add(new BySongs("track 1", "band 1", "band 1 album"));
        trackList.add(new BySongs("track 2", "band 1", "band 1 album"));
        trackList.add(new BySongs("track 3", "band 1", "band 1 album"));
        trackList.add(new BySongs("track 1", "band 2", "band 2 album"));
        trackList.add(new BySongs("track 2", "band 2", "band 2 album"));
        trackList.add(new BySongs("track 1", "band 3", "band 3 album"));
        trackList.add(new BySongs("track 2", "band 3", "band 3 album"));
        trackList.add(new BySongs("track 1", "band 4", "band 4 album"));
        trackList.add(new BySongs("track 2", "band 4", "band 4 album"));
        trackList.add(new BySongs("track 3", "band 4", "band 4 album"));
        trackList.add(new BySongs("track 1", "band 5", "band 5 album"));
        trackList.add(new BySongs("track 2", "band 5", "band 5 album"));
        trackList.add(new BySongs("track 1", "band 6", "band 6 album"));
        trackList.add(new BySongs("track 2", "band 6", "band 6 album"));
        trackList.add(new BySongs("track 1", "band 7", "band 7 album"));
        trackList.add(new BySongs("track 2", "band 7", "band 7 album"));
        trackList.add(new BySongs("track 1", "band 8", "band 8 album"));
        trackList.add(new BySongs("track 1", "band 9", "band 9 album"));
        trackList.add(new BySongs("track 2", "band 9", "band 9 album"));
        trackList.add(new BySongs("track 1", "band 10", "band 10 album"));
        trackList.add(new BySongs("track 2", "band 10", "band 10 album"));
        trackList.add(new BySongs("track 1", "band 11", "band 11 album"));
        trackList.add(new BySongs("track 2", "band 11", "band 11 album"));
        trackList.add(new BySongs("track 1", "band 12", "band 12 album"));
        trackList.add(new BySongs("track 2", "band 12", "band 12 album"));

        if (albumNameFromAlbums != null){
            switch (albumNameFromAlbums){
                case "band 1 album":
                    trackList.removeAll(trackList);
                    trackList.add(new BySongs("track 1", "band 1", "band 1 album"));
                    trackList.add(new BySongs("track 2", "band 1", "band 1 album"));
                    trackList.add(new BySongs("track 3", "band 1", "band 1 album"));
                    break;
                case "band 2 album":
                    trackList.removeAll(trackList);
                    trackList.add(new BySongs("track 1", "band 2", "band 2 album"));
                    trackList.add(new BySongs("track 2", "band 2", "band 2 album"));
                    break;
                case "band 3 album":
                    trackList.removeAll(trackList);
                    trackList.add(new BySongs("track 1", "band 3", "band 3 album"));
                    trackList.add(new BySongs("track 2", "band 3", "band 3 album"));
                    break;
                case "band 4 album":
                    trackList.removeAll(trackList);
                    trackList.add(new BySongs("track 1", "band 4", "band 4 album"));
                    trackList.add(new BySongs("track 2", "band 4", "band 4 album"));
                    trackList.add(new BySongs("track 3", "band 4", "band 4 album"));
                    break;
                case "band 5 album":
                    trackList.removeAll(trackList);
                    trackList.add(new BySongs("track 1", "band 5", "band 5 album"));
                    trackList.add(new BySongs("track 2", "band 5", "band 5 album"));
                    break;
                case "band 6 album":
                    trackList.removeAll(trackList);
                    trackList.add(new BySongs("track 1", "band 6", "band 6 album"));
                    trackList.add(new BySongs("track 2", "band 6", "band 6 album"));
                    break;
                case "band 7 album":
                    trackList.removeAll(trackList);
                    trackList.add(new BySongs("track 1", "band 7", "band 7 album"));
                    trackList.add(new BySongs("track 2", "band 7", "band 7 album"));
                    break;
                case "band 8 album":
                    trackList.removeAll(trackList);
                    trackList.add(new BySongs("track 1", "band 8", "band 8 album"));
                case "band 9 album":
                    trackList.removeAll(trackList);
                    trackList.add(new BySongs("track 1", "band 9", "band 9 album"));
                    trackList.add(new BySongs("track 2", "band 9", "band 9 album"));
                    break;
                case "band 10 album":
                    trackList.removeAll(trackList);
                    trackList.add(new BySongs("track 1", "band 10", "band 10 album"));
                    trackList.add(new BySongs("track 2", "band 10", "band 10 album"));
                    break;
                case "band 11 album":
                    trackList.removeAll(trackList);
                    trackList.add(new BySongs("track 1", "band 11", "band 11 album"));
                    trackList.add(new BySongs("track 2", "band 11", "band 11 album"));
                    break;
                case "band 12 album":
                    trackList.removeAll(trackList);
                    trackList.add(new BySongs("track 1", "band 12", "band 12 album"));
                    trackList.add(new BySongs("track 2", "band 12", "band 12 album"));
                    break;
            }
        }
        else if (artistNameFromArtists != null) {
            switch (artistNameFromArtists) {
                case "band 1":
                    trackList.removeAll(trackList);
                    trackList.add(new BySongs("track 1", "band 1", "band 1 album"));
                    trackList.add(new BySongs("track 2", "band 1", "band 1 album"));
                    trackList.add(new BySongs("track 3", "band 1", "band 1 album"));
                    break;
                case "band 2":
                    trackList.removeAll(trackList);
                    trackList.add(new BySongs("track 1", "band 2", "band 2 album"));
                    trackList.add(new BySongs("track 2", "band 2", "band 2 album"));
                    break;
                case "band 3":
                    trackList.removeAll(trackList);
                    trackList.add(new BySongs("track 1", "band 3", "band 3 album"));
                    trackList.add(new BySongs("track 2", "band 3", "band 3 album"));
                    break;
                case "band 4":
                    trackList.removeAll(trackList);
                    trackList.add(new BySongs("track 1", "band 4", "band 4 album"));
                    trackList.add(new BySongs("track 2", "band 4", "band 4 album"));
                    trackList.add(new BySongs("track 3", "band 4", "band 4 album"));
                    break;
                case "band 5":
                    trackList.removeAll(trackList);
                    trackList.add(new BySongs("track 1", "band 5", "band 5 album"));
                    trackList.add(new BySongs("track 2", "band 5", "band 5 album"));
                    break;
                case "band 6":
                    trackList.removeAll(trackList);
                    trackList.add(new BySongs("track 1", "band 6", "band 6 album"));
                    trackList.add(new BySongs("track 2", "band 6", "band 6 album"));
                    break;
                case "band 7":
                    trackList.removeAll(trackList);
                    trackList.add(new BySongs("track 1", "band 7", "band 7 album"));
                    trackList.add(new BySongs("track 2", "band 7", "band 7 album"));
                    break;
                case "band 8":
                    trackList.removeAll(trackList);
                    trackList.add(new BySongs("track 1", "band 8", "band 8 album"));
                case "band 9":
                    trackList.removeAll(trackList);
                    trackList.add(new BySongs("track 1", "band 9", "band 9 album"));
                    trackList.add(new BySongs("track 2", "band 9", "band 9 album"));
                    break;
                case "band 10":
                    trackList.removeAll(trackList);
                    trackList.add(new BySongs("track 1", "band 10", "band 10 album"));
                    trackList.add(new BySongs("track 2", "band 10", "band 10 album"));
                    break;
                case "band 11":
                    trackList.removeAll(trackList);
                    trackList.add(new BySongs("track 1", "band 11", "band 11 album"));
                    trackList.add(new BySongs("track 2", "band 11", "band 11 album"));
                    break;
                case "band 12":
                    trackList.removeAll(trackList);
                    trackList.add(new BySongs("track 1", "band 12", "band 12 album"));
                    trackList.add(new BySongs("track 2", "band 12", "band 12 album"));
                    break;
            }
        }
        BySongsAdapter songsAdapter = new BySongsAdapter(this, trackList);
        ListView listView = findViewById(R.id.linearList);
        listView.setAdapter(songsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 0: selection = "band 1 track 1";
                        break;
                    case 1: selection = "band 1 track 2";
                        break;
                    case 2: selection = "band 1 track 3";
                        break;
                    case 3: selection = "band 2 track 1";
                        break;
                    case 4: selection = "band 2 track 2";
                        break;
                    case 5: selection = "band 3 track 1";
                        break;
                    case 6: selection = "band 3 track 2";
                        break;
                    case 7: selection = "band 4 track 1";
                        break;
                    case 8: selection = "band 4 track 2";
                        break;
                    case 9: selection = "band 4 track 3";
                        break;
                    case 10: selection = "band 5 track 1";
                        break;
                    case 11: selection = "band 5 track 2";
                        break;
                }
                Intent selectedSong = new Intent(Songs.this, MainActivity.class);
                selectedSong.putExtra("selectedSong", selection );

                startActivity(selectedSong);
            }
        });
    }
}
