package com.javaproject.recipemanagementapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.javaproject.recipemanagementapp.DatabaseHelper;
import com.javaproject.recipemanagementapp.R;

public class change_password extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        addOnClicks();
    }

    void addOnClicks() {
        Button changePass = (Button) findViewById(R.id.changePass);
        changePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView newPassword = findViewById(R.id.new_password);
                TextView oldPassword = findViewById(R.id.old_password);
                String newPassStr = newPassword.getText().toString();
                String oldPassStr = oldPassword.getText().toString();
                String email = DatabaseHelper.currentUser.email;
                if (oldPassStr.equals(DatabaseHelper.currentUser.password)){
                    if (newPassStr.equals(oldPassStr)){
                        Toast.makeText(getApplicationContext(), "New Password cannot be the same as Old!", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        DatabaseHelper.setNewPass_options(email, oldPassStr, newPassStr);
                        Intent intent = new Intent(change_password.this, options.class);
                        Toast.makeText(getApplicationContext(), "Password Changed Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "Incorrect Password!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}