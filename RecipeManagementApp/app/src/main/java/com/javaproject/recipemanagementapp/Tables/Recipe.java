package com.javaproject.recipemanagementapp.Tables;

/* Room code
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Recipe
{
    @PrimaryKey
    int recipeID;

    @ColumnInfo(name = "Name")
    public String recipeName;
}*/

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    public int recipeID;
    public String recipeName;
    ArrayList<String> Ingredients;
    ArrayList<String> Cuisine;
    String procedure;
    int servings;
    String cookingTime;
    String prepTime;
    int spiceLevel;
    String allergyWarnings;
    int rating;
    List<String> tags;

}

