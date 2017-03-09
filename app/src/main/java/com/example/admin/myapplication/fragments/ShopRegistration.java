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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.admin.myapplication.activities.Item_Registration;
import com.example.admin.myapplication.pojos.Shop;
import com.example.doc.final_project.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import static android.app.Activity.RESULT_OK;
import static android.content.ContentValues.TAG;

/**
 * Created by Doc on 2017/02/21.
 */

public class ShopRegistration extends Fragment{

    public static String TAG = ClothingRegistration.class.getSimpleName();
    private String[] array = {"Food", "Clothing", "Furniture"};
    private Spinner spinner;
    private EditText etName, etAddress, etContact, etConfirmPassword;
    private EditText etEmail, etPassword;
    private Button btnCancel, btnSignUp;
    private FirebaseUser user;
    private String uid;
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
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.shop_registration, container, false);

        mStorageReference = FirebaseStorage.getInstance().getReference();

        view = rootView;

        initializeViews();

        //databaseReference = FirebaseDatabase.getInstance().getReference("users");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, array);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // [START initialize_auth]
        mAuth = FirebaseAuth.getInstance();
        // [END initialize_auth]

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
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAccount(etEmail.getText().toString(), etPassword.getText().toString());
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signOut();
            }
        });
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent, GALLERY_INTENT);
            }
        });
        return rootView;
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

    // [END on_stop_remove_listener]
    private void createAccount(final String email, final String password) {
        Log.d(TAG, "createAccount:" + email);
        if (!validateForm()) {
            return;
        }
        //showProgressDialog();

        // [START create_user_with_email]
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                        if (task.isSuccessful()) {
                            uid = user.getUid();
                            databaseReference = FirebaseDatabase.getInstance().getReference("Shop");


                            StorageReference filePath = mStorageReference.child("my_image").child(imageUri.getLastPathSegment());
                            filePath.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                @Override
                                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                    String _category = spinner.getSelectedItem().toString();
                                    String _location = etAddress.getText().toString();
                                    String shopName = etName.getText().toString();
                                    String _contact = etContact.getText().toString();
                                    if (!TextUtils.isEmpty(etAddress.getText().toString()) && !TextUtils.isEmpty(etName.getText().toString()) && !TextUtils.isEmpty(etContact.getText().toString())) {
                                        Uri downloadUri = taskSnapshot.getDownloadUrl();


                                        String _key = databaseReference.push().getKey();
                                        Shop shop = new Shop(_category, _key, _location, shopName, email, _contact, password, downloadUri.toString());
                                        databaseReference.child(_key).setValue(shop);

                                        Intent intent = new Intent(getActivity(), Item_Registration.class);
                                        intent.putExtra("fragment_category", _category);
                                        intent.putExtra("shop_name", shop);
                                        startActivity(intent);
                                        getActivity().finish();
                                    } else {

                                    }
                                }
                            });

                        }

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful())

                        {
                            Toast.makeText(getActivity(), R.string.auth_failed,
                                    Toast.LENGTH_SHORT).show();
                        }
                        // [START_EXCLUDE]
//                        hideProgressDialog();
                        // [END_EXCLUDE]
                    }
                });
        // [END create_user_with_email]
    }

    private void signOut() {
        mAuth.signOut();
    }

    private boolean validateForm() {
        boolean valid = true;

        String email = etEmail.getText().toString();
        if (TextUtils.isEmpty(email)) {
            etEmail.setError("Required.");
            valid = false;
        } else {
            etEmail.setError(null);
        }

        String password = etPassword.getText().toString();
        if (TextUtils.isEmpty(password) || TextUtils.isEmpty(etConfirmPassword.getText().toString())) {
            etPassword.setError("Required.");
            valid = false;
        } else {
            etPassword.setError(null);
        }
        return valid;
    }

    private void initializeViews() {

        etAddress = (EditText) view.findViewById(R.id.etShopAddress);
        etContact = (EditText) view.findViewById(R.id.etShopContact);
        etEmail = (EditText) view.findViewById(R.id.etShopEmail);
        etName = (EditText) view.findViewById(R.id.etShopName);
        etPassword = (EditText) view.findViewById(R.id.etShopPassword);
        etConfirmPassword = (EditText) view.findViewById(R.id.etShopConfirmPassword);
        spinner = (Spinner) view.findViewById(R.id.spShopCategory);
        btnSignUp = (Button) view.findViewById(R.id.shopSignUp);
        btnCancel = (Button) view.findViewById(R.id.shopSendVerification);
        imageButton = (ImageButton) view.findViewById(R.id.imgb_Shop);
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
