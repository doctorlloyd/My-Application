package com.example.admin.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.myapplication.activities.HomeScreen;
import com.example.admin.myapplication.pojos.Shop;
import com.example.doc.final_project.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

/**
 * Created by Admin on 2017/03/03.
 */

public class DisplayActivity extends AppCompatActivity {

    private DatabaseReference mDatabaseReference;

    private RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.global_list);

        mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("Shop");

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }


    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Shop, ShopViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Shop, ShopViewHolder>(
                Shop.class,
                R.layout.view_row,
                ShopViewHolder.class,
                mDatabaseReference

        ) {
            @Override
            protected void populateViewHolder(ShopViewHolder viewHolder, Shop model, int position) {

                viewHolder.setName(model.getShop_Name());
                viewHolder.setLocation(model.getShop_location());
                viewHolder.setImg(getApplicationContext(), model.getImage());

            }
        };

        recyclerView.setAdapter(firebaseRecyclerAdapter);

    }

    public static class ShopViewHolder extends RecyclerView.ViewHolder{

        View mView;

        public ShopViewHolder(View itemView) {
            super(itemView);

            mView = itemView;

        }

        public void setName(String name){

            TextView tvName = (TextView) mView.findViewById(R.id.tv_View_Name);
            tvName.setText(name);

        }

        public void setLocation(String location){

            TextView tvLocation = (TextView) mView.findViewById(R.id.tv_view_Location);
            tvLocation.setText(location);

        }

        public void setImg(Context c, String img){

            ImageView imageView = (ImageView) mView.findViewById(R.id.our_image);
            Picasso.with(c).load(img).into(imageView);

        }

    }
}