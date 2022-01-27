
package com.javaproject.recipemanagementapp.Activities;

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

        cancel = findViewById(R.id.signoutCancel_button);
        exit = findViewById(R.id.signoutConfirm_button);

        cancel.setOnClickListener(view -> {
//            Intent toLandingPage = new Intent(this, landing_page.class);
            super.onBackPressed();
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