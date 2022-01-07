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

public class login extends AppCompatActivity {
    DatabaseHelperM db;

    EditText e5, e6;
    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DatabaseHelperM(this);

        e5 = findViewById(R.id.login_email);
        e6 = findViewById(R.id.login_password);
        b2 = findViewById(R.id.login_btn1);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=e5.getText().toString();
                String password=e6.getText().toString();

//                User user = DatabaseHelper.getUserByEmail(email);
//                boolean check = user.validatePassword(password);
//                DatabaseHelper.setCurrentUser(user);












                /*Boolean Checkemailpassword = db.emailpassword(email, password);

                if(Checkemailpassword==true){

                    Toast.makeText(getApplicationContext(),"Login successful",Toast.LENGTH_SHORT).show();

                    Intent intent1 = new Intent(login.this, landing_page.class);
                    startActivity(intent1);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Wrong email or password", Toast.LENGTH_SHORT).show();
                }
*/
            }
        });



    }
}