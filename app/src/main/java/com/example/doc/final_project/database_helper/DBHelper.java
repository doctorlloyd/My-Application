package com.example.doc.final_project.database_helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.doc.final_project.database_access_objects.App;

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

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion){
        Log.d(TAG, String.format("Service Library.onUpgrade(%d -> %d)", oldVersion, newVersion));
    }
}
