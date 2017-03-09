package com.example.admin.myapplication.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.admin.myapplication.pojos.Clothing;
import com.example.doc.final_project.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.io.Serializable;

public class ClothingRecyclerView extends AppCompatActivity {
    private DatabaseReference mDatabaseReference;
    private RecyclerView recyclerView;
    private String shop_name;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.global_list);

        String _key = getIntent().getStringExtra("_key");
        String _category = getIntent().getStringExtra("_category");
        shop_name = getIntent().getStringExtra("shop_name");
        mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("Shop").child(_key).child(_category);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Clothing, ClothingViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Clothing, ClothingViewHolder>(
                Clothing.class,
                R.layout.item_raw_view,
                ClothingViewHolder.class,
                mDatabaseReference

        ) {
            @Override
            protected void populateViewHolder(ClothingViewHolder viewHolder, final Clothing model, int position) {
                final String _key = getRef(position).getKey();
                viewHolder.setName(model.getClothing_Brand_Name());
                viewHolder.setDescription(model.getClothing_Specification());
                viewHolder.setImg(getApplicationContext(), model.getImage());

                viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(), "Key: " + _key, Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(),Splash.class);
                        intent.putExtra("model", model);
                        intent.putExtra("_category","Clothing");
                        intent.putExtra("shop_name",shop_name);
                        startActivity(intent);
                    }
                });

            }
        };

        recyclerView.setAdapter(firebaseRecyclerAdapter);

    }

    public static class ClothingViewHolder extends RecyclerView.ViewHolder{

        View mView;

        public ClothingViewHolder(View itemView) {
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