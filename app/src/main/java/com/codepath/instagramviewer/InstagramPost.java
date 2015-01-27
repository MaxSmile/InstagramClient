package com.codepath.instagramviewer;

import android.content.Context;
import android.graphics.Movie;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.loopj.android.http.*;
import org.json.*;
import org.apache.http.*;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by ccoria on 1/25/15.
 */
public class InstagramPost {

    public InstagramPost(InstagramUser user, String caption, String photo_url, int likesCount) {
        this.user = user;
        this.caption = caption;
        this.photo_url = photo_url;
        this.likesCount = likesCount;
    }

    public InstagramUser getUser() {
        return user;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public String getCaption() {
        return caption;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    private InstagramUser user;
    private String caption;
    private String photo_url;
    private int likesCount;

}
