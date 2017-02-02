package com.example.doc.final_project.pojos;

/**
 * Created by Admin on 2017/02/02.
 */

public class Address {
    public final static String KEY_Table =Address.class.getSimpleName();

    public final static String KEY_AddressId = "AddressId";
    public final static String KEY_AddressUser = "AddressUser";
    public final static String KEY_AddressType = "AddressType";
    public final static String KEY_Line1 = "Line1";
    public final static String KEY_Line2 = "Line2";
    public final static String KEY_Town = "Town";
    public final static String KEY_Province = "Province";
    public final static String KEY_PostalCode = "PostalCode";

    private String addressUser;
    private long addressId;

    private String town;
    private String line1;
    private String line2;
    private String province;
    private int postalCode;
    private String addressType;

    //setters
    public void setAddressUser(String addressUser) {
        this.addressUser = addressUser;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    //getters
    public int getPostalCode() {
        return postalCode;
    }

    public String getAddressType() {
        return addressType;
    }

    public String getAddressUser() {
        return addressUser;
    }

    public String getLine1() {
        return line1;
    }

    public String getLine2() {
        return line2;
    }

    public String getTown() {
        return town;
    }

    public String getProvince() {
        return province;
    }

    public long getAddressId() {
        return addressId;
    }
}


