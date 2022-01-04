package com.javaproject.recipemanagementapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.javaproject.recipemanagementapp.R;

import java.util.ArrayList;
import java.util.List;

public class intro_scroll extends AppCompatActivity {
    private ViewPager screenPager;
    IntroViewPagerAdapter introViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_scroll);

        Button intro_skip = findViewById(R.id.intro_skip);
        intro_skip.setOnClickListener(view -> {
            Intent intent1 = new Intent(intro_scroll.this, login_signup.class);
            startActivity(intent1);
        });

        //fill list screen

        List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("App Feature 1", R.drawable.temp_app_logo));
        mList.add(new ScreenItem("App Feature 2", R.drawable.temp_app_logo));
        mList.add(new ScreenItem("App Feature 3", R.drawable.temp_app_logo));

        //setup viewpager
        ViewPager screenPager = findViewById(R.id.screen_viewpager);
        introViewPagerAdapter = new IntroViewPagerAdapter(this, mList);
        screenPager.setAdapter(introViewPagerAdapter);
    }
}