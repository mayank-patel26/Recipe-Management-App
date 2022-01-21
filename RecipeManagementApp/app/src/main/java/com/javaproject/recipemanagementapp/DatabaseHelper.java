package com.javaproject.recipemanagementapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

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
    //All DB functions are part of context class hence you can't use it without context in AppCompactActivity derived classes
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
        // create a recipe database table here
        recipeAppDatabase.execSQL("CREATE TABLE IF NOT EXISTS recipe(id INTEGER PRIMARY KEY AUTOINCREMENT, recipeName TEXT UNIQUE, ingredients TEXT, cuisine TEXT, procedure TEXT, servings INTEGER, cookingTime INTEGER, prepTime INTEGER, allergyWarning TEXT, tags TEXT,userID INTEGER)");
        //create the user table here
        recipeAppDatabase.execSQL("CREATE TABLE IF NOT EXISTS user(id INTEGER PRIMARY KEY AUTOINCREMENT, email TEXT UNIQUE, password TEXT, dateOfBirth TEXT, fullName TEXT, imagePath TEXT)");
        setInitialValues(context);
    }

    public static void insertUserData(String email1,String password1, String full_name)
    {
        //insert user values into the table here
        recipeAppDatabase.execSQL("INSERT INTO user(email, password, fullName) VALUES('"+email1+"','"+password1+"', '"+full_name+"');");
        currentUser=new User();
        currentUser.email=email1;
        currentUser.password=password1;
        currentUser.fullName=full_name;
    }

    public static Boolean checkemail (String email)
    {
        Cursor cursor = recipeAppDatabase.rawQuery("SELECT * FROM user WHERE email = ?;", new String[]{email});
        if(cursor.getCount()>0)
        {
            setCurrentUser(cursor);
            return true;
        }
        return true;
    }



    public static void insertRecipeData(Recipe recipe)
    {
        //insert recipe values here and call this method to insert a new recipe
        String recipeToString=recipe.toString();
        recipeAppDatabase.execSQL("INSERT OR REPLACE INTO recipe(recipeName,ingredients,cuisine, procedure, servings, cookingTime, prepTime, allergyWarning, tags, userID) VALUES("+recipeToString+");");
        recipeList.add(recipe);
    }
    public static Recipe getRecipeByName(String name)
    {
        for (Recipe recipe:recipeList) {
            if(recipe.recipeName.trim().equalsIgnoreCase(name.trim()))
                return recipe;
        }
        return  new Recipe();
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

    public static void setCurrentUser(Cursor cursor)
    {
        User user=new User();
        user.ID=cursor.getInt(0);
        user.email=cursor.getString(1);
        user.password=cursor.getString(2);
        currentUser=user;
    }

    private static void setInitialValues(Context context)
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
                        int user_id=Integer.parseInt(getValue("user_id",element2));
                        String allergens=getValue("allergens",element2);
                        ArrayList<String> tags= new ArrayList<>(Arrays.asList(getValue("tags",element2).split(",")));
                        Recipe recipe = new Recipe(0,recipeName,ingredients,cuisine,procedure,servings,cooking_time,prep_time,user_id,allergens,tags);
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
        String[] columns = {"id", "recipeName", "ingredients", "cuisine", "procedure", "servings", "cookingTime", "prepTime", "userID", "allergyWarning", "tags"};
        Cursor cursor = recipeAppDatabase.query("recipe", columns, null, null, null, null, null);

        while(cursor.moveToNext()){
            String[] values =new String[columns.length];
            for (int i = 0; i < columns.length; i++) {
                values[i]=cursor.getString((int)cursor.getColumnIndex(columns[i]));
            }
            try{
                if(Integer.parseInt(values[8])==-1||Integer.parseInt(values[8])==DatabaseHelper.currentUser.ID) {
                    Recipe recipe = new Recipe(Integer.parseInt(values[0]), values[1], Recipe.StringToList(values[2], ","), Recipe.StringToList(values[3], ","), values[4], Integer.parseInt(values[5]), values[6], values[7], Integer.parseInt(values[8]), values[9], Recipe.StringToList(values[10], "~"));
                    recipeList.add(recipe);
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }

}