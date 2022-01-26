package com.javaproject.recipemanagementapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.javaproject.recipemanagementapp.DatabaseHelper;
import com.javaproject.recipemanagementapp.R;

public class landing_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        ImageButton profile_button1 = findViewById(R.id.profile_button1);
        profile_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(landing_page.this, options.class);
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