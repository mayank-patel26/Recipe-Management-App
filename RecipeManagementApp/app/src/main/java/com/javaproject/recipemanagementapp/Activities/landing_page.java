package com.javaproject.recipemanagementapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.javaproject.recipemanagementapp.DatabaseHelper;
import com.javaproject.recipemanagementapp.R;
import com.javaproject.recipemanagementapp.Tables.Recipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class landing_page extends AppCompatActivity {
    List<Recipe> recipeList;
    RecipeAdapter recipeAdapter;

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

}