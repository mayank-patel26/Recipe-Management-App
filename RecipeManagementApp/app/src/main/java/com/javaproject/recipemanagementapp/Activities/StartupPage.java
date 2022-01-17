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
        Button get_started = findViewById(R.id.intro_skip);
        get_started.setOnClickListener(view -> {
            Intent intent = new Intent(StartupPage.this, intro_scroll.class);
            startActivity(intent);
        });

//        Button get_started = findViewById(R.id.intro_skip);
//        get_started.setOnClickListener(view -> {
//            Intent intent = new Intent(StartupPage.this, add_or_edit_recipe.class);
//            startActivity(intent);
//        });
        DatabaseHelper.setDB(this);


    }
}
