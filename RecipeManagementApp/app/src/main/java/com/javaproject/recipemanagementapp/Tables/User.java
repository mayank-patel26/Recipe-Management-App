package com.javaproject.recipemanagementapp.Tables;

import android.media.Image;

import java.text.SimpleDateFormat;

public class User {

    public int ID;
    public String email;
    public String username;
    public String password;
    public SimpleDateFormat dateOfBirth;
    public String fullName;
    public Image profilePicture;

    public User()
    {
        this.email = "";
        this.username = "";
        this.password = "";
        this.dateOfBirth = new SimpleDateFormat();
        this.fullName = "";
        this.profilePicture = null;
    }

    public User(String email, String username, String password, SimpleDateFormat dateOfBirth, String fullName, Image profilePicture) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.fullName = fullName;
        this.profilePicture = profilePicture;
    }

    public boolean validatePassword(String passwordCheck)
    {
        return passwordCheck.equals(password);
    }
}
