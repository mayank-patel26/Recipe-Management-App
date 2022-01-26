package com.javaproject.recipemanagementapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Database;

import com.javaproject.recipemanagementapp.DatabaseHelper;
import com.javaproject.recipemanagementapp.R;

public class options extends AppCompatActivity {
    TextView optionEmail;
    Button signOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        addOnClicks();

        signOut = findViewById(R.id.signOut_btn);

        signOut.setOnClickListener(view -> {
            DatabaseHelper.resetRemStatus();
            Intent quitNow = new Intent(this, ExitPage.class);
            startActivity(quitNow);
        });

        optionEmail = findViewById(R.id.options_email);
        optionEmail.setText(String.valueOf(DatabaseHelper.currentUser.email));

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
            String email = DatabaseHelper.currentUser.email;
            DatabaseHelper.deleteUser(email);
            Toast.makeText(getApplicationContext(), "Account Deleted Successfully.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(options.this, login_signup.class);
            startActivity(intent);
        });
    }
}