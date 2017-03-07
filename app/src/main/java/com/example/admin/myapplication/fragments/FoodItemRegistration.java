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
import com.example.admin.myapplication.pojos.Food;
import com.example.doc.final_project.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodItemRegistration extends Fragment {

    public static String TAG =  FoodItemRegistration.class.getSimpleName();
    private EditText etFoodID,etFoodSpecialDuration,etFoodType,etFoodBrandName,etFoodSpecification,etFoodWeight,etFoodNormalPrice,etFoodAmountOFF,etFoodReducedPrice;
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
        etFoodSpecialDuration= (EditText) view.findViewById(R.id.etFoodSpecialDuration);
        etFoodWeight= (EditText) view.findViewById(R.id.etFoodSize);
        etFoodType= (EditText) view.findViewById(R.id.etFoodType);
        etFoodSpecification= (EditText) view.findViewById(R.id.etFoodSpecification);
        btn_add_food = (Button) view.findViewById(R.id.btnfood_item_register);
        imageButton = (ImageButton) view.findViewById(R.id.imgbtn_food_item);
    }
    //[CREATING AN OBJECT OF A CLOTHE]
    public void addAnItem() {
        if (validateNullInput()) {
            // [START create_user_with_email]
            uid = user.getUid();
            databaseReference = FirebaseDatabase.getInstance().getReference("Shop").child("Clothing").child("Item");


            StorageReference filePath = mStorageReference.child("my_image").child(imageUri.getLastPathSegment());
            filePath.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    String food_ID = etFoodID.getText().toString();
                    String food_type = etFoodType.getText().toString();
                    String foodSale_Duration = etFoodSpecialDuration.getText().toString();
                    int food_Amount_Off = Integer.parseInt(etFoodAmountOFF.getText().toString());
                    double food_Reduced_Price = Double.parseDouble(etFoodReducedPrice.getText().toString());
                    double food_Normal_Price = Double.parseDouble(etFoodNormalPrice.getText().toString());
                    String food_Shop_ID = uid;
//                    String food_Shop_ID = databaseReference.getKey();
                    String food_Weight = etFoodWeight.getText().toString();
                    String food_Brand_Name = etFoodBrandName.getText().toString();
                    String food_Specification = etFoodSpecification.getText().toString();

                    Uri downloadUri = taskSnapshot.getDownloadUrl();
                    String image = downloadUri.toString();
                    Food food = new Food(food_Amount_Off,image,food_Brand_Name,food_ID,food_Normal_Price,food_Reduced_Price,food_Shop_ID,foodSale_Duration,food_Specification,food_type,food_Weight);
                    String _key = databaseReference.push().getKey();
                    databaseReference.child(_key).setValue(food);

                }
            });

        }
    }

    public boolean validateNullInput() {
        if (TextUtils.isEmpty(etFoodAmountOFF.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(etFoodBrandName.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(etFoodID.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(etFoodNormalPrice.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(etFoodReducedPrice.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(etFoodWeight.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(etFoodType.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(etFoodSpecification.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(etFoodSpecialDuration.getText().toString()))
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