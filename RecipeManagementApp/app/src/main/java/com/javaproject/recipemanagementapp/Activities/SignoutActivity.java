package com.javaproject.recipemanagementapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.javaproject.recipemanagementapp.R;

public class SignoutActivity extends AppCompatActivity {
    Button Cancel, Confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signout);
        Cancel = findViewById(R.id.signoutCancel_button);
        Confirm = findViewById(R.id.signoutConfirm_button);
        addOnClicks();
    }

    void addOnClicks()
    {
        Button signoutCancel_button = findViewById(R.id.signoutCancel_button);
        signoutCancel_button.setOnClickListener(v -> {
                onBackPressed();
            });

            Button signoutConfirm_button = findViewById(R.id.signoutConfirm_button);
            signoutConfirm_button.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), "Signed Out Successfully", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(SignoutActivity.this, login_signup.class);
            startActivity(intent);
            });
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }
}