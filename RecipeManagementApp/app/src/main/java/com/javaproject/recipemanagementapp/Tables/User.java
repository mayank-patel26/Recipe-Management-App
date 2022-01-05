package com.javaproject.recipemanagementapp.Tables;

import android.media.Image;

import java.util.Date;

public class User {

    String email;
    String username;
    String password;
    Date dateOfBirth;
    String fullName;
    Image profilePicture;

    public User()
    {
        this.email = "";
        this.username = "";
        this.password = "";
        this.dateOfBirth = new Date();
        this.fullName = "";
        this.profilePicture = null;
    }

    public User(String email, String username, String password, Date dateOfBirth, String fullName, Image profilePicture) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.fullName = fullName;
        this.profilePicture = profilePicture;
    }
}
