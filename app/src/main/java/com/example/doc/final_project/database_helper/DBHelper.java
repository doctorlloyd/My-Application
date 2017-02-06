package com.example.doc.final_project.database_helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.doc.final_project.database_access_objects.App;
import com.example.doc.final_project.pojos.Clothing;
import com.example.doc.final_project.pojos.Food;
import com.example.doc.final_project.pojos.Furniture;
import com.example.doc.final_project.pojos.Shop;
import com.example.doc.final_project.repo.ClothingRepo;
import com.example.doc.final_project.repo.FoodRepo;
import com.example.doc.final_project.repo.FurnitureRepo;
import com.example.doc.final_project.repo.ShopRepo;

/**
 * Created by Doc on 2017/02/02.
 */
public class DBHelper extends SQLiteOpenHelper{
    private Context context;
    final static private  String DATABASE_NAME = "";
    private  static final int DATABASE_VERSION = 1;
    private static final String TAG = DBHelper.class.getSimpleName();

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public DBHelper(){
        super(App.getContext(), DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(ShopRepo.createShopTable());
        sqLiteDatabase.execSQL(FoodRepo.CreateFoodTable());
        sqLiteDatabase.execSQL(FurnitureRepo.createFurnitureTable());
        sqLiteDatabase.execSQL(ClothingRepo.createClothingTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion){
        Log.d(TAG, String.format("Service Library.onUpgrade(%d -> %d)", oldVersion, newVersion));
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Clothing.Var_Table);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Furniture.Var_Table);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Food.Var_Table);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Shop.Var_Table);
        onCreate(sqLiteDatabase);
    }
}
