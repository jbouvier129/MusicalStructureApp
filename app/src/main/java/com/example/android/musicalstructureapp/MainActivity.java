package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
    }
}
