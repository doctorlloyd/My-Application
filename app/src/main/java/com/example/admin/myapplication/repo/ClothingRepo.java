package com.example.admin.myapplication.repo;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.admin.myapplication.database_access_objects.DatabaseManager;
import com.example.admin.myapplication.pojos.Clothing;
import com.example.admin.myapplication.pojos.Food;
import com.example.admin.myapplication.pojos.Shop;

/**
 * Created by Doc on 2017/02/02.
 */

public class ClothingRepo {
    Clothing clothing;


    public ClothingRepo(){
        clothing = new Clothing();
    }
    public static String  createClothingTable(){
        return "Create "+Clothing.class + "("
                + Clothing.Var_Clothing_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Clothing.Var_Clothing_Percentage_Off +" REAL,"+ Clothing.Var_Clothing_Brand_Name +" TEXT,"
                + Clothing.Var_Clothing_Normal_Price +" REAL,"+ Clothing.Var_ClothingI_Reduced_Price +" REAL,"
                + Clothing.Var_Clothing_Shop_ID +" INTEGER NOT NULL,"+ Clothing.Var_Clothing_Duration +" INTEGER NOT NULL,"
                + Clothing.Var_ClothingType +" TEXT, "+ Clothing.Var_Clothing_Size +" TEXT," + Clothing.getVar_Clothing_Specification
                + " TEXT, FOREIGN KEY (" + Clothing.Var_Clothing_Shop_ID+") "+"REFERENCES "+
                Shop.Var_Table +"( "+Shop.Var_Shop_ID + " ));";
    }
    public static long insert(Clothing clothing) {

        ContentValues cv = new ContentValues();
        SQLiteDatabase db   = DatabaseManager.getInstance().openDatabase();

        cv.put(Clothing.Var_Clothing_Percentage_Off, clothing.getClothing_Percentage_Off());
        cv.put(Clothing.Var_Clothing_Brand_Name, clothing.getClothing_Brand_Name());
        cv.put(Clothing.Var_Clothing_ID, clothing.getClothing_ID());
        cv.put(Clothing.Var_Clothing_Normal_Price, clothing.getClothing_Normal_Price());
        cv.put(Clothing.Var_ClothingI_Reduced_Price, clothing.getClothing_Reduced_Price());
        cv.put(Clothing.Var_Clothing_Shop_ID, clothing.getClothing_Shop_ID());
        cv.put(Clothing.Var_Clothing_Duration, clothing.getClothing_Duration());
        cv.put(Clothing.getVar_Clothing_Specification, clothing.getClothing_Specification());
        cv.put(Clothing.Var_ClothingType, clothing.getClothing_Type());
        cv.put(Clothing.Var_Clothing_Size, clothing.getClothing_Size());

        long id =db.insert(Food.Var_Table, null, cv);
        DatabaseManager.getInstance().closeDatabase();
        return id;
    }
}
