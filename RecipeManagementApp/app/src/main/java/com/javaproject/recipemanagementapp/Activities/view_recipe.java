package com.javaproject.recipemanagementapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.Button;
import android.widget.TextView;

import com.javaproject.recipemanagementapp.AddBulletPoints;
import com.javaproject.recipemanagementapp.DatabaseHelper;
import com.javaproject.recipemanagementapp.R;
import com.javaproject.recipemanagementapp.Tables.Recipe;

import org.w3c.dom.Text;

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
        TextView cookingTime=findViewById(R.id.cooking_time_text2);
        TextView prepTime=findViewById(R.id.prep_time_value);
        TextView servings=findViewById(R.id.servings_value);

        ingredients.setText("Ingredients :");
        name.setText(DatabaseHelper.currentEditRecipe.recipeName);
        ArrayList<String> ingredientsList= DatabaseHelper.currentEditRecipe.Ingredients;
        ArrayList<String> allergens= new ArrayList<>(Arrays.asList(DatabaseHelper.currentEditRecipe.allergyWarnings.split("~")));
        for (String ing:ingredientsList) {
            String first=ingredients.getText().toString();
            ingredients.setText(first + "\n• "+ ing, TextView.BufferType.SPANNABLE);
            Spannable s = (Spannable)ingredients.getText();
            if(allergens.contains(ing)){
                s.setSpan(new ForegroundColorSpan(0xFFFF0000), first.length(), first.length()+ing.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
        String cuisineStr="Cuisine : \n• "+Recipe.ListtoString(DatabaseHelper.currentEditRecipe.Cuisine,"\n• ");
        cuisine.setText(cuisineStr);
        String procedureStr="Procedure : \n• "+DatabaseHelper.currentEditRecipe.procedure.replaceAll("~","\n• ");
        procedure.setText(procedureStr);
        String tagsStr = "Tags :\n# "+Recipe.ListtoString(DatabaseHelper.currentEditRecipe.tags,"# ");
        tags.setText(tagsStr);
        cookingTime.setText(String.valueOf(DatabaseHelper.currentEditRecipe.cookingTime));
        prepTime.setText(String.valueOf(DatabaseHelper.currentEditRecipe.prepTime));
        servings.setText(String.valueOf(DatabaseHelper.currentEditRecipe.servings));
    }
}