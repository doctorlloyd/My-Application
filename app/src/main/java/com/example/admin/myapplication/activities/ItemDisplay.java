package com.example.admin.myapplication.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.admin.myapplication.pojos.Clothing;
import com.example.admin.myapplication.pojos.Food;
import com.example.admin.myapplication.pojos.Furniture;
import com.example.admin.myapplication.pojos.Shop;
import com.example.doc.final_project.R;
import com.squareup.picasso.Picasso;

public class ItemDisplay extends AppCompatActivity {

    private ImageView imgShopLogo, imgItemIcon;
    private TextView tvItemPrice, tvItemDiscount, tvShopName, tvItemName, tvSpecification, tvSpecialDuration;
    private Shop shop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailed_item_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        initialization();

        try {
            shop = (Shop) getIntent().getSerializableExtra("shop");
            toolbar.setTitle(shop.getShop_Name());
            setSupportActionBar(toolbar);
            String _category = shop.getShop_Category();
            if (_category.equalsIgnoreCase("Food")) {
                Food food = (Food) getIntent().getSerializableExtra("item");

                tvItemPrice.setText("Now R "+food.getFood_Reduced_Price()+"\n Was R "+food.getFood_Normal_Price());
                tvItemDiscount.setText("R "+food.getFood_Amount_Off()+" OFF");
                tvItemName.setText(food.getFood_Brand_Name());
                tvShopName.setText(shop.getShop_Name());
                tvSpecification.setText(food.getFood_Specification());
                tvSpecialDuration.setText("Special duration "+food.getFood_Special_Duration());
                Picasso.with(this).load(food.getImage()).into(imgItemIcon);
//                Picasso.with(this).load(shop.getImage()).into(imgShopLogo);

            } else if (_category.equalsIgnoreCase("Clothing")) {
                Clothing clothing = (Clothing) getIntent().getSerializableExtra("item");

                tvItemPrice.setText("Now R "+clothing.getClothing_Reduced_Price()+"\n Was R "+clothing.getClothing_Normal_Price());
                tvItemDiscount.setText(String.valueOf(clothing.getClothing_Percentage_Off())+"% OFF");
                tvItemName.setText(clothing.getClothing_Brand_Name());
                tvShopName.setText(shop.getShop_Name());
                tvSpecification.setText(clothing.getClothing_Specification());
                tvSpecialDuration.setText("Sale duration "+clothing.getClothing_Duration());
                Picasso.with(this).load(clothing.getImage()).into(imgItemIcon);
//                Picasso.with(this).load(shop.getImage()).into(imgShopLogo);
            } else {
                Furniture furniture = (Furniture) getIntent().getSerializableExtra("item");
                tvItemPrice.setText("Now R "+furniture.getFurniture_Reduced_Price()+"\n Was R "+furniture.getFurniture_Normal_Price());
                tvItemDiscount.setText(String.valueOf(furniture.getFurniture_Percentage_Off())+"% OFF");
                tvItemName.setText(furniture.getFurniture_Brand_Name());
                tvShopName.setText(shop.getShop_Name());
                tvSpecification.setText(furniture.getFurniture_Specification());
                tvSpecialDuration.setText("Sale duration "+furniture.getFurniture_Special_Duration());
                Picasso.with(this).load(furniture.getImage()).into(imgItemIcon);
//                Picasso.with(this).load(shop.getImage()).into(imgShopLogo);
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),"Could not Load the Item...",Toast.LENGTH_LONG).show();
        }

    }

    private void initialization() {
        tvItemPrice = (TextView) findViewById(R.id.itemPrice);
        tvItemDiscount = (TextView) findViewById(R.id.itemPriceOff);
        tvShopName = (TextView) findViewById(R.id.displayShopName);
        tvItemName = (TextView) findViewById(R.id.displayItemName);
        tvSpecification = (TextView) findViewById(R.id.displayItemSpecification);
        tvSpecialDuration = (TextView) findViewById(R.id.displaySpecialDuration);

        imgItemIcon = (ImageView) findViewById(R.id.displayItemIcon);
    }
}
