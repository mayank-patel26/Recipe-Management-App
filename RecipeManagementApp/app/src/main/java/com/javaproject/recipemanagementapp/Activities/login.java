package com.javaproject.recipemanagementapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.javaproject.recipemanagementapp.R;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button login_btn1 = findViewById(R.id.login_btn1);
        login_btn1.setOnClickListener(view -> {
            Intent intent1 = new Intent(login.this, landing_page.class);
            startActivity(intent1);
        });

    }
}