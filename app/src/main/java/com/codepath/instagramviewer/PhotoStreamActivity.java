package com.codepath.instagramviewer;

import android.content.Context;
import android.graphics.Movie;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import org.apache.http.*;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class PhotoStreamActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_stream);
        getSupportActionBar().hide();

        ListView lvMovies = (ListView) findViewById(R.id.lvPosts);
        this.getPhotoStream(this, lvMovies);
    }

    protected void getPhotoStream (final Context context, final ListView lvPosts) {
        final ArrayList<InstagramPost> instagramPosts = new ArrayList<>();

        InstagramAPIClient.get("/media/popular", null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // If the response is JSONObject instead of expected JSONArray
                try {
                    JSONArray posts = (JSONArray) response.get("data");

                    for (int i=0;i<posts.length();i++){
                        JSONObject jsonPost = (JSONObject) posts.get(i);

                        String imageUrl = jsonPost
                                .getJSONObject("images")
                                .getJSONObject("standard_resolution")
                                .getString("url");

                        String caption = "";
                        if (jsonPost.has("caption") && !jsonPost.isNull("caption")) {
                            caption = jsonPost.getJSONObject("caption").getString("text");
                        }

                        JSONObject jsonUser = jsonPost.getJSONObject("user");
                        String userName = jsonUser.getString("username");
                        String userPicture = jsonUser.getString("profile_picture");
                        int likesCount = jsonPost.getJSONObject("likes").getInt("count");

                        InstagramUser instaUser = new InstagramUser(userName, userPicture);
                        InstagramPost instaPost = new InstagramPost(instaUser, caption, imageUrl, likesCount);
                        instagramPosts.add(instaPost);
                    }

                    //Log.i(">> getPhotoStream", "POSTS::"+instagramPosts.size());
                    InstagramAdapter postArrayAdapter = new InstagramAdapter(context, instagramPosts);
                    lvPosts.setAdapter(postArrayAdapter);

                } catch (Exception e) {
                    Log.e(">> getPhotoStream", e.getMessage());
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_photo_stream, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
