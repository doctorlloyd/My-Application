package com.example.admin.myapplication.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import com.example.admin.myapplication.fragments.ClothingRegistration;
import com.example.doc.final_project.R;

public class Item_Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item__registration);

        String _categoty = getIntent().getStringExtra("fragment_category");
        try {
            if (_categoty.equalsIgnoreCase("clothing")) {
                ClothingRegistration f = new ClothingRegistration();
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.item__registration, f);
                ft.addToBackStack(ClothingRegistration.TAG);
                ft.commit();
            }
        }catch (Exception e)
        {

        }finally {
            ClothingRegistration f = new ClothingRegistration();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.item__registration, f);
            ft.addToBackStack(ClothingRegistration.TAG);
            ft.commit();
        }

    }
}
