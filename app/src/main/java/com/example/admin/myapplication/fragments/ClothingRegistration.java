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
import com.example.admin.myapplication.pojos.Clothing;
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

public class ClothingRegistration extends Fragment {

    public static String TAG = ClothingRegistration.class.getSimpleName();
    private EditText etClothingID, etClothingSaleDuration, etClothingType, etClotheBrandName, etClotheSpecification, etClotheSize, etClotheNormalPrice, etClothePercentageOFF, etClotheReducedPrice;
    private Button btn_add_clothe;
    private FirebaseAuth user;
    private FirebaseUser fbuser;
    private Clothing clothing;
    private static final int GALLERY_INTENT = 1;
    private ImageButton imageButton;
    private View view;
    private DatabaseReference databaseReference;
    private Uri imageUri;
    private String image;
    private StorageReference mStorageReference;

    public ClothingRegistration() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.clothing_registration, container, false);

        view = rootView;

        initialize();

        mStorageReference = FirebaseStorage.getInstance().getReference();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Shop");
        user = FirebaseAuth.getInstance();
        fbuser = user.getCurrentUser();

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
        btn_add_clothe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addAnItem();
            }
        });
        return rootView;
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
                }
            });
        }else {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~:    Failed wrong input");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }
    ValueEventListener eventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {

            for (DataSnapshot ds: dataSnapshot.getChildren()){
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ "+ ds.getKey());
                Shop shop = ds.getValue(Shop.class);
                if(shop.getEmail().equals(fbuser.getEmail()))
                {
                    String clothing_ID = etClothingID.getText().toString();
                    String clothing_type = etClothingType.getText().toString();
                    String clothingSale_Duration = etClothingSaleDuration.getText().toString();
                    int clothing_Percentage_Off = Integer.parseInt(etClothePercentageOFF.getText().toString());
                    double clothing_Reduced_Price = Double.parseDouble(etClotheReducedPrice.getText().toString());
                    double clothing_Normal_Price = Double.parseDouble(etClotheNormalPrice.getText().toString());
                    String clothing_Shop_ID = databaseReference.getKey();
                    String clothing_Size = etClotheSize.getText().toString();
                    String clothing_Brand_Name = etClotheBrandName.getText().toString();
                    String clothing_Specification = etClotheSpecification.getText().toString();

                    clothing = new Clothing(image, clothing_Brand_Name, clothingSale_Duration, clothing_ID, clothing_Normal_Price, clothing_Percentage_Off, clothing_Reduced_Price, clothing_Shop_ID, clothing_Size, clothing_Specification, clothing_type);
                    databaseReference.child(ds.getKey()).child("Clothing").push().setValue(clothing);
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
        if (TextUtils.isEmpty(etClothePercentageOFF.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(etClotheBrandName.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(etClothingID.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(etClotheNormalPrice.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(etClotheReducedPrice.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(etClotheSize.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(etClothingType.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(etClotheSpecification.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(etClothingSaleDuration.getText().toString()))
            return false;
        return true;
    }
    public void initialize() {
        etClothePercentageOFF = (EditText) view.findViewById(R.id.etClothePercentageOFF);
        etClotheBrandName = (EditText) view.findViewById(R.id.etClotheBrandName);
        etClothingID = (EditText) view.findViewById(R.id.etClotheID);
        etClotheNormalPrice = (EditText) view.findViewById(R.id.etClotheNormalPrice);
        etClotheReducedPrice = (EditText) view.findViewById(R.id.etClotheReducedPrice);
        etClotheSize = (EditText) view.findViewById(R.id.etClotheSize);
        etClothingType = (EditText) view.findViewById(R.id.etClotheType);
        etClotheSpecification = (EditText) view.findViewById(R.id.etClotheSpecification);
        etClothingSaleDuration = (EditText) view.findViewById(R.id.etClotheSaleDuration);
        btn_add_clothe = (Button) view.findViewById(R.id.btnclothe_item_register);
        imageButton = (ImageButton) view.findViewById(R.id.imgbtn_clothing_item);
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
