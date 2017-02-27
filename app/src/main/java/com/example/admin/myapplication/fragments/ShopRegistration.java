package com.example.admin.myapplication.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.admin.myapplication.pojos.Client;
import com.example.doc.final_project.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Doc on 2017/02/21.
 */

public class ShopRegistration extends Fragment implements AdapterView.OnItemSelectedListener {
    private String[] array = {"FOOD","CLOTHING","FURNITURE"};
    private Spinner spinner;
    private EditText etName,etEmail,etAddress,etPassword,etContact,etConfirmPassword;
    private Button btnCancel, btnSignUp;
    private View view;
    private DatabaseReference databaseReference;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.shop_registration,container,false);
        view = rootView;
        initializeViews();
        databaseReference = FirebaseDatabase.getInstance().getReference("users");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_dropdown_item,array);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        return rootView;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.tabs,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_register:
                //TODO: add action for what to do when registration passed
                addUserToDatabase();
            break;
            default:
                break;
        }
        return false;
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
                System.out.println("================= "+key+" =============="+ client.getUserName());
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
    private void initializeViews(){

        etAddress = (EditText) view.findViewById(R.id.etShopAddress);
        etContact = (EditText) view.findViewById(R.id.etShopContact);
        etEmail = (EditText) view.findViewById(R.id.etShopEmail);
        etName = (EditText) view.findViewById(R.id.etShopName);
        etPassword = (EditText) view.findViewById(R.id.etShopPassword);
        etConfirmPassword = (EditText) view.findViewById(R.id.etShopConfirmPassword);
        spinner = (Spinner) view.findViewById(R.id.spShopCategory);
    }
}
