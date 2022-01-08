package com.javaproject.recipemanagementapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.javaproject.recipemanagementapp.Tables.User;


public class DatabaseHelper extends Exception
{
    //All DB functions are part of context class hence you can use it without context in AppCompactActivity derived classes
    public static User currentUser;
    public static SQLiteDatabase recipeAppDatabase;

    public static void setDB(Context context)
    {
        currentUser=new User();
        //create a database if it doesn't exist
        recipeAppDatabase = context.openOrCreateDatabase("RecipeAppDatabase", Context.MODE_PRIVATE,null);
        // create a recipe database table here
        recipeAppDatabase.execSQL("CREATE TABLE IF NOT EXISTS recipe(id INTEGER PRIMARY KEY AUTOINCREMENT, recipeName TEXT UNIQUE, ingredients TEXT, cuisine TEXT, procedure TEXT, servings INTEGER, cookingTime INTEGER, prepTime INTEGER, spiceLevel INTEGER, allergyWarning TEXT, rating INTEGER, tags TEXT,userID INTEGER)");
        //create the user table here
        recipeAppDatabase.execSQL("CREATE TABLE IF NOT EXISTS user(id INTEGER PRIMARY KEY AUTOINCREMENT, email TEXT UNIQUE, password TEXT, dateOfBirth TEXT, fullName TEXT, imagePath TEXT)");
    }

    public static void insertUserData(String email1,String password1)
    {
        //insert user values into the table here
        recipeAppDatabase.execSQL("INSERT INTO user(email, password) VALUES('"+email1+"','"+password1+"');");
    }

    public static Boolean checkemail (String email)
    {
        Cursor cursor = recipeAppDatabase.rawQuery("SELECT * FROM user WHERE email = ?;", new String[]{email});

        return (cursor.getCount()>0);
    }

    static void insertRecipeData()
    {
//        insert recipe values here and call this method to insert a new recipe

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

    public static Boolean checklogin(String e1, String p1){
        Cursor cursor = recipeAppDatabase.rawQuery("SELECT * FROM user WHERE email = '"+e1+"' AND password = '"+p1+"';", new String[]{});
        return (cursor.getCount()>0);
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
