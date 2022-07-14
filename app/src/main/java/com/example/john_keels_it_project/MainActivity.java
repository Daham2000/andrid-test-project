package com.example.john_keels_it_project;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.john_keels_it_project.adapter.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    //private static final String TAG = "MainActivity";
    TabLayout tabLayout;
    ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get view pager and tab layout view xml ui component
        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tabs);

        //set tab layout adapter to view pager
        viewPager.setAdapter(createPagerAdapter());

        //set tabs and names to the tab layout
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    if (position == 0) {
                        tab.setText("Add Student");
                    } else {
                        tab.setText("Get Student");
                    }
                }).attach();
    }

    //Return the pager adapter
    private ViewPagerAdapter createPagerAdapter() {
        return new ViewPagerAdapter(this);
    }
}