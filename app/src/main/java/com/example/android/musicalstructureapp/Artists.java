package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;

public class Artists extends AppCompatActivity {

    String selection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_view);

        // Find the View that shows the family category
        Button byAlbum = findViewById(R.id.byAlbum);

        // Set a click listener on that View
        byAlbum.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the family category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link FamilyActivity}
                Intent byAlbumIntent = new Intent(Artists.this, Albums.class);

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
                Intent bySongIntent = new Intent(Artists.this, Songs.class);

                // Start the new activity
                startActivity(bySongIntent);
            }
        });

        final ArrayList<ByAlbumOrArtist> albumArtistInfo = new ArrayList<ByAlbumOrArtist>();

        albumArtistInfo.add(new ByAlbumOrArtist("band 1",null, R.drawable.artist_1));
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

        ByAlbumOrArtistAdapter aAAdapter = new ByAlbumOrArtistAdapter(this, albumArtistInfo);
        GridView gridView = findViewById(R.id.gridList);
        gridView.setAdapter(aAAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                selection = albumArtistInfo.get(position).getArtistName();

                Intent artistSongs = new Intent(Artists.this, Songs.class);
                artistSongs.putExtra("artistsNameFromArtists", selection );

                startActivity(artistSongs);
            }
        });

    }

}
