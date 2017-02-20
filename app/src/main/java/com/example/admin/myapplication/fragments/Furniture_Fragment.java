package com.example.admin.myapplication.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.doc.final_project.R;
import com.example.admin.myapplication.pojos.Furniture;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Doc on 2017/02/01.
 */

public class Furniture_Fragment extends Fragment implements SearchView.OnQueryTextListener{
    public static final String TAG = Furniture_Fragment.class.getSimpleName();
    @BindView(R.id.searchLocation)SearchView searchLocation;
    @BindView(R.id.searchSupermarket)SearchView searchSupermarket;
    @BindView(R.id.searchProduct)SearchView searchProduct;
    /*
    *** Declaring database reference
     */
    private DatabaseReference mDatabaseReference;
    private String locationOfMyChoice = "Protea glen ext 3";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.furniture_main_fragment,container,false);
        /*
        *** Initializing database reference (FIRE_BASE)
        *** Then initialising search view object
         */
        ButterKnife.bind(this,rootView);
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();
        setListeners();

//
//        mFirebaseInstance = FirebaseDatabase.getInstance();
//        // get reference to 'users' node
//        mFirebaseDatabase = mFirebaseInstance.getReference();
//        // store app title to 'app_title' node
//        mFirebaseInstance.getReference("app_title").setValue("Realtime Database");

        return rootView;
    }

    private void setListeners() {
        searchLocation.setSubmitButtonEnabled(true);
        searchLocation.setOnQueryTextListener(this);
        searchSupermarket.setSubmitButtonEnabled(true);
        searchSupermarket.setOnQueryTextListener(this);
        searchProduct.setSubmitButtonEnabled(true);
        searchProduct.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
         /*
        *** Creating an Intent that would trigger the Google maps API....
        *** After it will then set the location entered as destination point.
         */
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("google.navigation:q= "+query));
        startActivity(intent);
        /*
        *** Creating a listener to listen to the events that will be happening when the firebase database is invoked
         */
        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Furniture object and use the values to update the UI
                Furniture furniture = dataSnapshot.getValue(Furniture.class);
                if(furniture!=null)
                {
                    /*
                    *** Create an adapter that will receive the objects retrieved...
                    *** Send the objects to the adapter..
                    *** Set the views on that adapter.
                     */
                }else {
                    Toast.makeText(getContext(),"Could not locate the information requested",Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());

            }
        };
        // Add the listener object to the database reference
        mDatabaseReference.addValueEventListener(postListener);

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        return false;
    }
}
