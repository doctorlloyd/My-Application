package com.example.admin.myapplication.activities;

import android.support.annotation.Px;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.doc.final_project.R;
import com.example.admin.myapplication.adapters.ViewPagerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Doc on 2017/02/02.
 */
public class HomeScreen extends AppCompatActivity {

    private DatabaseReference mDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("Shops");

    }


    public static class ShopViewHolder extends RecyclerView.ViewHolder{

        View mView;

        public ShopViewHolder(View itemView) {
            super(itemView);

            mView = itemView;

        }

        public void setShop_Name(String name){

            TextView tvName = (TextView) mView.findViewById(R.id.tv_ShopName);
            tvName.setText(name);

        }

        public void setShop_location(String location){

            TextView tvLocation = (TextView) mView.findViewById(R.id.tv_Location);
            tvLocation.setText(location);

        }

//        public void set

    }

}
