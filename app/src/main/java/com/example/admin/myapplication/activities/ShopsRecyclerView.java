package com.example.admin.myapplication.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.admin.myapplication.pojos.Shop;
import com.example.doc.final_project.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

/**
 * Created by Doc on 3/4/2017.
 */

public class ShopsRecyclerView extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DatabaseReference mDatabaseReference;
    private RecyclerView recyclerView;
    private String _key;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.global_list);
        mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("Shop");

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
            protected void populateViewHolder(ShopViewHolder viewHolder, final Shop model, int position) {
                viewHolder.setName(model.getShop_Name());
                viewHolder.setLocation(model.getShop_location());
                viewHolder.setImg(getApplicationContext(), model.getImage());
                _key = getRef(position).getKey();

                viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(model.getShop_Category().equalsIgnoreCase("Clothing")){
                            Toast.makeText(getApplicationContext(), "Key: " + _key, Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getApplicationContext(),ClothingRecyclerView.class);
                            intent.putExtra("_key",_key);
                            intent.putExtra("model",model);
                            startActivity(intent);
                            finish();
                        }else if(model.getShop_Category().equalsIgnoreCase("Food")){
                            Toast.makeText(getApplicationContext(), "Key: " + _key, Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getApplicationContext(),FoodRecyclerView.class);
                            intent.putExtra("_key",_key);
                            intent.putExtra("model",model);
                            startActivity(intent);
                            finish();
                        }else {
                            Toast.makeText(getApplicationContext(), "Key: " + _key, Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getApplicationContext(),FurnitureRecyclerView.class);
                            intent.putExtra("_key",_key);
                            intent.putExtra("model",model);
                            startActivity(intent);
                            finish();
                        }
                    }
                });
            }
        };
        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }
//
//    @Override
//    public void onDataChange(DataSnapshot dataSnapshot) {
//
//
//    }
//
//    @Override
//    public void onCancelled(DatabaseError databaseError) {
//        // Failed to read value
////                Log.w(TAG, "Failed to read value.", error.toException());
//        showMessage("getting service providers".toUpperCase(), "Failed to read value");
//
//    }
//    //======================= drawer itemselected method starts here ===========//
//
//    //--------------- the show message method starts here --------------------//
//    public void showMessage(String title, String message) {
//        AlertDialog.Builder dialog = new AlertDialog.Builder(getApplicationContext()/*, R.style.AppThemeNoActionBar*/);
////        dialog.setIcon(R.mipmap.ic_launcher);
//        dialog.setTitle(title.toUpperCase());
//        dialog.setMessage(message);
//        dialog.show();
//        dialog.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                //the user clicked on Cancel
//            }
//        });
//    }
////===================== show message ends here ===========================//

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
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sample, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_refresh) {
            startActivity(new Intent(getApplicationContext(),ShopsRecyclerView.class));
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
}
