package com.javaproject.recipemanagementapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.javaproject.recipemanagementapp.DatabaseHelper;
import com.javaproject.recipemanagementapp.R;
import com.javaproject.recipemanagementapp.Tables.Recipe;

import java.util.List;

public class all_recipe extends AppCompatActivity{

    public static String recipeType;
    RecyclerView rvPrograms;
    RecipeAdapter recipeAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<Recipe> recipeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_recipe);
        setRecipeList();
        rvPrograms = findViewById(R.id.rvPrograms);
        rvPrograms.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        rvPrograms.setLayoutManager(layoutManager);
        recipeAdapter = new RecipeAdapter(this, recipeList, rvPrograms);
        rvPrograms.setAdapter(recipeAdapter);
        addOnClicks();
    }

    void addOnClicks()
    {
        Button addButton=findViewById(R.id.add_button);
        addButton.setOnClickListener(view -> {
            DatabaseHelper.currentEditRecipe=new Recipe();
            DatabaseHelper.currentEditRecipe.Cuisine.add(recipeType);
            edit_recipe_ingredients.isCreating=true;
            Intent intent =new Intent(this, edit_recipe_ingredients.class);
            startActivity(intent);
        });
    }

    void setRecipeList()
    {
        if(recipeType.equals("All Recipes"))
            recipeList=DatabaseHelper.recipeList;
        else
        {
            recipeList.clear();
            for (Recipe recipe:DatabaseHelper.recipeList) {
                if(recipe.Cuisine.contains(recipeType))
                    recipeList.add(recipe);
            }
        }
    }

    @Override
    public void onBackPressed() {
        recipeList.clear();
        recipeAdapter.notifyDataSetChanged();
        super.onBackPressed();
    }


}