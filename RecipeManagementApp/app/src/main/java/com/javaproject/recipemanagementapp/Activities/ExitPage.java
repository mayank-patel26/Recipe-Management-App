
package com.javaproject.recipemanagementapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.javaproject.recipemanagementapp.R;

public class ExitPage extends AppCompatActivity {
    Button cancel, exit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit_page);

        cancel = findViewById(R.id.Cancel_btn);
        exit = findViewById(R.id.Exit_btn);

        cancel.setOnClickListener(view -> {
            Intent toLandingPage = new Intent(this, landing_page.class);
            startActivity(toLandingPage);
        });

        exit.setOnClickListener(view -> {
            onBackPressed();
        });

    }


    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}