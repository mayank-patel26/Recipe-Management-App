package com.javaproject.recipemanagementapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.javaproject.recipemanagementapp.DatabaseHelper;
import com.javaproject.recipemanagementapp.R;
import com.javaproject.recipemanagementapp.Tables.Recipe;

import java.util.List;

public class all_recipe extends AppCompatActivity{
    TextView backbtn;

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

        backbtn = findViewById(R.id.back_btn);
        backbtn.setOnClickListener(view -> onBackPressed());
    }

    @Override
    public void onBackPressed() {
        Intent toExit = new Intent(this, landing_page.class);
        startActivity(toExit);
        super.onBackPressed();
    }

    void addOnClicks()
    {
        Button addButton=findViewById(R.id.add_button);
        addButton.setOnClickListener(view -> {
            DatabaseHelper.currentEditRecipe=new Recipe();
            DatabaseHelper.currentEditRecipe.Cuisine.add(recipeType);
            edit_recipe_ingredients.isCreating=true;
            Intent intent = new Intent(this, edit_recipe_ingredients.class);
            startActivity(intent);
        });

        ImageButton profile_button1 = findViewById(R.id.profile_button1);
        profile_button1.setOnClickListener(view -> {
            Intent profile = new Intent(all_recipe.this, options.class);
            startActivity(profile);
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

//    @Override  //OVERRIDES the BACK BUTTON press action
//    public void onBackPressed() {
//        recipeList.clear();
//        recipeAdapter.notifyDataSetChanged();
//        super.onBackPressed();
//    }


}