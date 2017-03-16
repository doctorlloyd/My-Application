package com.example.admin.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.admin.myapplication.adapters.Shop_Resister_Login_Adapter;
import com.example.doc.final_project.R;

public class ShopRegisterOrLogin extends AppCompatActivity {
    private ViewPager pager;
    private Shop_Resister_Login_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_register_or_login_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        pager = (ViewPager)findViewById(R.id.shop_login_signup_pager);
        adapter = new Shop_Resister_Login_Adapter(getSupportFragmentManager(),ShopRegisterOrLogin.this);
        pager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout)findViewById(R.id.shop_login_signup_tab);
        tabLayout.setupWithViewPager(pager);
        pager.setCurrentItem(0);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(),ShopsRecyclerView.class));
        finish();
    }
}
