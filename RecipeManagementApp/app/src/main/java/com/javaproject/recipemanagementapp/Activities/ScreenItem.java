package com.javaproject.recipemanagementapp.Activities;

public class ScreenItem {

    String title;
    int ScreenImg;

    public ScreenItem(String title, int screenImg) {
        this.title = title;
        ScreenImg = screenImg;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setScreenImg(int screenImg) {
        ScreenImg = screenImg;
    }

    public String getTitle() {
        return title;
    }

    public int getScreenImg() {
        return ScreenImg;
    }
}
