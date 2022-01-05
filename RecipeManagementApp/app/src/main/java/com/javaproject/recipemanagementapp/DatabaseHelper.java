package com.javaproject.recipemanagementapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;

import com.javaproject.recipemanagementapp.Tables.Recipe;
import com.javaproject.recipemanagementapp.Tables.User;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DatabaseHelper
{
    //All DB functions are part of context class hence you can use it without context in AppCompactActivity derived classes
    public static User currentUser;
    public static SQLiteDatabase recipeAppDatabase;

    public static void setDB(Context context)
    {
        currentUser=new User();
        //create a database if it doesn't exist
        recipeAppDatabase = context.openOrCreateDatabase("RecipeAppDatabase",context.MODE_PRIVATE,null);
        // create a recipe database table here

        //create the user table here
        recipeAppDatabase.execSQL("CREATE TABLE IF NOT EXISTS User(id int PRIMARY KEY AUTOINCREMENT, email TEXT, password text,dateOfBirth text,fullName text, imagePath text)");
    }

    //
    public static void insertUserData(String email,String password)
    {
        //insert user values into the table here
        recipeAppDatabase.execSQL("INSERT INTO User(email,password) VALUES(email,password);");
    }

    static void insertRecipe()
    {
        //insert recipe values here and call this method to insert a new recipe
    }

    public static User getUserByEmail(String email)
    {
        //get a specific user by the ID and return the user
        User user=new User();
        //get the user from DB and fill up 'user'
        Cursor cursor = recipeAppDatabase.rawQuery("Select * from user where email = ?", new String[]{email});
        user.ID=cursor.getInt(0);
        user.email=cursor.getString(1);
        user.password=cursor.getString(2);
        return user;
    }

    public static void setCurrentUser(User user)
    {
        currentUser=user;
    }

    //Trial example - ignore
    /* create a database and confirm if it has been created by displaying value in a text field*/
    /*void confirmDBCreation(Context context)
    {
        //create a database if it doesn't exist
        SQLiteDatabase recipeAppDatabase = context.openOrCreateDatabase("RecipeAppDatabase",context.MODE_PRIVATE,null);

        //User dbName.execSQL to execute any SQL command
        // create a table if it doesn't exist
        recipeAppDatabase.execSQL("CREATE TABLE IF NOT EXISTS Recipe(Name TEXT,id INT PRIMARY KEY);");

        //insert values
        //recipeAppDatabase.execSQL("INSERT INTO Recipe VALUES('TrialYummyRecipe',1);");

        //get values
        Cursor result = recipeAppDatabase.rawQuery("Select * from Recipe",null);
        result.moveToFirst();
        String name = result.getString(0); //get first value from result set
        String id = result.getString(1); // get second value from result set

        //get the textView and change the name of the recipe to check(for now)
        //TextView textView=findViewById(R.id.startup_text);
        //textView.setText(name);
    }*/
}
