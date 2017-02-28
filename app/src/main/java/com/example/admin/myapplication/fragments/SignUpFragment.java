package com.example.admin.myapplication.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.doc.final_project.R;
import com.example.admin.myapplication.pojos.Client;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Doc on 21-Jan-17.
 */

public class SignUpFragment extends Fragment{
    private EditText etName,etEmail,etAddress,etPassword,etContact,etConfirmPassword;
    private Button btnCancel, btnSignUp;
    private View view;
    private DatabaseReference databaseReference;
    private FirebaseAuth mAuth;
    FirebaseUser firebaseUser;
    String userId;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.signup_fragment,container,false);
        databaseReference = FirebaseDatabase.getInstance().getReference("users");

        view = rootView;
       firebaseUser = mAuth.getCurrentUser( );
        initializeViews();
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUserToDatabase();
            }
        });
        userId = firebaseUser.getUid();
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return rootView;
    }
    private void initializeViews(){

        etAddress = (EditText) view.findViewById(R.id.etSignUpAddress);
        etContact = (EditText) view.findViewById(R.id.etSignUpContact);
        etEmail = (EditText) view.findViewById(R.id.etSignUpEmail);
        etName = (EditText) view.findViewById(R.id.etSignUpUserName);
        etPassword = (EditText) view.findViewById(R.id.etSignUpPassword);
        etConfirmPassword = (EditText) view.findViewById(R.id.etSignUpConfirmPassword);

        btnCancel = (Button) view.findViewById(R.id.btnCancel);
        btnSignUp = (Button) view.findViewById(R.id.btnSignUp);
    }
    private void addUserToDatabase(){
        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        String address = etAddress.getText().toString();
        String password = etPassword.getText().toString();
        String contact = etContact.getText().toString();
        String confirmPassword = etConfirmPassword.getText().toString();
        if(!TextUtils.isEmpty(name)&&!TextUtils.isEmpty(email)&&!TextUtils.isEmpty(address)
                &&!TextUtils.isEmpty(password)&&!TextUtils.isEmpty(contact)&&!TextUtils.isEmpty(confirmPassword)){
            if(password.equals(confirmPassword))
            {
                Client client = new Client(address,contact,email,password,name);
                String key = databaseReference.push().getKey();
                System.out.println("================= "+userId+" =============="+ client.getUserName());
                databaseReference.child(key).setValue(client);
                Toast.makeText(getContext(),"User added ....",Toast.LENGTH_LONG).show();
//                initializeViews();
            }else {
                Toast.makeText(getContext(),"password doesn't match!!",Toast.LENGTH_LONG).show();
            }

        }else {
            Toast.makeText(getContext(),"Insure that all fields are \n" +
                    "filled with information",Toast.LENGTH_LONG).show();
        }
    }
}
