package com.example.wewerk_v12.models;

import android.media.Image;

import java.io.Serializable;

public class User implements Serializable {

    private String realName, username;
    private Image profilePicture;

//TODO: remake user models


    public User(String realName, String username) {
        this.realName = realName;
        this.username = username;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Image getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(Image profilePicture) {
        this.profilePicture = profilePicture;
    }
}
