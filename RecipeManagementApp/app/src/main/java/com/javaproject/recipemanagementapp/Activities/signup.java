package com.javaproject.recipemanagementapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.javaproject.recipemanagementapp.R;

public class signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Button signup_btn1 = findViewById(R.id.signup_btn1);
        signup_btn1.setOnClickListener(view -> {
            Intent intent2 = new Intent(signup.this, all_recipe.class);
            startActivity(intent2);
        });

    }
}