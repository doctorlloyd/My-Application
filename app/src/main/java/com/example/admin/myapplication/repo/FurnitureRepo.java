package com.example.admin.myapplication.repo;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.admin.myapplication.database_access_objects.DatabaseManager;
import com.example.admin.myapplication.pojos.Food;
import com.example.admin.myapplication.pojos.Furniture;
import com.example.admin.myapplication.pojos.Shop;

/**
 * Created by Doc on 2017/02/03.
 */

public class FurnitureRepo {
    Furniture furniture;


    public FurnitureRepo(){
        furniture = new Furniture();
    }
    public static String  createFurnitureTable(){
        return "Create "+Furniture.class + "("
                + Furniture.Var_Furniture_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Furniture.Var_Furniture_Percentage_Off +" REAL,"+ Furniture.Var_Furniture_Brand_Name +" TEXT,"
                + Furniture.Var_Furniture_Normal_Price +" REAL,"+ Furniture.Var_Furniture_Reduced_Price +" REAL,"
                + Furniture.Var_Furniture_Shop_ID +" INTEGER NOT NULL,"+ Furniture.Var_Furniture_Special_Duration +" INTEGER NOT NULL,"
                + Furniture.Var_Furniture_Type +" TEXT, "+ Furniture.Var_Furniture_Size +" TEXT,"
                + Furniture.Var_Furniture_Specification + Furniture.Var_Furniture_Color +" TEXT, "
                + " TEXT, FOREIGN KEY (" + Furniture.Var_Furniture_Shop_ID+") "+"REFERENCES "+
                Shop.Var_Table +"( "+Shop.Var_Shop_ID + " ));";
    }
    public static long insert(Furniture furniture) {

        ContentValues cv = new ContentValues();
        SQLiteDatabase db   = DatabaseManager.getInstance().openDatabase();

        cv.put(Furniture.Var_Furniture_Percentage_Off, furniture.getFurniture_Percentage_Off());
        cv.put(Furniture.Var_Furniture_Brand_Name, furniture.getFurniture_Brand_Name());
        cv.put(Furniture.Var_Furniture_ID, furniture.getFurniture_ID());
        cv.put(Furniture.Var_Furniture_Normal_Price, furniture.getFurniture_Normal_Price());
        cv.put(Furniture.Var_Furniture_Reduced_Price, furniture.getFurniture_Reduced_Price());
        cv.put(Furniture. Var_Furniture_Shop_ID, furniture.getFurniture_Shop_ID());
        cv.put(Furniture.Var_Furniture_Special_Duration, furniture.getFurniture_Special_Duration());
        cv.put(Furniture.Var_Furniture_Specification, furniture.getFurniture_Specification());
        cv.put(Furniture.Var_Furniture_Type, furniture.getFurniture_Type());
        cv.put(Furniture.Var_Furniture_Size, furniture.getFurniture_Size());
        cv.put(Furniture.Var_Furniture_Color, furniture.getFurniture_Color());

        long id =db.insert(Food.Var_Table, null, cv);
        DatabaseManager.getInstance().closeDatabase();
        return id;
    }
}
