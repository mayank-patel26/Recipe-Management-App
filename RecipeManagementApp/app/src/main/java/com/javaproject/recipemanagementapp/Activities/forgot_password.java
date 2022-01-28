package com.javaproject.recipemanagementapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.javaproject.recipemanagementapp.DatabaseHelper;
import com.javaproject.recipemanagementapp.R;

public class forgot_password extends AppCompatActivity {
    EditText email, password_field;
    Button next, finalnext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        email = findViewById(R.id.pass_reset_email);
        password_field = findViewById(R.id.enter_NewPassword);
        next = findViewById(R.id.forgotpassword_next_btn);
        finalnext = findViewById(R.id.reset_password);

        Button reset_password = findViewById(R.id.reset_password);
        reset_password.setOnClickListener(view -> {

            String e1 = email.getText().toString().trim();
            String password = password_field.getText().toString().trim();

            DatabaseHelper.setNewPassword(e1, password);
            Toast.makeText(getApplicationContext(), "Password reset successful", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(forgot_password.this, login.class);
            startActivity(intent);
        });



        Button forgotpassword_next_btn = findViewById(R.id.forgotpassword_next_btn);
        forgotpassword_next_btn.setOnClickListener(view -> {

            String find_email = email.getText().toString().trim();

            if(find_email.equals(""))
            {
                Toast.makeText(getApplicationContext(), "Field is empty", Toast.LENGTH_SHORT).show();
            }
            else if(find_email.contains("@"))
            {

                boolean email_check = DatabaseHelper.findEmail(find_email);
                if(email_check){
                    email.setVisibility(View.INVISIBLE);
                    password_field.setVisibility(View.VISIBLE);
                    next.setVisibility(View.INVISIBLE);
                    finalnext.setVisibility(View.VISIBLE);

                    Toast.makeText(getApplicationContext(), "Email found successfully", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Incorrect email address", Toast.LENGTH_SHORT).show();
                }
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Please enter a valid Email!", Toast.LENGTH_SHORT).show();
            }
        });




    }
}
