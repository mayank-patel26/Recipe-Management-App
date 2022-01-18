package com.javaproject.recipemanagementapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.javaproject.recipemanagementapp.Tables.Recipe;
import com.javaproject.recipemanagementapp.Tables.User;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


public class DatabaseHelper
{
    //All DB functions are part of context class hence you can use it without context in AppCompactActivity derived classes
    public static User currentUser;
    public static SQLiteDatabase recipeAppDatabase;
    public static Recipe currentEditRecipe;
    public static List<Recipe> recipeList = new ArrayList<>();


    public static void setDB(Context context)
    {
        currentUser=new User();
        currentEditRecipe=new Recipe();
        //create a database if it doesn't exist
        recipeAppDatabase = context.openOrCreateDatabase("RecipeAppDatabase", Context.MODE_PRIVATE,null);
        recipeAppDatabase.execSQL("DROP TABLE recipe;");
        // create a recipe database table here
        recipeAppDatabase.execSQL("CREATE TABLE IF NOT EXISTS recipe(id INTEGER PRIMARY KEY AUTOINCREMENT, recipeName TEXT UNIQUE, ingredients TEXT, cuisine TEXT, procedure TEXT, servings INTEGER, cookingTime INTEGER, prepTime INTEGER, spiceLevel INTEGER, allergyWarning TEXT, rating INTEGER, tags TEXT,userID INTEGER)");
        //create the user table here
        recipeAppDatabase.execSQL("CREATE TABLE IF NOT EXISTS user(id INTEGER PRIMARY KEY AUTOINCREMENT, email TEXT UNIQUE, password TEXT, dateOfBirth TEXT, fullName TEXT, imagePath TEXT)");
        setInitialValues(context);

    }

    public static void insertUserData(String email1,String password1, String full_name)
    {
        //insert user values into the table here
        recipeAppDatabase.execSQL("INSERT INTO user(email, password, fullName) VALUES('"+email1+"','"+password1+"', '"+full_name+"');");
    }

    public static Boolean checkemail (String email)
    {
        Cursor cursor = recipeAppDatabase.rawQuery("SELECT * FROM user WHERE email = ?;", new String[]{email});

        return (cursor.getCount()>0);
    }



    public static void insertRecipeData(Recipe recipe)
    {
        //insert recipe values here and call this method to insert a new recipe
        String recipeToString=recipe.toString();
        recipeAppDatabase.execSQL("INSERT INTO recipe(recipeName,ingredients,cuisine, procedure, servings, cookingTime, prepTime, spiceLevel, allergyWarning, rating, tags) VALUES("+recipeToString+");");
    }
    public static Recipe getRecipeByName(String name)
    {
        Cursor cursor = recipeAppDatabase.rawQuery("Select * from recipe where recipeName = ?", new String[]{name});
        Recipe recipe=new Recipe();
        if(cursor.getCount()>0)
        {
            recipe.recipeID=cursor.getInt(0);
            recipe.recipeName=cursor.getString(1);
            recipe.Ingredients=Recipe.StringToList(cursor.getString(2),recipe.Ingredients,"~");
            recipe.Cuisine=Recipe.StringToList(cursor.getString(3),recipe.Cuisine,"~");
            recipe.procedure=cursor.getString(4);
            recipe.servings=cursor.getInt(5);
            recipe.cookingTime=cursor.getString(6);
            recipe.prepTime=cursor.getString(7);
            recipe.spiceLevel=cursor.getInt(8);
            recipe.allergyWarnings=cursor.getString(9);
            recipe.rating=cursor.getInt(10);
            recipe.tags=Recipe.StringToList(cursor.getString(11),recipe.tags,"~");
        }
        return  recipe;
    }
    public static User getUserByEmail(String email)
    {
        //get a specific user by the ID and return the user
        User user=new User();
        //get the user from DB and fill up 'user'
        Cursor cursor = recipeAppDatabase.rawQuery("Select * from user where email = ?", new String[]{email});
        user.ID=cursor.getInt(0);
        user.email=cursor.getString(1);
        user.password=cursor.getString(2);
        return user;
        //call method
        //User user=getUserByEmail(email)
        //DatabaseHelper.currentUser=user;
    }

    public static Boolean checklogin(String e1, String p1){
        Cursor cursor = recipeAppDatabase.rawQuery("SELECT * FROM user WHERE email = '"+e1+"' AND password = '"+p1+"';", new String[]{});
        return (cursor.getCount()>0);
    }

    public static boolean findEmail(String eml){
        Cursor cursor = recipeAppDatabase.rawQuery("SELECT email FROM user WHERE email = '"+eml+"';", new String[]{});
        return (cursor.getCount()>0);
    }

    public static void setNewPassword(String eml1, String new_password){
        recipeAppDatabase.execSQL("UPDATE user SET password = '"+new_password+"' WHERE email = '"+eml1+"';");
    }

    public static void setCurrentUser(User user)
    {
        currentUser=user;
    }

    public static void setInitialValues(Context context)
    {
        Cursor cursor = recipeAppDatabase.rawQuery("SELECT * FROM recipe",new String[]{});
        if(cursor.getCount()==0)
        {
            try {
                InputStream is = context.getAssets().open("initial_recipes.xml");

                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(is);

                Element element=doc.getDocumentElement();
                element.normalize();

                NodeList nList = doc.getElementsByTagName("recipe");

                for (int i=0; i<nList.getLength(); i++) {
                    Node node = nList.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element2 = (Element) node;
                        String recipeName=getValue("name",element2);
                        ArrayList<String> ingredients= new ArrayList<>(Arrays.asList(getValue("ingredients",element2).split(",")));
                        ArrayList<String> cuisine = new ArrayList<>(Arrays.asList(getValue("cuisine",element2).split(",")));
                        String procedure=getValue("procedure",element2);
                        int servings=Integer.parseInt(getValue("servings",element2));
                        String cooking_time=getValue("cooking_time",element2);
                        String prep_time=getValue("prep_time",element2);
                        int spice_level=Integer.parseInt(getValue("spice_level",element2));
                        String allergens=getValue("allergens",element2);
                        int rating=Integer.parseInt(getValue("rating",element2));
                        ArrayList<String> tags= new ArrayList<>(Arrays.asList(getValue("tags",element2).split(",")));
                        Recipe recipe = new Recipe(0,recipeName,ingredients,cuisine,procedure,servings,cooking_time,prep_time,spice_level,allergens,rating,tags);
                        insertRecipeData(recipe);
                    }
                }

            } catch (Exception e) {e.printStackTrace();}

        }
        }
        private static String getValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }

    public static void getAllRecipe(){
        String[] columns = {"id", "recipeName", "servings"};
        Cursor cursor = recipeAppDatabase.query("recipe", columns, null, null, null, null, null);

        while(cursor.moveToNext()){
            int index1 = cursor.getColumnIndex("id");
            int recipeid = cursor.getInt(index1);
            int index2 = cursor.getColumnIndex("recipeName");
            String name = cursor.getString(index2);
            int index3 = cursor.getColumnIndex("servings");
            int serving = cursor.getInt(index3);
            Recipe recipe = new Recipe();
            recipe.recipeID=recipeid;
            recipe.recipeName=name;
            recipe.servings=serving;
            recipeList.add(recipe);
        }
    }

}
    //Trial example - ignore
    /* create a database and confirm if it has been created by displaying value in a text field*/
    /*void confirmDBCreation(Context context)
    {
        //create a database if it doesn't exist
        SQLiteDatabase recipeAppDatabase = context.openOrCreateDatabase("RecipeAppDatabase",context.MODE_PRIVATE,null);

        //User dbName.execSQL to execute any SQL command
        // create a table if it doesn't exist
        recipeAppDatabase.execSQL("CREATE TABLE IF NOT EXISTS Recipe(Name TEXT,id INT PRIMARY KEY);");

        //insert values
        //recipeAppDatabase.execSQL("INSERT INTO Recipe VALUES('TrialYummyRecipe',1);");

        //get values
        Cursor result = recipeAppDatabase.rawQuery("Select * from Recipe",null);
        result.moveToFirst();
        String name = result.getString(0); //get first value from result set
        String id = result.getString(1); // get second value from result set

        //get the textView and change the name of the recipe to check(for now)
        //TextView textView=findViewById(R.id.startup_text);
        //textView.setText(name);
    }*/
