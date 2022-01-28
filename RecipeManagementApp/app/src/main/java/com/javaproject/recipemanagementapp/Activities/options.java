package com.javaproject.recipemanagementapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.javaproject.recipemanagementapp.DatabaseHelper;
import com.javaproject.recipemanagementapp.R;
import com.javaproject.recipemanagementapp.Tables.Recipe;

import java.util.List;

public class options extends AppCompatActivity {
    public TextView optionEmail;
    Button signOut;
    List<Recipe> recipeListSignOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        addOnClicks();

        signOut = findViewById(R.id.signOut_btn);
        recipeListSignOut=DatabaseHelper.recipeList;

        signOut.setOnClickListener(view -> {
            DatabaseHelper.resetRemStatus();
            Intent toLoginSignup = new Intent(this, login_signup.class);
            startActivity(toLoginSignup);
            recipeListSignOut.clear();
        });

        optionEmail = findViewById(R.id.options_email);
        optionEmail.setText(DatabaseHelper.currentUser.email.trim());
    }

    void addOnClicks()
    {
        Button change_password = findViewById(R.id.change_password);
        change_password.setOnClickListener(v -> {
            Intent intent = new Intent(options.this, change_password.class);
            startActivity(intent);
        });

        Button deactive_account = findViewById(R.id.deactive_account);
        deactive_account.setOnClickListener(v -> {
            recipeListSignOut.clear();
            String email = DatabaseHelper.currentUser.email;
            DatabaseHelper.deleteUser(email);
            Toast.makeText(getApplicationContext(), "Account Deleted Successfully.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(options.this, login_signup.class);
            startActivity(intent);
        });
    }
}