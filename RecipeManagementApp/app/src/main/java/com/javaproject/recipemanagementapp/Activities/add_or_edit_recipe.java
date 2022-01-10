package com.javaproject.recipemanagementapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.javaproject.recipemanagementapp.AddBulletPoints;
import com.javaproject.recipemanagementapp.DatabaseHelper;
import com.javaproject.recipemanagementapp.R;
import com.javaproject.recipemanagementapp.Tables.Recipe;

public class add_or_edit_recipe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_or_edit_recipe);
        AddBulletPoints.setBulletPoints(findViewById(R.id.ingredients_edit_text));
        addOnButtonClicks();
    }
    void addOnButtonClicks()
    {
        Button get_started = findViewById(R.id.next_button);
        get_started.setOnClickListener(view -> {
            populateRecipe();
            Intent intent = new Intent(this, view_recipe_ingredients.class);
            startActivity(intent);
        });
    }

    void populateRecipe()
    {
        DatabaseHelper.currentEditRecipe =new Recipe();
        String recipeName=((EditText)findViewById(R.id.name_of_recipe)).getText().toString();
        String cookTime=((EditText)findViewById(R.id.cooking_time_edittext)).getText().toString();
        String prepTime=((EditText)findViewById(R.id.prep_time_edittext)).getText().toString();
        String ingredients=((EditText)findViewById(R.id.ingredients_edit_text)).getText().toString();;
        DatabaseHelper.currentEditRecipe.recipeName=recipeName;
        DatabaseHelper.currentEditRecipe.cookingTime=cookTime;
        DatabaseHelper.currentEditRecipe.prepTime=prepTime;
        DatabaseHelper.currentEditRecipe.addStringToIngredients(ingredients);
    }
}