package com.example.android.musicalstructureapp;
//adapter to populate the grid views
//the majority of this code was repurposed from the miwok work in the lesson. General informative comments were left alone
import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ByAlbumOrArtistAdapter extends ArrayAdapter<ByAlbumOrArtist> {

    public ByAlbumOrArtistAdapter(Activity context, ArrayList<ByAlbumOrArtist> albumArtist) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, albumArtist);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View gridItemView = convertView;
        if (gridItemView == null) {
            gridItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.grid_item_layout, parent, false);
        }

        // Get the artist located at this position in the list
        ByAlbumOrArtist currentAlbumArtists = getItem(position);

        // Find albumArtist ImageView
        ImageView albumArtistImageView = gridItemView.findViewById(R.id.grid_item_image);
        // set text equal to the ImageView at specified position
        albumArtistImageView.setImageResource(currentAlbumArtists.getAlbumArtistImage());

        // Find album TextView
        TextView albumTextView = gridItemView.findViewById(R.id.grid_item_text_view);
        // set textview equal to album name if applicable
        albumTextView.setText(currentAlbumArtists.getAlbumName());

        // Find artist text view
        TextView artistTextView = gridItemView.findViewById(R.id.grid_item_text_view2);
        //set textview equal to artist name
        artistTextView.setText(currentAlbumArtists.getArtistName());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return gridItemView;
    }
}
