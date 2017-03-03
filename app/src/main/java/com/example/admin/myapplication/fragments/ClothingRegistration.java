package com.example.admin.myapplication.fragments;


import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.admin.myapplication.pojos.Clothing;
import com.example.doc.final_project.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.StorageReference;

public class ClothingRegistration extends Fragment {

    public static String TAG =  ClothingRegistration.class.getSimpleName();
    private EditText etClothingID,etClothingType,etClotheBrandName,etClotheSpecification,etClotheSize,etClotheNormalPrice,etClothePercentageOFF,etClotheReducedPrice;
    private Button btn_add_clothe;
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
    public ClothingRegistration() {
        // Required empty public constructor
        
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.clothing_registration,container,false);
        view = rootView;
        initialize();


        return rootView;
    }

    public void initialize()
    {
        etClothePercentageOFF = (EditText) view.findViewById(R.id.etClothePercentageOFF);
        etClotheBrandName = (EditText) view.findViewById(R.id.etClotheBrandName);
        etClothingID= (EditText) view.findViewById(R.id.etClotheID);
        etClotheNormalPrice= (EditText) view.findViewById(R.id.etClotheNormalPrice);
        etClotheReducedPrice= (EditText) view.findViewById(R.id.etClotheReducedPrice);
        etClotheSize= (EditText) view.findViewById(R.id.etClotheSize);
        etClothingType= (EditText) view.findViewById(R.id.etClotheType);
        etClotheSpecification= (EditText) view.findViewById(R.id.etClotheSpecification);
    }
}
