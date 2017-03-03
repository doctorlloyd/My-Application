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
import com.google.firebase.storage.StorageReference;

/**
 * A simple {@link Fragment} subclass.
 */
public class FurnitureItemRegistration extends Fragment {

    public static String TAG =  FurnitureItemRegistration.class.getSimpleName();
    private EditText etFurnitureID,etFurnitureType,etFurnitureBrandName,etFurnitureSpecification,etFurnitureSize,etFurnitureNormalPrice,etFurniturePercentageOFF,etFurnitureReducedPrice,etFurnitureColor;
    private Button btn_add_furniture;
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

    public FurnitureItemRegistration() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_furniture_item_registration,container,false);
        view = rootView;
        initialize();



        return rootView;
    }

    public void initialize()
    {
        etFurniturePercentageOFF = (EditText) view.findViewById(R.id.etFurniturePercentageOFF);
        etFurnitureBrandName = (EditText) view.findViewById(R.id.etFurnitureBrandName);
        etFurnitureID= (EditText) view.findViewById(R.id.etFurnitureID);
        etFurnitureNormalPrice= (EditText) view.findViewById(R.id.etFoodNormalPrice);
        etFurnitureReducedPrice= (EditText) view.findViewById(R.id.etFurnitureReducedPrice);
        etFurnitureSize= (EditText) view.findViewById(R.id.etFurnitureSize);
        etFurnitureType= (EditText) view.findViewById(R.id.etFurnitureType);
        etFurnitureSpecification= (EditText) view.findViewById(R.id.etFurnitureSpecification);
        etFurnitureColor= (EditText) view.findViewById(R.id.etFurnitureColor);
    }
}
