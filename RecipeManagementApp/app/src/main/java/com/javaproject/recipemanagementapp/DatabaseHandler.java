package com.javaproject.recipemanagementapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import com.javaproject.recipemanagementapp.Tables.User;
import java.util.Date;

public class DatabaseHandler
{
    //All DB functions are part of context class hence you can use it without context in AppCompactActivity derived classes
    static User currentUser;
    static SQLiteDatabase recipeAppDatabase;

    static void setDB(Context context)
    {
        currentUser=new User();
        //create a database if it doesn't exist
        recipeAppDatabase = context.openOrCreateDatabase("RecipeAppDatabase",context.MODE_PRIVATE,null);
        // create a recipe database table here

        //create the user table here

    }

    //call this method to insert a new user
    static void insertUserData(String email, String username, String password, Date dateOfBirth, String fullName, Image profilePicture)
    {
        User user=new User(email,username,password,dateOfBirth,fullName,profilePicture);
        //insert user values into the table here
    }

    static void insertRecipe()
    {
        //insert recipe values here and call this method to insert a new recipe
    }

    static User getUserByID(int ID)
    {
        //get a specific user by the ID and return the user
        User user=new User();
        //get the user from DB and fill up 'user'
        return user;
    }

    static void setCurrentUser(User user)
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
