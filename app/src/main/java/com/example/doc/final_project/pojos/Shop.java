package com.example.doc.final_project.pojos;

/**
 * Created by Doc on 2017/02/02.
 */

public class Shop {
    public static final String Var_Table = Shop.class.getSimpleName();

    public static final String Var_Shop_ID = "Shop_ID";
    public static final String Var_Shop_Name = "Shop_Name";
    public static final String Var_Shop_Category = "Shop_Category";
    public static final String Var_Shop_location = "Shop_location";

    private long shop_ID;
    private String shop_Name;
    private String shop_Category;
    private String shop_location;

    public Shop(String shop_Category, long shop_ID, String shop_location, String shop_Name) {
        this.shop_Category = shop_Category;
        this.shop_ID = shop_ID;
        this.shop_location = shop_location;
        this.shop_Name = shop_Name;
    }

    public Shop(long shop_ID, String shop_location, String shop_Name) {
        this.shop_ID = shop_ID;
        this.shop_location = shop_location;
        this.shop_Name = shop_Name;
    }

    public String getShop_Category() {
        return shop_Category;
    }

    public void setShop_Category(String shop_Category) {
        this.shop_Category = shop_Category;
    }

    public long getShop_ID() {
        return shop_ID;
    }

    public void setShop_ID(long shop_ID) {
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

    @Override
    public String toString() {
        return "Shop{" +
                "shop_Category='" + shop_Category + '\'' +
                ", shop_ID=" + shop_ID +
                ", shop_Name='" + shop_Name + '\'' +
                ", shop_location='" + shop_location + '\'' +
                '}';
    }
}


