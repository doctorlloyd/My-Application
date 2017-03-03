package com.example.admin.myapplication.pojos;

import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Doc on 2017/02/02.
 */

public class Shop implements Serializable {
    public static final String Var_Table = Shop.class.getSimpleName();

    public static final String Var_Shop_ID = "Shop_ID";
    public static final String Var_Shop_Name = "Shop_Name";
    public static final String Var_Shop_Category = "Shop_Category";
    public static final String Var_Shop_location = "Shop_location";

    private String shop_ID;
    private String shop_Name;
    private String shop_Category;
    private String shop_location;
    private String email;
    private String contact;
    private String image;

    String password;

    public Shop(String shop_Category, String shop_ID, String shop_location, String shop_Name,String email, String contact, String password,String image) {
        this.shop_Category = shop_Category;
        this.shop_ID = shop_ID;
        this.shop_location = shop_location;
        this.shop_Name = shop_Name;
        this.email = email;
        this.contact = contact;
        this.password = password;
        this.image = image;
    }


    public Shop() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Shop(String shop_location, String shop_Name) {
        this.shop_ID = shop_ID;
        this.shop_location = shop_location;
        this.shop_Name = shop_Name;
    }

    public Shop(String shop_ID) {
        this.shop_ID = shop_ID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getShop_Category() {
        return shop_Category;
    }

    public void setShop_Category(String shop_Category) {
        this.shop_Category = shop_Category;
    }

    public String getShop_ID() {
        return shop_ID;
    }

    public void setShop_ID(String shop_ID) {
        this.shop_ID = shop_ID;
    }

    public String getShop_location() {
        return shop_location;
    }

    public void setShop_location(String shop_location) {
        this.shop_location = shop_location;
    }

    public String getShop_Name() {
        return shop_Name;
    }

    public void setShop_Name(String shop_Name) {
        this.shop_Name = shop_Name;
    }

}


