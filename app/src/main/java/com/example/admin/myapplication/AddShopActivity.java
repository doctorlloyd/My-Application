package com.example.admin.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.admin.myapplication.pojos.Shop;
import com.example.doc.final_project.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class AddShopActivity extends AppCompatActivity {


    private static final int GALLERY_INTENT = 1;
    private DatabaseReference mDatabaseReference;
    private EditText etName;
    private EditText etLocation;
    private ImageButton imageButton;
    private Button btnAdd;

    Uri imageUri;

    private StorageReference mStorageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_shop);

        mStorageReference = FirebaseStorage.getInstance().getReference();
        mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("Shop");


        etLocation = (EditText) findViewById(R.id.et_Location);
        etName = (EditText) findViewById(R.id.etName);
        imageButton =(ImageButton)findViewById(R.id.imgb_Shop);
        btnAdd = (Button) findViewById(R.id.btn_add);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                submitShop();

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

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GALLERY_INTENT && resultCode == RESULT_OK){

            imageUri = data.getData();
            imageButton.setImageURI(imageUri);

        }

    }

    public void submitShop(){

        final String name = etName.getText().toString().trim();
        final String location = etLocation.getText().toString().trim();


        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(location)){

            StorageReference filePath = mStorageReference.child("my_image").child(imageUri.getLastPathSegment());
            filePath.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                    Uri downloadUri = taskSnapshot.getDownloadUrl();

                    DatabaseReference newShop = mDatabaseReference.push();

//                    String key = mDatabaseReference.push().getKey();
                    
                    newShop.child("name").setValue(name);
                    newShop.child("location").setValue(location);
                    newShop.child("img").setValue(downloadUri.toString());

                }
            });

        }

    }

}
