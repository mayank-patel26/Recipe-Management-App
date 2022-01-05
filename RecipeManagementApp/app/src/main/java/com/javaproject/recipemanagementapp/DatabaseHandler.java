package com.javaproject.recipemanagementapp;

import com.javaproject.recipemanagementapp.Tables.User;

public class DatabaseHandler
{
    static User currentUser;
    static void setDB()
    {
        currentUser=new User();
    }
}
