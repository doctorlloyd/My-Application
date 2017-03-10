package com.example.admin.myapplication.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.admin.myapplication.pojos.Furniture;
import com.example.admin.myapplication.pojos.Shop;
import com.example.doc.final_project.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

/**
 * Created by Admin on 2017/03/09.
 */

public class FurnitureRecyclerView extends AppCompatActivity {
    private DatabaseReference mDatabaseReference;
    private RecyclerView recyclerView;
    private Shop shop;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.global_list);

        shop = (Shop)getIntent().getSerializableExtra("model");

        String _key = getIntent().getStringExtra("_key");
        String _category = shop.getShop_Category();
        mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("Shop").child(_key).child(_category);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Furniture, FurnitureViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Furniture,FurnitureViewHolder>(
                Furniture.class,
                R.layout.item_raw_view,
                FurnitureViewHolder.class,
                mDatabaseReference

        ) {
            @Override
            protected void populateViewHolder(FurnitureViewHolder viewHolder, final Furniture item, int position) {
                final String _key = getRef(position).getKey();
                viewHolder.setName(item.getFurniture_Brand_Name());
                viewHolder.setDescription(item.getFurniture_Specification());
                viewHolder.setImg(getApplicationContext(), item.getImage());

                viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(), "Key: " + _key, Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(),Splash.class);
                        intent.putExtra("item", item);
                        intent.putExtra("shop",shop);
                        startActivity(intent);
                    }
                });

            }
        };

        recyclerView.setAdapter(firebaseRecyclerAdapter);

    }

    public static class FurnitureViewHolder extends RecyclerView.ViewHolder{

        View mView;

        public FurnitureViewHolder(View itemView) {
            super(itemView);

            mView = itemView;

        }

        public void setName(String name){

            TextView tvName = (TextView) mView.findViewById(R.id.itemName);
            tvName.setText(name);

        }

        public void setDescription(String description){

            TextView tvLocation = (TextView) mView.findViewById(R.id.itemSpecification);
            tvLocation.setText(description);

        }

        public void setImg(Context c, String img){

            ImageView imageView = (ImageView) mView.findViewById(R.id.itemIcon);
            Picasso.with(c).load(img).into(imageView);

        }
    }
}
