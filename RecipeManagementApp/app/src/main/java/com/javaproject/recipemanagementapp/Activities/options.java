package com.javaproject.recipemanagementapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.javaproject.recipemanagementapp.DatabaseHelper;
import com.javaproject.recipemanagementapp.R;
import com.javaproject.recipemanagementapp.Tables.Recipe;

public class options extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        addOnClicks();
    }

    void addOnClicks()
    {
        Button change_password = (Button) findViewById(R.id.change_password);
        change_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(options.this, change_password.class);
                startActivity(intent);
            }
        });

        Button deactive_account = (Button) findViewById(R.id.deactive_account);
        deactive_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = DatabaseHelper.currentUser.email;
                DatabaseHelper.deleteUser(email);
                Toast.makeText(getApplicationContext(), "Account Deleted Successfully.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(options.this, login_signup.class);
                startActivity(intent);
            }
        });
    }
}