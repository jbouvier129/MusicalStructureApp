package com.example.android.musicalstructureapp;

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
        super(context, 0 , albumArtist);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View gridItemView = convertView;
        if(gridItemView == null) {
            gridItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.grid_item_layout, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        ByAlbumOrArtist currentAlbumArtists = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        ImageView albumArtistImageView = gridItemView.findViewById(R.id.grid_item_image);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        albumArtistImageView.setImageResource(currentAlbumArtists.getAlbumArtistImage());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView albumTextView = gridItemView.findViewById(R.id.grid_item_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        albumTextView.setText(currentAlbumArtists.getAlbumName());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView artistTextView = gridItemView.findViewById(R.id.grid_item_text_view2);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        artistTextView.setText(currentAlbumArtists.getArtistName());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return gridItemView;
    }
}
