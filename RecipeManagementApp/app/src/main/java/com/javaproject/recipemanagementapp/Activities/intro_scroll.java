package com.javaproject.recipemanagementapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.javaproject.recipemanagementapp.R;

import java.util.ArrayList;
import java.util.List;

public class intro_scroll extends AppCompatActivity {
        private ViewPager screenPager;
        IntroViewPagerAdapter introViewPagerAdapter;

        TabLayout tabIndicator;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_intro_scroll);

                Button intro_skip = findViewById(R.id.intro_skip);
                intro_skip.setOnClickListener(view -> {
                        Intent intent1 = new Intent(intro_scroll.this, login_signup.class);
                        startActivity(intent1);
                });

                //ini views

                tabIndicator = findViewById(R.id.tab_indicator);


                //fill list screen
                String str1 = "Multiple users can use the same device without worrying about losing their recipe data";
                String str2 = "Have a fun time cooking from the prebuilt recipe list that comes with the app";
                String str3 = "Manage your collection by adding, editing or deleting the recipe";

                List<ScreenItem> mList = new ArrayList<>();
                mList.add(new ScreenItem(str1, R.drawable.multi_users));
                mList.add(new ScreenItem(str2, R.drawable.saved_recipes));
                mList.add(new ScreenItem(str3, R.drawable.edit_save));

                //setup viewpager
                ViewPager screenPager = findViewById(R.id.screen_viewpager);
                introViewPagerAdapter = new IntroViewPagerAdapter(this, mList);
                screenPager.setAdapter(introViewPagerAdapter);

                //setup tablayout with viewpager

                tabIndicator.setupWithViewPager(screenPager);
        }
}