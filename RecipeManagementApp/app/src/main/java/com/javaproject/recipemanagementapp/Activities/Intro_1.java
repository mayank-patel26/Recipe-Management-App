package com.javaproject.recipemanagementapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.javaproject.recipemanagementapp.R;


public class Intro_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro1);

        Button intro1skip_btn = findViewById(R.id.intro1skip_btn);
        intro1skip_btn.setOnClickListener(v -> {
                Intent intent = new Intent(Intro_1.this, login_startup.class);
                startActivity(intent);
            });
    }
}