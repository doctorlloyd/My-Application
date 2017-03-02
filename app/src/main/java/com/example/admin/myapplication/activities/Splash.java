package com.example.admin.myapplication.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.admin.myapplication.AddShopActivity;
import com.example.doc.final_project.R;

public class Splash extends AppCompatActivity {
    Button btnButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        btnButton= (Button) findViewById(R.id.btnNext);
        btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
             public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AddShopActivity.class);
                startActivity(intent);
             }
         }
        );
    }
}
