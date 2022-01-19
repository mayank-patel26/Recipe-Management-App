package com.javaproject.recipemanagementapp.Activities;

import static com.javaproject.recipemanagementapp.DatabaseHelper.checkemail;
import static com.javaproject.recipemanagementapp.DatabaseHelper.insertUserData;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.javaproject.recipemanagementapp.DatabaseHelper;
import com.javaproject.recipemanagementapp.R;

public class signup extends AppCompatActivity {

    EditText e1, e2, e3, e4;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        e1=findViewById(R.id.fullname);
        e2=findViewById(R.id.signup_email);
        e3=findViewById(R.id.signup_pass);
        e4=findViewById(R.id.reenter_pass);
        b1=findViewById(R.id.signup_btn1);

        /*ArrayList n=new ArrayList<Integer>();
        n.stream().forEach(x->System.out.println(x+3));*/

        b1.setOnClickListener(view -> {
            String s1 = e1.getText().toString().trim();
            String s2 = e2.getText().toString().trim();
            String s3 = e3.getText().toString().trim();
            String s4 = e4.getText().toString().trim();

            if(s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")) {
                Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
            }

            else {
                if (s3.equals(s4)) {
                    Boolean check = checkemail(s1);
                    if (!check) {
                        DatabaseHelper.insertUserData(s2, s3, s1);
                        DatabaseHelper.getAllRecipe();
                        Toast.makeText(getApplicationContext(), "Registered successfully", Toast.LENGTH_SHORT).show();
                        Intent intent2 = new Intent(signup.this, landing_page.class);
                        startActivity(intent2);
                    } else {
                        Toast.makeText(getApplicationContext(), "Email Address already exists", Toast.LENGTH_SHORT).show();
                        Intent intent2 = new Intent(signup.this, login.class);
                        startActivity(intent2);
                    }
                } else {
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