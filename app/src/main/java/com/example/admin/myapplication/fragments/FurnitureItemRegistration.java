package com.example.admin.myapplication.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.admin.myapplication.activities.ShopRegisterOrLogin;
import com.example.admin.myapplication.activities.ShopsRecyclerView;
import com.example.admin.myapplication.pojos.Furniture;
import com.example.admin.myapplication.pojos.Shop;
import com.example.doc.final_project.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 * Created by Doc
 */
public class FurnitureItemRegistration extends Fragment {

    public static String TAG = FurnitureItemRegistration.class.getSimpleName();
    private EditText etFurnitureID, etFurnitureSaleDuration, etFurnitureType, etFurnitureBrandName, etFurnitureSpecification, etFurnitureSize, etFurnitureNormalPrice, etFurniturePercentageOFF, etFurnitureReducedPrice, etFurnitureColor;
    private Button btn_add_furniture,btn_logout;
    private FirebaseAuth mAuth;
    private FirebaseUser user;
    private String uid = null;
    private static final int GALLERY_INTENT = 1;
    private ImageButton imageButton;
    private View view;
    private DatabaseReference databaseReference;
    private Uri imageUri;
    private String image;

    private StorageReference mStorageReference;

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

        mStorageReference = FirebaseStorage.getInstance().getReference();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Shop");
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
// [START auth_state_listener]
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());

                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
            }
        };
        // [END auth_state_listener]
        //
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent, GALLERY_INTENT);
            }
        });
        //
        btn_add_furniture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addAnItem();
                initializeToNull();
            }
        });
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signOut();
                startActivity(new Intent(getActivity().getBaseContext(),ShopRegisterOrLogin.class));
            }
        });
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
        btn_add_furniture = (Button) view.findViewById(R.id.furniture_item_register);
        btn_logout = (Button) view.findViewById(R.id.btnfurniture_logout);
        imageButton = (ImageButton) view.findViewById(R.id.imgbtn_furniture_item);
    }
    public void initializeToNull()
    {
        etFurnitureBrandName.setText("");
        etFurnitureID.setText("");
        etFurnitureSize.setText("");
        etFurnitureType.setText("");
        etFurnitureSaleDuration.setText("");
        etFurnitureSpecification.setText("");
        etFurnitureColor.setText("");
    }
    //[CREATING AN OBJECT OF A CLOTHE]
    public void addAnItem() {
        if (validateNullInput()) {
            StorageReference filePath = mStorageReference.child("my_image").child(imageUri.getLastPathSegment());
            filePath.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Uri downloadUri = taskSnapshot.getDownloadUrl();
                    image = downloadUri.toString();
                    databaseReference.addValueEventListener(eventListener);
                    Toast.makeText(getActivity().getApplicationContext(),"Item was successful added!..",Toast.LENGTH_LONG).show();
                }
            });
        }else {
            Toast.makeText(getActivity().getApplicationContext(),"Item can not be added!..",Toast.LENGTH_LONG).show();
        }
    }

    ValueEventListener eventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {

            for (DataSnapshot ds: dataSnapshot.getChildren()){
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ "+ ds.getKey());
                Shop shop = ds.getValue(Shop.class);
                if(shop.getEmail().equals(user.getEmail()))
                {
                    String furniture_ID = etFurnitureID.getText().toString();
                    String furniture_type = etFurnitureType.getText().toString();
                    String furnitureSale_Duration = etFurnitureSaleDuration.getText().toString();
                    String furniture_color = etFurnitureColor.getText().toString();
                    double furniture_Percentage_Off = Double.parseDouble(etFurniturePercentageOFF.getText().toString());
                    double furniture_Reduced_Price = Double.parseDouble(etFurnitureReducedPrice.getText().toString());
                    double furniture_Normal_Price = Double.parseDouble(etFurnitureNormalPrice.getText().toString());
                    String furniture_Shop_ID = uid;
                    String furniture_Size = etFurnitureSize.getText().toString();
                    String furniture_Brand_Name = etFurnitureBrandName.getText().toString();
                    String furniture_Specification = etFurnitureSpecification.getText().toString();

                    Furniture furniture = new Furniture(furniture_Brand_Name, image, furniture_color, furniture_ID, furniture_Normal_Price, furniture_Percentage_Off, furniture_Reduced_Price, furniture_Shop_ID, furniture_Size, furnitureSale_Duration, furniture_Specification, furniture_type);
                    databaseReference.child(ds.getKey()).child("Furniture").push().setValue(furniture);
                    databaseReference.removeEventListener(this);
                    return;
                }
            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    };

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
    // [START on_start_add_listener]
    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }
    // [END on_start_add_listener]

    // [START on_stop_remove_listener]
    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
    private void signOut() {
        mAuth.signOut();
    }

}
