package com.example.admin.myapplication.activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.admin.myapplication.fragments.ClothingRegistration;
import com.example.admin.myapplication.fragments.FoodItemRegistration;
import com.example.admin.myapplication.fragments.FurnitureItemRegistration;
import com.example.admin.myapplication.pojos.Shop;
import com.example.doc.final_project.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Item_Registration extends AppCompatActivity {

    private DatabaseReference databaseReference;
    private FirebaseAuth user;
    private FirebaseUser fbuser;
    String _category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item__registration);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Shop");
        user = FirebaseAuth.getInstance();
        fbuser = user.getCurrentUser();

        databaseReference.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Shop shop = ds.getValue(Shop.class);
                    if (shop.getEmail().equals(fbuser.getEmail())) {
                        _category = shop.getShop_Category();
                        try {
                            if (_category.equalsIgnoreCase("Clothing")) {
                                ClothingRegistration f = new ClothingRegistration();
                                FragmentManager fm = getSupportFragmentManager();
                                FragmentTransaction ft = fm.beginTransaction();
                                ft.replace(R.id.item__registration, f);
                                ft.addToBackStack(ClothingRegistration.TAG);
                                ft.commit();
                                databaseReference.removeEventListener(this);
                            } else if (_category.equalsIgnoreCase("Food")) {
                                FoodItemRegistration f = new FoodItemRegistration();
                                FragmentManager fm = getSupportFragmentManager();
                                FragmentTransaction ft = fm.beginTransaction();
                                ft.replace(R.id.item__registration, f);
                                ft.addToBackStack(FoodItemRegistration.TAG);
                                ft.commit();
                                databaseReference.removeEventListener(this);
                            } else if(_category.equalsIgnoreCase("Furniture")){
                                FurnitureItemRegistration f = new FurnitureItemRegistration();
                                FragmentManager fm = getSupportFragmentManager();
                                FragmentTransaction ft = fm.beginTransaction();
                                ft.replace(R.id.item__registration, f);
                                ft.addToBackStack(FurnitureItemRegistration.TAG);
                                ft.commit();
                                databaseReference.removeEventListener(this);
                            }
                        } catch(Exception e) {
                            Toast.makeText(getApplicationContext(),"Could not load information",Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }

}
