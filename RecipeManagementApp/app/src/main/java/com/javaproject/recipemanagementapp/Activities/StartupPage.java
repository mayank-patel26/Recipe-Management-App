package com.javaproject.recipemanagementapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.javaproject.recipemanagementapp.R;

public class StartupPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);

        Button startup_skip_btn = findViewById(R.id.startup_skip_btn);
        startup_skip_btn.setOnClickListener(view -> {
            Intent intent1 = new Intent(StartupPage.this, login_startup.class);
            startActivity(intent1);
        });

        }
    }
