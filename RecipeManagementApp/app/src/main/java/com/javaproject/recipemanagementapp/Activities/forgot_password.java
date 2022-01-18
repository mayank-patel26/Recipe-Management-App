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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        email = findViewById(R.id.pass_reset_email);
        password_field = findViewById(R.id.enter_NewPassword);

        Button reset_password = findViewById(R.id.reset_password);
        reset_password.setOnClickListener(view -> {

            String e1 = email.getText().toString();
            String password = password_field.getText().toString();

            DatabaseHelper.setNewPassword(e1, password);

            Intent intent = new Intent(forgot_password.this, login.class);
            startActivity(intent);
        });



        Button forgotpassword_next_btn = findViewById(R.id.forgotpassword_next_btn);
        forgotpassword_next_btn.setOnClickListener(view -> {

            String find_email=email.getText().toString();

            if(find_email.equals(""))
            {
                Toast.makeText(getApplicationContext(), "Field is empty", Toast.LENGTH_SHORT).show();
            }
            else
            {

                boolean email_check = DatabaseHelper.findEmail(find_email);
                if(email_check){
                    password_field.setVisibility(View.VISIBLE);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Incorrect email address", Toast.LENGTH_SHORT).show();
                }
            }

        });




    }
}
