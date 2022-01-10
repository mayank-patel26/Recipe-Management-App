
package com.javaproject.recipemanagementapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.javaproject.recipemanagementapp.AddBulletPoints;
import com.javaproject.recipemanagementapp.R;

public class view_recipe_method extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_recipe_method);
        AddBulletPoints.setBulletPoints(findViewById(R.id.recipe_procedure));
    }

    void addButtonOnClicks()
    {
        Button get_started = findViewById(R.id.next_button_method);
        get_started.setOnClickListener(view -> {
            Intent intent = new Intent(this, view_recipe_method.class);
            startActivity(intent);
        });
    }
}