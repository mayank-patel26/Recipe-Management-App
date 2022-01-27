package com.javaproject.recipemanagementapp.Tables;

import android.media.Image;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class User {

    public int ID;
    public String email;
    public String username;
    public String password;
    public String fullName;
    public Image profilePicture;
    public ArrayList<Recipe> recipeList;

    public User()
    {
        this.email = "";
        this.username = "";
        this.password = "";
        this.fullName = "";
        this.profilePicture = null;
        recipeList=new ArrayList<>();
    }

    public User(String email, String username, String password, String fullName, Image profilePicture) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.profilePicture = profilePicture;
        recipeList=new ArrayList<>();
    }

    public boolean validatePassword(String passwordCheck)
    {
        return passwordCheck.equals(password);
    }
}
