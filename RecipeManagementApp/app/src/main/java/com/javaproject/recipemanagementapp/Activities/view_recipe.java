package com.javaproject.recipemanagementapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.widget.Button;
import android.widget.TextView;

import com.javaproject.recipemanagementapp.AddBulletPoints;
import com.javaproject.recipemanagementapp.DatabaseHelper;
import com.javaproject.recipemanagementapp.R;
import com.javaproject.recipemanagementapp.Tables.Recipe;

import java.util.ArrayList;
import java.util.Arrays;

public class view_recipe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_recipe);
        populateRecipe();
        Button edit = findViewById(R.id.edit_btn);
        edit.setOnClickListener(view -> {
            Intent intent1 = new Intent(this, edit_recipe_ingredients.class);
            startActivity(intent1);
        });
    }

    void populateRecipe()
    {
        TextView name=findViewById(R.id.recipe_name_txt);
        TextView ingredients=findViewById(R.id.ingredients_text);
        TextView cuisine=findViewById(R.id.cuisine_txt);
        TextView procedure=findViewById(R.id.procedure_txt);
        TextView tags=findViewById(R.id.tags_txt);

        ingredients.setText("");
        name.setText(DatabaseHelper.currentEditRecipe.recipeName);
        ArrayList<String> ingredientsList= DatabaseHelper.currentEditRecipe.Ingredients;
        ArrayList<String> allergens= (ArrayList<String>) Arrays.asList(DatabaseHelper.currentEditRecipe.allergyWarnings.split("~"));
        for (String allergen:allergens) {
            if(ingredientsList.contains(allergen)) {
                String first=ingredients.getText().toString();
                String next=allergen;
                ingredients.setText(first + "\n• "+ next, TextView.BufferType.SPANNABLE);
                Spannable s = (Spannable)ingredients.getText();
                int start = first.length();
                int end = start + next.length();
                s.setSpan(new ForegroundColorSpan(0xFFFF0000), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
        String cuisineStr=Recipe.ListtoString(DatabaseHelper.currentEditRecipe.Cuisine,"\n• ");
        cuisine.setText(cuisineStr);
        String procedureStr=DatabaseHelper.currentEditRecipe.procedure.replaceAll("~","\n• ");
        procedure.setText(procedureStr);
        String tagsStr = Recipe.ListtoString(DatabaseHelper.currentEditRecipe.tags,"# ");
        tags.setText(tagsStr);
    }
}