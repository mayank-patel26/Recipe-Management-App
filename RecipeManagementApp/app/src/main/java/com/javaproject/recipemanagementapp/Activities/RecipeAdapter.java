package com.javaproject.recipemanagementapp.Activities;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.javaproject.recipemanagementapp.DatabaseHelper;
import com.javaproject.recipemanagementapp.R;
import com.javaproject.recipemanagementapp.Tables.Recipe;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {
    Context context;
    List<Recipe> recipeList;
    RecyclerView rvPrograms;
    RecipeAdapter recipeAdapter;

    final View.OnClickListener onClickListener = new MyOnClickListener();

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView recipe_name;
        TextView recipeServing;
        ImageButton dustbin;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            recipe_name = itemView.findViewById(R.id.item_name);
            recipeServing = itemView.findViewById(R.id.servings);
            dustbin = itemView.findViewById(R.id.ViewDelete);
        }
    }


    public RecipeAdapter(Context context, List<Recipe> recipeList, RecyclerView rvPrograms) {
        this.context = context;
        this.recipeList = recipeList;
        this.rvPrograms = rvPrograms;
    }


    @NonNull
    @Override
    public RecipeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_recipe, viewGroup, false);
        view.setOnClickListener(onClickListener);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeAdapter.ViewHolder viewHolder, int i) {
        Recipe recipe = recipeList.get(i);
        viewHolder.recipe_name.setText(String.valueOf(recipe.getRecipeName()));
        viewHolder.recipeServing.setText(String.valueOf(recipe.getServings()));
        viewHolder.dustbin.setOnClickListener(view -> {
            DatabaseHelper.deleteRecipe(recipe);
            Intent refresh = new Intent(context, all_recipe.class);
            context.startActivity(refresh);
        });
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    private class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            int itemPosition = rvPrograms.getChildAdapterPosition(v);
            DatabaseHelper.currentEditRecipe = recipeList.get(itemPosition);
            Intent intent = new Intent(context, view_recipe.class);
            context.startActivity(intent);

        }
    }
}

