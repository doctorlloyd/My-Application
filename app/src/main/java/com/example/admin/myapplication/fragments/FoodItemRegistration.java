package com.example.admin.myapplication.fragments;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.doc.final_project.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodItemRegistration extends Fragment {

    public static String TAG =  FoodItemRegistration.class.getSimpleName();
    private EditText etFoodID,etFoodType,etFoodBrandName,etFoodSpecification,etFoodSize,etFoodNormalPrice,etFoodAmountOFF,etFoodReducedPrice;
    private Button btn_add_food;
    private FirebaseUser user;
    private String uid = null;
    private static final int GALLERY_INTENT = 1;
    private ImageButton imageButton;
    private View view;
    private DatabaseReference databaseReference;
    Uri imageUri;

    private StorageReference mStorageReference;
    // [START declare_auth]
    private FirebaseAuth mAuth;
    // [END declare_auth]

    // [START declare_auth_listener]
    private FirebaseAuth.AuthStateListener mAuthListener;
    // [END declare_auth_listener]

    public FoodItemRegistration() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.food_item_registration,container,false);
        view = rootView;
        initialize();

        mStorageReference = FirebaseStorage.getInstance().getReference();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Shop").child("Food");


        return rootView;
    }

    public void initialize()
    {
        etFoodAmountOFF = (EditText) view.findViewById(R.id.etFoodAmountOFF);
        etFoodBrandName = (EditText) view.findViewById(R.id.etFoodBrandName);
        etFoodID= (EditText) view.findViewById(R.id.etFoodID);
        etFoodNormalPrice= (EditText) view.findViewById(R.id.etFoodNormalPrice);
        etFoodReducedPrice= (EditText) view.findViewById(R.id.etFoodReducedPrice);
        etFoodSize= (EditText) view.findViewById(R.id.etFoodSize);
        etFoodType= (EditText) view.findViewById(R.id.etFoodType);
        etFoodSpecification= (EditText) view.findViewById(R.id.etFoodSpecification);
    }

}
