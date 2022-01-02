package com.javaproject.recipemanagementapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.javaproject.recipemanagementapp.R;

public class Intro_1 extends AppCompatActivity {
    public ConstraintLayout sign_up_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro1);

//        Button signup2 = (Button) findViewById(R.id.signup2);
//        signup2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Intro_1.this, Intro_2.class);
//                startActivity(intent);
//            }
//        });
    }
}