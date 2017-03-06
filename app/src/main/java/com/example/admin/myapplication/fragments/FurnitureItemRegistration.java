package com.example.admin.myapplication.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import com.example.admin.myapplication.pojos.Furniture;
import com.example.doc.final_project.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class FurnitureItemRegistration extends Fragment {

    public static String TAG = FurnitureItemRegistration.class.getSimpleName();
    private EditText etFurnitureID, etFurnitureSaleDuration, etFurnitureType, etFurnitureBrandName, etFurnitureSpecification, etFurnitureSize, etFurnitureNormalPrice, etFurniturePercentageOFF, etFurnitureReducedPrice, etFurnitureColor;
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
        View rootView = inflater.inflate(R.layout.fragment_furniture_item_registration, container, false);
        view = rootView;
        initialize();


        return rootView;
    }

    public void initialize() {
        etFurniturePercentageOFF = (EditText) view.findViewById(R.id.etFurniturePercentageOFF);
        etFurnitureBrandName = (EditText) view.findViewById(R.id.etFurnitureBrandName);
        etFurnitureID = (EditText) view.findViewById(R.id.etFurnitureID);
        etFurnitureNormalPrice = (EditText) view.findViewById(R.id.etFoodNormalPrice);
        etFurnitureReducedPrice = (EditText) view.findViewById(R.id.etFurnitureReducedPrice);
        etFurnitureSize = (EditText) view.findViewById(R.id.etFurnitureSize);
        etFurnitureType = (EditText) view.findViewById(R.id.etFurnitureType);
        etFurnitureSaleDuration = (EditText) view.findViewById(R.id.etFurnitureSaleDuration);
        etFurnitureSpecification = (EditText) view.findViewById(R.id.etFurnitureSpecification);
        etFurnitureColor = (EditText) view.findViewById(R.id.etFurnitureColor);
        btn_add_furniture = (Button) view.findViewById(R.id.furniture_item_register);
        imageButton = (ImageButton) view.findViewById(R.id.imgbtn_furniture_item);
    }

    //[CREATING AN OBJECT OF A FURNITURE]
    public void addAnItem() {
        if (validateNullInput()) {
            uid = user.getUid();
            databaseReference = FirebaseDatabase.getInstance().getReference("Shop").child("Clothing").child("Item");


            StorageReference filePath = mStorageReference.child("my_image").child(imageUri.getLastPathSegment());
            filePath.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    String furniture_ID = etFurnitureID.getText().toString();
                    String furniture_type = etFurnitureType.getText().toString();
                    String furnitureSale_Duration = etFurnitureSaleDuration.getText().toString();
                    String furniture_color = etFurnitureColor.getText().toString();
                    int furniture_Percentage_Off = Integer.parseInt(etFurniturePercentageOFF.getText().toString());
                    double furniture_Reduced_Price = Double.parseDouble(etFurnitureReducedPrice.getText().toString());
                    double furniture_Normal_Price = Double.parseDouble(etFurnitureNormalPrice.getText().toString());
                    String furniture_Shop_ID = uid;
//                    String clothing_Shop_ID = databaseReference.getKey();
                    String furniture_Size = etFurnitureSize.getText().toString();
                    String furniture_Brand_Name = etFurnitureBrandName.getText().toString();
                    String furniture_Specification = etFurnitureSpecification.getText().toString();

                    Uri downloadUri = taskSnapshot.getDownloadUrl();
                    String image = downloadUri.toString();

                    Furniture furniture = new Furniture(furniture_Brand_Name, image, furniture_color, furniture_ID, furniture_Normal_Price, furniture_Percentage_Off, furniture_Reduced_Price, furniture_Shop_ID, furniture_Size, furnitureSale_Duration, furniture_Specification, furniture_type);
                    String _key = databaseReference.push().getKey();
                    databaseReference.child(_key).setValue(furniture);

                }
            });
        }
    }

    public boolean validateNullInput() {
        if (TextUtils.isEmpty(etFurniturePercentageOFF.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(etFurnitureBrandName.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(etFurnitureID.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(etFurnitureNormalPrice.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(etFurnitureReducedPrice.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(etFurnitureSize.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(etFurnitureType.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(etFurnitureSpecification.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(etFurnitureSaleDuration.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(etFurnitureColor.getText().toString()))
            return false;
        return true;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GALLERY_INTENT && resultCode == RESULT_OK) {

            imageUri = data.getData();
            imageButton.setImageURI(imageUri);
        }

    }
}
