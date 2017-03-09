package com.example.admin.myapplication.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.admin.myapplication.pojos.Clothing;
import com.example.admin.myapplication.pojos.Food;
import com.example.admin.myapplication.pojos.Furniture;
import com.example.doc.final_project.R;

public class Splash extends AppCompatActivity {

    private String shop_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailed_item_screen);
        String _category = getIntent().getStringExtra("_category");
        shop_name = getIntent().getStringExtra("shop_name");
        if(_category.equalsIgnoreCase("Food"))
        {
            Food food = (Food) getIntent().getSerializableExtra("model");


        }else if(_category.equalsIgnoreCase("Clothing")) {
            Clothing clothing = (Clothing) getIntent().getSerializableExtra("model");


        }else {
            Furniture furniture = (Furniture) getIntent().getSerializableExtra("model");


        }
    }
}
