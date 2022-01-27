package com.javaproject.recipemanagementapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.javaproject.recipemanagementapp.AddBulletPoints;
import com.javaproject.recipemanagementapp.DatabaseHelper;
import com.javaproject.recipemanagementapp.R;
import com.javaproject.recipemanagementapp.Tables.Recipe;

public class edit_recipe_ingredients extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_recipe_ingredients);
        AddBulletPoints.setBulletPoints(findViewById(R.id.ingredients_edit_text),"•");
        AddBulletPoints.setBulletPoints(findViewById(R.id.cuisine_edit_text),"•");
        addOnButtonClicks();
        populateRecipe();
    }
    void addOnButtonClicks()
    {
        Button next = findViewById(R.id.next_button);
        next.setOnClickListener(view -> {

            saveRecipe();
            Intent intent = new Intent(this, edit_recipe_method.class);
            startActivity(intent);
        });
    }

    void populateRecipe()
    {
            EditText name = findViewById(R.id.name_of_recipe);
            name.setText(DatabaseHelper.currentEditRecipe.recipeName);
            EditText cookTime = findViewById(R.id.cooking_time_edittext);
            cookTime.setText(DatabaseHelper.currentEditRecipe.cookingTime);
            EditText servings = findViewById(R.id.servings_edittxt);
            servings.setText(DatabaseHelper.currentEditRecipe.servings);
            EditText prepTime= findViewById(R.id.prep_time_edittext2);
            prepTime.setText(DatabaseHelper.currentEditRecipe.prepTime);
            EditText cuisine= findViewById(R.id.cuisine_edit_text);
            String cui=Recipe.ListtoString(DatabaseHelper.currentEditRecipe.Cuisine).replaceAll(",","\n•");
            cuisine.setText(cui);
            EditText ingredients= findViewById(R.id.ingredients_edit_text);
            String ing=Recipe.ListtoString(DatabaseHelper.currentEditRecipe.Ingredients).replaceAll(",","\n•");
            ingredients.setText(ing);
    }

    void saveRecipe()
    {
        String recipeName=((EditText)findViewById(R.id.name_of_recipe)).getText().toString();
        String cookTime=((EditText)findViewById(R.id.cooking_time_edittext)).getText().toString();
        String servings=((EditText)findViewById(R.id.servings_edittxt)).getText().toString();
        String prepTime=((EditText)findViewById(R.id.prep_time_edittext2)).getText().toString();
        prepTime=prepTime.equals("")?"-":prepTime;
        String ingredients=((EditText)findViewById(R.id.ingredients_edit_text)).getText().toString();
        String cuisine=((EditText)findViewById(R.id.cuisine_edit_text)).getText().toString();
        ingredients=ingredients.replaceAll("\n•",",");
        cuisine=cuisine.replaceAll("\n•",",");
        if(validate(recipeName,cookTime,ingredients,servings))
        {
            DatabaseHelper.currentEditRecipe.recipeName = recipeName;
            DatabaseHelper.currentEditRecipe.cookingTime = cookTime;
            DatabaseHelper.currentEditRecipe.prepTime = prepTime;
            DatabaseHelper.currentEditRecipe.Ingredients=Recipe.StringToList(ingredients,",");
            DatabaseHelper.currentEditRecipe.Cuisine=Recipe.StringToList(cuisine,",");
            DatabaseHelper.currentEditRecipe.servings=Integer.parseInt(servings);
        }
    }
    public static boolean isCreating=false;
    boolean validate(String recipeName, String cookTime, String ingredients,String servings)
    {
        if(recipeName.equals("") || cookTime.equals("") || ingredients.equals("")) {
            Toast.makeText(getApplicationContext(), "Fields cannot be empty", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if((!DatabaseHelper.getRecipeByName(recipeName).recipeName.equals(""))&&isCreating)
        {
            Toast.makeText(getApplicationContext(),"Recipe with the same name already exists",Toast.LENGTH_SHORT).show();
            return false;
        }
        else
        {
            try{
                Integer.parseInt(servings);
            }
            catch (NumberFormatException e)
            {
                Toast.makeText(getApplicationContext(),"Incorrect Serving count",Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        return true;
    }
}