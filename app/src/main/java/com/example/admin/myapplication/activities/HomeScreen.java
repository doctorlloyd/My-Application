package com.example.admin.myapplication.activities;

import android.support.annotation.Px;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import com.example.doc.final_project.R;
import com.example.admin.myapplication.adapters.ViewPagerAdapter;

/**
 * Created by Doc on 2017/02/02.
 */
public class HomeScreen extends AppCompatActivity {
    private ViewPager pager;
    private ViewPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_view_pager);

        /*
        ***
         */
        pager = (ViewPager)findViewById(R.id.home_pager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager(),HomeScreen.this);
        pager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tab);
        tabLayout.setupWithViewPager(pager);
        pager.setCurrentItem(1);
    }

}
