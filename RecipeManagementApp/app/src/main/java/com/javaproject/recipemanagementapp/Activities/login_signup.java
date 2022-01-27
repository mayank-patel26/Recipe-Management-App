package com.javaproject.recipemanagementapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.javaproject.recipemanagementapp.R;

public class login_signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_signup);

        Button l_s_login_btn = findViewById(R.id.l_s_login_btn);
        l_s_login_btn.setOnClickListener(view -> {
            Intent i1 = new Intent(login_signup.this, login.class);
            startActivity(i1);
        });

        Button l_s_signup_btn = findViewById(R.id.l_s_signup_btn);
        l_s_signup_btn.setOnClickListener(view -> {
            Intent i2 = new Intent(login_signup.this, signup.class);
            startActivity(i2);
        });
    }


    @Override
    public void onBackPressed(){
        Intent toLandingPage = new Intent(this, ExitPage.class);
        startActivity(toLandingPage);
//        super.onBackPressed();
    }
}