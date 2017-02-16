package com.example.admin.myapplication.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.doc.final_project.R;
import com.example.admin.myapplication.adapters.ViewPagerAdapterLogin;

public class SecondScreen extends AppCompatActivity {
    private String locationOfMyChoice = "Protea glen ext 3";
    private ViewPagerAdapterLogin pagerAdapterLogin;
    private ViewPager pager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager) findViewById(R.id.login_pager);
        pagerAdapterLogin = new ViewPagerAdapterLogin(getSupportFragmentManager(),SecondScreen.this);
        pager.setAdapter(pagerAdapterLogin);
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tab);
        tabLayout.setupWithViewPager(pager);
        pager.setCurrentItem(1);


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
////                        .setAction("Action", null).show();
//                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
//                        Uri.parse("google.navigation:q= "+locationOfMyChoice));
//                startActivity(intent);
//            }
//        });
    }
}
