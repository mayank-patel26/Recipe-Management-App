package com.javaproject.recipemanagementapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.javaproject.recipemanagementapp.DatabaseHelper;
import com.javaproject.recipemanagementapp.R;

public class landing_page extends AppCompatActivity {
    Button resetRemStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        resetRemStatus = findViewById(R.id.resetRemBtn);

        resetRemStatus.setOnClickListener(view -> {
            DatabaseHelper.resetRemStatus();
            Intent quitNow = new Intent(this, ExitPage.class);
            startActivity(quitNow);
        });

        Button profile_button1 = (Button) findViewById(R.id.profile_button1);
        profile_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(landing_page.this, login_signup.class);
                startActivity(intent);
            }
        });
        setOnClicks();
    }

    void setOnClicks()
    {
        ConstraintLayout cl= (ConstraintLayout) ((LinearLayout)findViewById(R.id.landing_page_linearlayout)).getChildAt(0);
        int childCount=cl.getChildCount();
        for (int i = 0; i < childCount; i++) {
            TextView txt_v = (TextView) cl.getChildAt(i);
            txt_v.setOnClickListener(view -> {
                all_recipe.recipeType=txt_v.getText().toString();
                Intent in = new Intent(this, all_recipe.class);
                startActivity(in);
            });
        }
    }


    @Override
    public void onBackPressed() {
        Intent toExit = new Intent(this, ExitPage.class);
        startActivity(toExit);
        super.onBackPressed();
    }

}