package com.codepath.instagramviewer;

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
