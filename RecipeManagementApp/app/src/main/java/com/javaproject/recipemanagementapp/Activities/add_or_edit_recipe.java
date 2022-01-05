package com.javaproject.recipemanagementapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import com.javaproject.recipemanagementapp.AddBulletPoints;
import com.javaproject.recipemanagementapp.R;

public class add_or_edit_recipe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_or_edit_recipe);
        AddBulletPoints.setBulletPoints(findViewById(R.id.ingredients_edit_text));
    }

//    void setOnClicks()
//    {
//        Button done=findViewById(R.id.done_button);
//        done.setOnClickListener();
//    }

}