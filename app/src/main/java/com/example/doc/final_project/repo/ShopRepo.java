package com.example.doc.final_project.repo;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.doc.final_project.database_access_objects.DatabaseManager;
import com.example.doc.final_project.pojos.Food;
import com.example.doc.final_project.pojos.Shop;

/**
 * Created by Doc on 05-Feb-17.
 */

public class ShopRepo {
    Shop shop;


    public ShopRepo(){
        shop = new Shop();
    }
    public static String  createShopTable(){
        return "Create "+Shop.class + "("
                + Shop.Var_Shop_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Shop.Var_Shop_Category +" TEXT,"+ Shop.Var_Shop_Name +" TEXT,"
                + Shop.Var_Shop_location + " TEXT);";
    }
    public static long insert(Shop shop) {

        ContentValues cv = new ContentValues();
        SQLiteDatabase db   = DatabaseManager.getInstance().openDatabase();

        cv.put(Shop.Var_Shop_ID, shop.getShop_ID());
        cv.put(Shop.Var_Shop_Name, shop.getShop_Name());
        cv.put(Shop.Var_Shop_location, shop.getShop_location());
        cv.put(Shop.Var_Shop_Category, shop.getShop_Category());

        long id =db.insert(Food.Var_Table, null, cv);
        DatabaseManager.getInstance().closeDatabase();
        return id;
    }
}
