package com.example.admin.myapplication.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
    private Shop shop;
    // [START declare_auth_listener]
    private FirebaseAuth.AuthStateListener mAuthListener;
    // [END declare_auth_listener]

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_registration);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Shop");
        user = FirebaseAuth.getInstance();
        fbuser = user.getCurrentUser();

        databaseReference.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    shop = ds.getValue(Shop.class);
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
        // [START auth_state_listener]
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                fbuser = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Toast.makeText(getApplicationContext(),"onAuthStateChanged:signed_in",Toast.LENGTH_LONG).show();

                } else {
                    // User is signed out
                    Toast.makeText(getApplicationContext(),"onAuthStateChanged:signed_out",Toast.LENGTH_LONG).show();
                }
            }
        };
        // [END auth_state_listener]
    }
    // [START on_start_add_listener]
    @Override
    public void onStart() {
        super.onStart();
        user.addAuthStateListener(mAuthListener);
    }
    // [END on_start_add_listener]

    // [START on_stop_remove_listener]
    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            user.removeAuthStateListener(mAuthListener);
        }
    }
    private void signOut() {
        user.signOut();
        user.removeAuthStateListener(mAuthListener);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setCancelable(false);
        dialog.setTitle("You're about to logout..");
        dialog.setMessage("Are you sure you want to logout now?" );
        dialog.setPositiveButton("Logout", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                //Action for "Logout".
                signOut();
                startActivity(new Intent(getBaseContext(),ShopRegisterOrLogin.class));
                finish();
            }
        })
                .setNegativeButton("Cancel ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Action for "Cancel".
                        startActivity(new Intent(getBaseContext(),Item_Registration.class));
                        finish();
                    }
                });

        final AlertDialog alert = dialog.create();
        alert.show();
    }
}
