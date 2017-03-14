package com.example.admin.myapplication.activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.admin.myapplication.pojos.Clothing;
import com.example.admin.myapplication.pojos.Shop;
import com.example.doc.final_project.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class ClothingRecyclerView extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DatabaseReference mDatabaseReference;
    private RecyclerView recyclerView;
    private Shop shop;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.global_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

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

        FirebaseRecyclerAdapter<Clothing, ClothingViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Clothing, ClothingViewHolder>(
                Clothing.class,
                R.layout.item_raw_view,
                ClothingViewHolder.class,
                mDatabaseReference

        ) {
            @Override
            protected void populateViewHolder(ClothingViewHolder viewHolder, final Clothing item, int position) {
                final String _key = getRef(position).getKey();
                viewHolder.setName(item.getClothing_Brand_Name());
                viewHolder.setDescription(item.getClothing_Specification());
                viewHolder.setImg(getApplicationContext(), item.getImage());

                viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(), "Key: " + _key, Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(),ItemDisplay.class);
                        intent.putExtra("item", item);
                        intent.putExtra("shop",shop);
                        startActivity(intent);
                    }
                });

            }
        };

        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_refresh) {
            startActivity(new Intent(getApplicationContext(),ClothingRecyclerView.class));
            finish();
        } else if (id == R.id.nav_shop_centre) {
            startActivity(new Intent(getApplicationContext(),MapActivity.class));
            finish();
        } else if (id == R.id.nav_navigate) {
            Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("google.navigation:q= "));
//        startActivity(intent);

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
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
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(),ShopsRecyclerView.class));
        finish();
    }
}
