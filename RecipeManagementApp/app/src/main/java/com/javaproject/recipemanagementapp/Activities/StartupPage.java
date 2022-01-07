package com.javaproject.recipemanagementapp.Activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

        DatabaseHelper.setDB(this);
    }
}
