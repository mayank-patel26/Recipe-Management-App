package com.javaproject.recipemanagementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class SettingsActivity extends AppCompatActivity {
//put all activity java files inside the activity folder
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        //you can also get any other view the same way
        //TextView txt=findViewById(R.layout.anyTxtKaID)
        //get button with id
        /*Button button=findViewById(R.id.language_button);
        //if you don't want to transition anywhere just do some task
        button.setOnClickListener(view->{
            //your task here
        });
        button.setOnClickListener(view -> {
            //Start an intent if you want to transition to a different page new Intent(class from which you want to go, class you want to go to)
            //class which you want to go to should be in the same folder as this one( hence I put all activities in one folder)
            Intent profile = new Intent(this, options.class);
            startActivity(profile);
        });
*/
        //all methods to delete,update etc from database are in DatabaseHelper class, theyre static so you can call them from anywhere
    }
}