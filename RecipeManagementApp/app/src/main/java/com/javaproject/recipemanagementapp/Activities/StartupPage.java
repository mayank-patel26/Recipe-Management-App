package com.javaproject.recipemanagementapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.javaproject.recipemanagementapp.DatabaseHelper;
import com.javaproject.recipemanagementapp.R;

public class StartupPage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);

        DatabaseHelper.setDB(this);

        if(DatabaseHelper.checkRemStatus()){
            String setEmail = DatabaseHelper.getRemEmail();
            DatabaseHelper.getRemCursor(setEmail);
            DatabaseHelper.getAllRecipe();
            Button get_started = findViewById(R.id.intro_skip);
            get_started.setOnClickListener(view -> {
                Intent toLandingPage = new Intent(StartupPage.this, landing_page.class);
                startActivity(toLandingPage);
            });
        }
        else if(!DatabaseHelper.checkRemStatus()){
            Button get_started = findViewById(R.id.intro_skip);
            get_started.setOnClickListener(view -> {
                Intent intent = new Intent(StartupPage.this, intro_scroll.class);
                startActivity(intent);
            });
        }


    }

    @Override
    public void onBackPressed(){
        Intent toExit = new Intent(this, ExitPage.class);
        startActivity(toExit);
    }
}
