package com.codepath.instagramviewer;

/**
 * Created by ccoria on 1/26/15.
 */
public class InstagramUser {
    public InstagramUser(String name, String profilePicture) {
        this.profilePicture = profilePicture;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    private String name;
    private String profilePicture;

}
