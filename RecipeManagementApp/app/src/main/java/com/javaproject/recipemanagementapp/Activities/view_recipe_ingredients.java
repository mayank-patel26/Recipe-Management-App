package com.javaproject.recipemanagementapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.javaproject.recipemanagementapp.AddBulletPoints;
import com.javaproject.recipemanagementapp.DatabaseHelper;
import com.javaproject.recipemanagementapp.R;
import com.javaproject.recipemanagementapp.Tables.Recipe;

import org.w3c.dom.Text;

public class view_recipe_ingredients extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_recipe_ingredients);
        AddBulletPoints.setBulletPoints(findViewById(R.id.recipe_ingredients));
        addOnClicks();
        populatePage();
    }
    void populatePage()
    {
        if(!DatabaseHelper.currentEditRecipe.recipeName.equals(""))
        {
            TextView name= findViewById(R.id.recipe_name);
            name.setText(DatabaseHelper.currentEditRecipe.recipeName);
            TextView cookTime= findViewById(R.id.cooking_time_text2);
            cookTime.setText(DatabaseHelper.currentEditRecipe.cookingTime);
            TextView prepTime= findViewById(R.id.prep_time_value);
            prepTime.setText(DatabaseHelper.currentEditRecipe.prepTime);
            TextView ingredients= findViewById(R.id.ingredients_edit_text);
            String ing="•"+ Recipe.ListtoString(DatabaseHelper.currentEditRecipe.Ingredients).replaceAll(",","\n•");
            ingredients.setText(ing);
        }
    }

    void addOnClicks()
    {
        Button next = findViewById(R.id.next_button_ingredients_view);
        next.setOnClickListener(view -> {
            Intent intent = new Intent(this, view_recipe_method.class);
            startActivity(intent);
        });

        Button edit = findViewById(R.id.edit_button);
        edit.setOnClickListener(view -> {
            Intent intent = new Intent(this, add_or_edit_recipe.class);
            startActivity(intent);
        });
    }
}