package com.javaproject.recipemanagementapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.javaproject.recipemanagementapp.R;

public class StartupPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_or_edit_recipe);
        //confirmDBCreation();
        /*Button get_started = findViewById(R.id.intro_skip);
        get_started.setOnClickListener(view -> {
            Intent intent = new Intent(StartupPage.this, intro_scroll.class);
            startActivity(intent);
        });
*/
        }
    /* create a database and confirm if it has been created by displaying value in a text field*/
    /*void confirmDBCreation()
    {
        //create a database if it doesn't exist
        SQLiteDatabase recipeAppDatabase = openOrCreateDatabase("RecipeAppDatabase",MODE_PRIVATE,null);

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
        TextView textView=findViewById(R.id.startup_text);
        textView.setText(name);
    }*/
}
