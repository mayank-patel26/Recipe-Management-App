package com.javaproject.recipemanagementapp.Activities;

import static com.javaproject.recipemanagementapp.DatabaseHelper.checkemail;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.javaproject.recipemanagementapp.DatabaseHelper;
import com.javaproject.recipemanagementapp.R;

public class signup extends AppCompatActivity {

    EditText FName, Signup_email, Signup_pass, Reenter_pass;
    Button SignUpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        FName=findViewById(R.id.fullname);
        Signup_email=findViewById(R.id.signup_email);
        Signup_pass=findViewById(R.id.signup_pass);
        Reenter_pass=findViewById(R.id.reenter_pass);
        SignUpBtn=findViewById(R.id.signup_btn1);

        SignUpBtn.setOnClickListener(view -> {
            String fname = FName.getText().toString().trim();
            String signup_email = Signup_email.getText().toString().trim();
            String signup_pass = Signup_pass.getText().toString().trim();
            String reenter_pass = Reenter_pass.getText().toString().trim();

            if(fname.equals("")||signup_email.equals("")||signup_pass.equals("")||reenter_pass.equals("")) {
                Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
            }

            else {
                if (signup_pass.equals(reenter_pass)) {
                    Boolean check = DatabaseHelper.checkemail(signup_email);
                    if (!check) {
                        DatabaseHelper.insertUserData(signup_email, signup_pass, fname);
                        DatabaseHelper.getAllRecipe();
                        Toast.makeText(getApplicationContext(), "Registered successfully", Toast.LENGTH_SHORT).show();
                        Intent intent22 = new Intent(signup.this, landing_page.class);
                        startActivity(intent22);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Email Address already exists, please login", Toast.LENGTH_SHORT).show();
                        Intent intent42 = new Intent(signup.this, login.class);
                        startActivity(intent42);
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
                }
            }
        });



//        confirmDBCreation();

//        Button signup_btn1 = findViewById(R.id.signup_btn1);
//        signup_btn1.setOnClickListener(view -> {

//        });

    }

//    void confirmDBCreation()
//    {
//        //create a database if it doesn't exist
//        SQLiteDatabase recipeAppDatabase = openOrCreateDatabase("RecipeAppDatabase",MODE_PRIVATE,null);
//
//        //User dbName.execSQL to execute any SQL command
//        // create a table if it doesn't exist
//        recipeAppDatabase.execSQL("CREATE TABLE IF NOT EXISTS Credentials(email TEXT PRIMARY KEY, pass TEXT);");
//
//        //insert values
//        recipeAppDatabase.execSQL("INSERT INTO Recipe VALUES('TrialYummyRecipe',1);");
//
//        //get values
//        Cursor result = recipeAppDatabase.rawQuery("Select * from Recipe",null);
//        result.moveToFirst();
//        String name = result.getString(0); //get first value from result set
//        String id = result.getString(1); // get second value from result set
//
//        //get the textView and change the name of the recipe to check(for now)
//        TextView textView=findViewById(R.id.startup_text);
//        textView.setText(name);
//    }

}