package com.example.doc.final_project.database_access_objects;

import android.app.Application;
import android.content.Context;

import com.example.doc.final_project.database_helper.DBHelper;

/**
 * Created by Doc on 2017/02/02.
 */

public class App extends Application {
    private static Context context;
    private static DBHelper dbHelper;

    @Override
    public void onCreate()
    {
        super.onCreate();
        context = this.getApplicationContext();
        dbHelper = new DBHelper();
        DatabaseManager.initializeInstance(dbHelper);

    }


    public static Context getContext(){
        return context;
    }
}
