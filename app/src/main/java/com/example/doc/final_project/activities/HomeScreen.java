package com.example.doc.final_project.activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.support.design.widget.TabLayout;
import com.example.doc.final_project.R;
import com.example.doc.final_project.adapters.ViewPagerAdapter;

/**
 * Created by Doc on 2017/02/02.
 */
public class HomeScreen extends AppCompatActivity {
    private ViewPager pager;
    private ViewPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        /*
        ***
         */
        pager = (ViewPager)findViewById(R.id.pager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager(),HomeScreen.this);
        pager.setAdapter(adapter);
//        TabLayout tabLayout = (TabLayout)findViewById(R.id.tab);
//        tabLayout.setupWithViewPager(viewPager);
        pager.setCurrentItem(1);
    }
}
