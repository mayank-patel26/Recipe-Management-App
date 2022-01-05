package com.javaproject.recipemanagementapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.javaproject.recipemanagementapp.R;

public class landing_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        Button profile_button1 = (Button) findViewById(R.id.profile_button1);
        profile_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(landing_page.this, login_signup.class);
                startActivity(intent);
            }
        });

        TextView all_recipe_txt = findViewById(R.id.all_recipe_txt);
        all_recipe_txt.setOnClickListener(view -> {
            Intent in = new Intent(this, all_recipe.class);
            startActivity(in);
        });
    }
}