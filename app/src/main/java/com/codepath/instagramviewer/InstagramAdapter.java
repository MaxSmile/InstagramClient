package com.codepath.instagramviewer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ccoria on 1/25/15.
 */
class InstagramAdapter extends ArrayAdapter<InstagramPost> {

    public InstagramAdapter(Context context, ArrayList<InstagramPost> posts) {
        super(context, R.layout.item_photo, posts);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the data item for this position
        InstagramPost post = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_photo, parent, false);
        }
        // Lookup view for data population
        TextView txtPostHeader = (TextView) convertView.findViewById(R.id.txtHeader);
        TextView txtLikes = (TextView) convertView.findViewById(R.id.txtLikes);
        TextView txtCaption = (TextView) convertView.findViewById(R.id.txtCaption);
        ImageView ivPostPhoto = (ImageView) convertView.findViewById(R.id.ivPhoto);
        ImageView ivUserPicture = (ImageView) convertView.findViewById(R.id.ivUserPicture);

        // Populate the data into the template view using the data object
        //txtPostHeader.setText(Html.fromHtml("<b>"+post.getUser().getName()+"</b> - "+post.getCaption()));
        txtPostHeader.setText(post.getUser().getName());
        txtLikes.setText(post.getLikesCount()+" likes");
        txtCaption.setText(post.getCaption());

        Picasso.with(this.getContext()).load(post.getPhoto_url()).into(ivPostPhoto);
        Picasso.with(this.getContext()).load(post.getUser().getProfilePicture()).into(ivUserPicture);

        // Return the completed view to render on screen
        return convertView;
    }
}
