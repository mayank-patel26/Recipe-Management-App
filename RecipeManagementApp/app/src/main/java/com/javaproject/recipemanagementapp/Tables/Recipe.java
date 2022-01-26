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
    public int userID;
    public String recipeName;
    public ArrayList<String> Ingredients;
    public ArrayList<String> Cuisine;
    public String procedure;
    public int servings;
    public String cookingTime;
    public String prepTime;


    public String getRecipeName() {
        return this.recipeName;
    }

    public int getServings() {
        return this.servings;
    }

    public String allergyWarnings;
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
        this.userID = 0;
        this.allergyWarnings = "";
        this.tags = new ArrayList<>();
    }

    public Recipe(int recipeID, String recipeName, ArrayList<String> ingredients, ArrayList<String> cuisine, String procedure, int servings, String cookingTime, String prepTime, int userID, String allergyWarnings, ArrayList<String> tags) {
        this.recipeID = recipeID;
        this.recipeName = recipeName;
        Ingredients = ingredients;
        Cuisine = cuisine;
        this.procedure = procedure;
        this.servings = servings;
        this.cookingTime = cookingTime;
        this.prepTime = prepTime;
        this.allergyWarnings = allergyWarnings;
        this.tags = tags;
        this.userID = userID;
    }

    public static ArrayList StringToList(String string, String character)
    {
        ArrayList<String> list=new ArrayList<>();
        list.addAll(Arrays.asList(string.split(character)));
        return list;
    }

    public static String ListtoString(ArrayList list) {
        String string=list.toString();
        string.replaceAll(",","~");
        return string.substring(1,string.length()-1);
    }

    public static String ListtoString(ArrayList list,String replacement) {
        String string=list.toString();
        string.replaceAll(",",replacement);
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
                "','" + allergyWarnings +
                "','" + ListtoString(tags) +
                "'," + userID;
    }
}


