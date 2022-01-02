package com.javaproject.recipemanagementapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.javaproject.recipemanagementapp.R;

public class Intro_1 extends AppCompatActivity {
    public ConstraintLayout sign_up_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro1);

        sign_up_button.findViewById(R.id.sign_up_button);
        sign_up_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intro_1.this, Intro_2.class ));
            }
        });
    }
}