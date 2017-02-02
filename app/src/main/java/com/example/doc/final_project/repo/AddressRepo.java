package com.example.doc.final_project.repo;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.doc.final_project.database_access_objects.DatabaseManager;
import com.example.doc.final_project.pojos.Address;

/**
 * Created by Doc on 2017/02/02.
 */

public class AddressRepo {
    private Address address;

    public AddressRepo(){
        address = new Address();
    }

    public static String CreateAddressTable(){
        return "CREATE TABLE " + Address.KEY_Table  + "("
                + Address.KEY_AddressId  + "   PRIMARY KEY    ,"
                + Address.KEY_Line1 +" TEXT, "+ Address.KEY_Line2 +" TEXT, "
                + Address.KEY_Town +" TEXT, "+ Address.KEY_Province +" TEXT, "
                + Address.KEY_PostalCode +" TEXT, "+ Address.KEY_AddressType +" TEXT));";
//                +Address.KEY_AddressUser+ " TEXT, FOREIGN KEY (" + ContactDetails.KEY_ContactUser+") "+"REFERENCES "+
//                ServiceProvider.KEY_TABLE +"( "+ServiceProvider.KEY_ServiceProviderID + " ));";

    }

    public static long insert(Address address) {

        ContentValues cv = new ContentValues();
        SQLiteDatabase db   = DatabaseManager.getInstance().openDatabase();

        cv.put(Address.KEY_Line1, address.getLine1());
        cv.put(Address.KEY_Line2, address.getLine2());
        cv.put(Address.KEY_Town, address.getTown());
        cv.put(Address.KEY_Province, address.getProvince());
        cv.put(Address.KEY_PostalCode, address.getPostalCode());
        cv.put(Address.KEY_AddressType, address.getAddressType());
        cv.put(Address.KEY_AddressUser, address.getAddressUser());

        long id =db.insert(Address.KEY_Table, null, cv);
        DatabaseManager.getInstance().closeDatabase();

        return id;
    }
}