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

        final ArrayList<BySongs> trackList = new ArrayList<BySongs>();

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
            Iterator<BySongs> delete = trackList.iterator();
            while (delete.hasNext()) {
                if (!delete.next().getAlbumName().equals(albumNameFromAlbums)) {
                    delete.remove();
                }
            }
        }
        else if (artistNameFromArtists != null) {
            Iterator<BySongs> delete = trackList.iterator();
            while (delete.hasNext()) {
                if (!delete.next().getArtistName().equals(artistNameFromArtists)) {
                    delete.remove();
                }
            }
        }
        BySongsAdapter songsAdapter = new BySongsAdapter(this, trackList);
        ListView listView = findViewById(R.id.linearList);
        listView.setAdapter(songsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                selection = trackList.get(position).getArtistName() + trackList.get(position).getAlbumName();

                Intent selectedSong = new Intent(Songs.this, MainActivity.class);
                selectedSong.putExtra("selectedSong", selection );
                Toast.makeText(Songs.this, "Now Playing " + selection, Toast.LENGTH_SHORT);
                startActivity(selectedSong);
            }
        });
    }
}
