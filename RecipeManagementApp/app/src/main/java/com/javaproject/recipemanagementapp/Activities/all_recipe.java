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

    RecyclerView rvPrograms;
    RecipeAdapter recipeAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<Recipe> recipeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_recipe);
        DatabaseHelper.getAllRecipe();
        recipeList = DatabaseHelper.recipeList;
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
            Intent intent =new Intent(this,add_or_edit_recipe.class);
            startActivity(intent);
        });
    }


    @Override
    public void onBackPressed() {
        recipeList.clear();
        recipeAdapter.notifyDataSetChanged();
        super.onBackPressed();
    }


}