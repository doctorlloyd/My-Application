package com.example.admin.myapplication.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.doc.final_project.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodItemRegistration extends Fragment {


    public FoodItemRegistration() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.food_item_registration, container, false);
    }

}
