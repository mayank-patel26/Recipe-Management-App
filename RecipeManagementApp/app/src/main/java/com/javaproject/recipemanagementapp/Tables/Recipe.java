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
import java.util.Arrays;

public class Recipe {
    public int recipeID;
    public String recipeName;
    public ArrayList<String> Ingredients;
    public ArrayList<String> Cuisine;
    public String procedure;
    public int servings;
    public String cookingTime;
    public String prepTime;
    public int spiceLevel;

//    public Recipe(int recipeID, String recipeName, int servings) {
//        this.recipeID = recipeID;
//        this.recipeName = recipeName;
//        this.servings = servings;
//    }

    public int getRecipeID() {
        return this.recipeID;
    }

    public String getRecipeName() {
        return this.recipeName;
    }

    public int getServings() {
        return this.servings;
    }

    public String allergyWarnings;
    public int rating;
    public ArrayList<String> tags;

    public Recipe() {
        this.recipeID = 0;
        this.recipeName = "";
        Ingredients = new ArrayList<>();
        Cuisine = new ArrayList<>();
        this.procedure = "";
        this.servings = 0;
        this.cookingTime = "";
        this.prepTime = "";
        this.spiceLevel = 0;
        this.allergyWarnings = "";
        this.rating = 0;
        this.tags = new ArrayList<>();
    }

    public Recipe(int recipeID, String recipeName, ArrayList<String> ingredients, ArrayList<String> cuisine, String procedure, int servings, String cookingTime, String prepTime, int spiceLevel, String allergyWarnings, int rating, ArrayList<String> tags) {
        this.recipeID = recipeID;
        this.recipeName = recipeName;
        Ingredients = ingredients;
        Cuisine = cuisine;
        this.procedure = procedure;
        this.servings = servings;
        this.cookingTime = cookingTime;
        this.prepTime = prepTime;
        this.spiceLevel = spiceLevel;
        this.allergyWarnings = allergyWarnings;
        this.rating = rating;
        this.tags = tags;
    }

    public static ArrayList StringToList(String string, ArrayList list,String character)
    {
        list.addAll(Arrays.asList(string.split(character)));
        return list;
    }

    public static String ListtoString(ArrayList list) {
        String string=list.toString();
        string.replaceAll(",","~");
        return string.substring(1,string.length()-1);
    }

    @Override
    public String toString() {
        return  "'" + recipeName + "'," +
                "'" + ListtoString(Ingredients) +
                "','" + ListtoString(Cuisine) +
                "','" + procedure +
                "'," + servings +
                ",'" + cookingTime +
                "','" + prepTime +
                "'," + spiceLevel +
                ",'" + allergyWarnings +
                "'," + rating +
                ",'" + ListtoString(tags)+"'";
    }
}


