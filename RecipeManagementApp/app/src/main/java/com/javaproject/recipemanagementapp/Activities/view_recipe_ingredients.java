package com.javaproject.recipemanagementapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.javaproject.recipemanagementapp.AddBulletPoints;
import com.javaproject.recipemanagementapp.R;

public class view_recipe_ingredients extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_recipe_ingredients);
        AddBulletPoints.setBulletPoints(findViewById(R.id.recipe_ingredients));
        populatePage();
    }
    void populatePage()
    {

    }
}