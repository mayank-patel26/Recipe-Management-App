
package com.javaproject.recipemanagementapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.javaproject.recipemanagementapp.AddBulletPoints;
import com.javaproject.recipemanagementapp.DatabaseHelper;
import com.javaproject.recipemanagementapp.R;
import com.javaproject.recipemanagementapp.Tables.Recipe;

public class edit_recipe_method extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_edit_recipe_method);
        AddBulletPoints.setBulletPoints(findViewById(R.id.recipe_procedure),"•");
        addButtonOnClicks();
    }

    void addButtonOnClicks()
    {
        Button next = findViewById(R.id.done_button_tags_allergen);
        next.setOnClickListener(view -> {
            saveMethod();
            Intent intent = new Intent(this, tags_allergen.class);
            startActivity(intent);
        });
    }

    void saveMethod()
    {
        String method=((EditText)findViewById(R.id.recipe_procedure)).getText().toString();
        method.replaceAll("\n•","~");
        DatabaseHelper.currentEditRecipe.procedure=method;
    }
}