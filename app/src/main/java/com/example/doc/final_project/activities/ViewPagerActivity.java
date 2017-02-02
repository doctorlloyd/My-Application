package com.example.doc.final_project.activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.example.doc.final_project.R;
import com.example.doc.final_project.adapters.ViewPagerAdapter;

/**
 * Created by Doc on 2017/02/01.
 */
public class ViewPagerActivity extends AppCompatActivity {
    private ViewPager pager;
    private ViewPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_view_pager);
//        pager = (ViewPager)findViewById(R.id.pager);
//        adapter = new ViewPagerAdapter(getSupportFragmentManager(),this);
//        pager.setAdapter(adapter);
//        pager.setCurrentItem(1);
    }
}
