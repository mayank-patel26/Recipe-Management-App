package com.javaproject.recipemanagementapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.javaproject.recipemanagementapp.AddBulletPoints;
import com.javaproject.recipemanagementapp.DatabaseHelper;
import com.javaproject.recipemanagementapp.R;
import com.javaproject.recipemanagementapp.Tables.Recipe;

public class add_or_edit_recipe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_or_edit_recipe);
        AddBulletPoints.setBulletPoints(findViewById(R.id.ingredients_edit_text),"•");
        addOnButtonClicks();
        populateRecipe();
    }
    void addOnButtonClicks()
    {
        Button next = findViewById(R.id.next_button);
        next.setOnClickListener(view -> {
            saveRecipe();
            Intent intent = new Intent(this, view_recipe_ingredients.class);
            startActivity(intent);
        });
    }

    void populateRecipe()
    {
        if(!DatabaseHelper.currentEditRecipe.recipeName.equals(""))
        {
            EditText name= findViewById(R.id.name_of_recipe);
            name.setText(DatabaseHelper.currentEditRecipe.recipeName);
            EditText cookTime= findViewById(R.id.cooking_time_edittext);
            cookTime.setText(DatabaseHelper.currentEditRecipe.cookingTime);
            EditText prepTime= findViewById(R.id.prep_time_edittext);
            prepTime.setText(DatabaseHelper.currentEditRecipe.prepTime);
            EditText ingredients= findViewById(R.id.ingredients_edit_text);
            String ing="•"+Recipe.ListtoString(DatabaseHelper.currentEditRecipe.Ingredients).replaceAll(",","\n•");
            ingredients.setText(ing);
        }
    }

    void saveRecipe()
    {
        String recipeName=((EditText)findViewById(R.id.name_of_recipe)).getText().toString();
        String cookTime=((EditText)findViewById(R.id.cooking_time_edittext)).getText().toString();
        String prepTime=((EditText)findViewById(R.id.prep_time_edittext)).getText().toString();
        String ingredients=((EditText)findViewById(R.id.ingredients_edit_text)).getText().toString();
        ingredients=ingredients.replaceAll("\n•",",");
        if(validate(recipeName,cookTime,prepTime,ingredients)){
            DatabaseHelper.currentEditRecipe.recipeName = recipeName;
            DatabaseHelper.currentEditRecipe.cookingTime = cookTime;
            DatabaseHelper.currentEditRecipe.prepTime = prepTime;
            DatabaseHelper.currentEditRecipe.Ingredients=Recipe.StringToList(ingredients,DatabaseHelper.currentEditRecipe.Ingredients,",");
        }
    }

    boolean validate(String recipeName, String cookTime, String prepTime, String ingredients)
    {
        if(recipeName.equals("") || cookTime.equals("") || prepTime.equals("") || ingredients.equals("")) {
            Toast.makeText(getApplicationContext(), "Fields cannot be empty", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(!DatabaseHelper.getRecipeByName(recipeName).recipeName.equals(""))
        {
            Toast.makeText(getApplicationContext(),"Recipe with the same name already exists",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}