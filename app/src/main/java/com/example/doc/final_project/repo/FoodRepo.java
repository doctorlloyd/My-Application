package com.example.doc.final_project.repo;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.doc.final_project.database_access_objects.DatabaseManager;
import com.example.doc.final_project.pojos.Food;
import com.example.doc.final_project.pojos.Shop;

/**
 * Created by Doc on 2017/02/03.
 */

public class FoodRepo {
    private Food address;

    public FoodRepo(){
        address = new Food();
    }
    public static String CreateFoodTable(){
        return "CREATE TABLE " + Food.Var_Table  + "("
                + Food.Var_Food_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Food.Var_Food_Amount_Off +" REAL,"+ Food.Var_Food_Brand_Name +" TEXT,"
                + Food.Var_Food_Normal_Price +" REAL,"+ Food.Var_Food_Reduced_Price +" REAL,"
                + Food.Var_Food_Shop_ID +" INTEGER NOT NULL,"+ Food.Var_Food_Special_Duration +" INTEGER NOT NULL,"
                + Food.Var_Food_Type +" TEXT, "+ Food.Var_Food_Weight +" TEXT," + Food.Var_Food_Specification
                + " TEXT, FOREIGN KEY (" + Food.Var_Food_Shop_ID+") "+"REFERENCES "+
                Shop.Var_Table +"( "+Shop.Var_Shop_ID + " ));";

    }

    public static long insert(Food food) {

        ContentValues cv = new ContentValues();
        SQLiteDatabase db   = DatabaseManager.getInstance().openDatabase();

        cv.put(Food.Var_Food_Amount_Off, food.getFood_Amount_Off());
        cv.put(Food.Var_Food_Brand_Name, food.getFood_Brand_Name());
        cv.put(Food.Var_Food_ID, food.getFood_ID());
        cv.put(Food.Var_Food_Normal_Price, food.getFood_Normal_Price());
        cv.put(Food.Var_Food_Reduced_Price, food.getFood_Reduced_Price());
        cv.put(Food.Var_Food_Shop_ID, food.getFood_ID());
        cv.put(Food.Var_Food_Special_Duration, food.getFood_Special_Duration());
        cv.put(Food.Var_Food_Specification, food.getFood_Specification());
        cv.put(Food.Var_Food_Type, food.getFood_Type());
        cv.put(Food.Var_Food_Weight, food.getFood_Weight());

        long id =db.insert(Food.Var_Table, null, cv);
        DatabaseManager.getInstance().closeDatabase();

        return id;
    }
}
