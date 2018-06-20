package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;

public class Albums extends AppCompatActivity {
    String selection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_view);

        // Find the View that shows the numbers category
        Button byArtist = findViewById(R.id.byArtist);

        // Set a click listener on that View
        byArtist.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent byArtistIntent = new Intent(Albums.this, Artists.class);

                // Start the new activity
                startActivity(byArtistIntent);
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
                Intent bySongIntent = new Intent(Albums.this, Songs.class);

                // Start the new activity
                startActivity(bySongIntent);
            }
        });

        final ArrayList <ByAlbumOrArtist> albumArtistInfo = new ArrayList<ByAlbumOrArtist>();

        albumArtistInfo.add(new ByAlbumOrArtist("band 1", "band 1 album", R.drawable.artist_1_album));
        albumArtistInfo.add(new ByAlbumOrArtist("band 2", "band 2 album", R.drawable.artist_2_album));
        albumArtistInfo.add(new ByAlbumOrArtist("band 3", "band 3 album", R.drawable.artist_3_album));
        albumArtistInfo.add(new ByAlbumOrArtist("band 4", "band 4 album", R.drawable.artist_4_album));
        albumArtistInfo.add(new ByAlbumOrArtist("band 5", "band 5 album", R.drawable.artist_5_album));
        albumArtistInfo.add(new ByAlbumOrArtist("band 6", "band 6 album", R.drawable.artist_6_album));
        albumArtistInfo.add(new ByAlbumOrArtist("band 7", "band 7 album", R.drawable.artist_7_album));
        albumArtistInfo.add(new ByAlbumOrArtist("band 8", "band 8 album", R.drawable.artist_8_album));
        albumArtistInfo.add(new ByAlbumOrArtist("band 9", "band 9 album", R.drawable.artist_9_album));
        albumArtistInfo.add(new ByAlbumOrArtist("band 10", "band 10 album", R.drawable.artist_10_album));
        albumArtistInfo.add(new ByAlbumOrArtist("band 11", "band 11 album", R.drawable.artist_11_album));
        albumArtistInfo.add(new ByAlbumOrArtist("band 12", "band 12 album", R.drawable.artist_12_album));

        ByAlbumOrArtistAdapter aAAdapter = new ByAlbumOrArtistAdapter(this, albumArtistInfo);
        final GridView gridView = findViewById(R.id.gridList);
        gridView.setAdapter(aAAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                selection = albumArtistInfo.get(position).getAlbumName();
                Intent albumSongs = new Intent(Albums.this, Songs.class);
                albumSongs.putExtra("albumNameFromAlbums", selection );

                startActivity(albumSongs);

            }
        });

    }

}
