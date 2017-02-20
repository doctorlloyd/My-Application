package com.example.admin.myapplication.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.doc.final_project.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Doc on 2017/02/01.
 */

public class Clothing_Fragment extends Fragment implements SearchView.OnQueryTextListener{
    public static final String TAG = Furniture_Fragment.class.getSimpleName();
    private SearchView searchLocation;
    /*
    *** Declaring database reference
     */
    private DatabaseReference mDatabase;
    private String locationOfMyChoice = "Protea glen ext 3";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.clothing_main_fragment,container,false);
        /*
        *** Initializing database reference (FIRE_BASE)
        *** Then initialising search view object
         */
        mDatabase = FirebaseDatabase.getInstance().getReference();
        searchLocation = (SearchView) rootView.findViewById(R.id.searchLocation);
        searchLocation.setSubmitButtonEnabled(true);
        searchLocation.setOnQueryTextListener(this);

        return rootView;
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
        ***
         */

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        return false;
    }
}
