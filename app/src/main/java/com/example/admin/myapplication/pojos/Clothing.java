package com.example.admin.myapplication.pojos;

import java.io.Serializable;

/**
 * Created by Doc on 2017/02/02.
 */

public class Clothing implements Serializable{
    public static final String TAG = Clothing.class.getSimpleName();

    private String clothing_ID;
    private String clothing_Type;
    private double clothing_Percentage_Off;
    private double clothing_Reduced_Price;
    private double clothing_Normal_Price;
    private String clothing_Shop_ID;
    private String clothing_Size;
    private String clothing_Brand_Name;
    private String clothing_Specification;
    /*
    *** Duration must be entered in days....
     */
    private String clothing_Duration;
    private String image;


    public Clothing(String image,String clothing_Brand_Name, String clothing_Duration, String clothing_ID, double clothing_Normal_Price, double clothing_Percentage_Off, double clothing_Reduced_Price, String clothing_Shop_ID, String clothing_Size, String clothing_Specification , String clothing_Type) {
        this.clothing_Brand_Name = clothing_Brand_Name;
        this.clothing_Duration = clothing_Duration;
        this.clothing_ID = clothing_ID;
        this.clothing_Normal_Price = clothing_Normal_Price;
        this.clothing_Percentage_Off = clothing_Percentage_Off;
        this.clothing_Reduced_Price = clothing_Reduced_Price;
        this.clothing_Shop_ID = clothing_Shop_ID;
        this.clothing_Size = clothing_Size;
        this.clothing_Type = clothing_Type;
        this.clothing_Specification = clothing_Specification;
        this.image = image;

    }

    public Clothing(String clothing_Brand_Name, String clothing_ID, String clothing_Shop_ID) {
        this.clothing_Brand_Name = clothing_Brand_Name;
        this.clothing_ID = clothing_ID;
        this.clothing_Shop_ID = clothing_Shop_ID;
    }

    public Clothing(String clothing_Brand_Name,String clothing_Type) {
        this.clothing_Brand_Name = clothing_Brand_Name;
        this.clothing_Type = clothing_Type;
    }

    public Clothing() {
    }

    public String getClothing_Brand_Name() {
        return clothing_Brand_Name;
    }

    public void setClothing_Brand_Name(String clothing_Brand_Name) {
        this.clothing_Brand_Name = clothing_Brand_Name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getClothing_Duration() {
        return clothing_Duration;
    }

    public void setClothing_Duration(String clothing_Duration) {
        this.clothing_Duration = clothing_Duration;
    }

    public String getClothing_ID() {
        return clothing_ID;
    }

    public void setClothing_ID(String clothing_ID) {
        this.clothing_ID = clothing_ID;
    }

    public double getClothing_Normal_Price() {
        return clothing_Normal_Price;
    }

    public void setClothing_Normal_Price(double clothing_Normal_Price) {
        this.clothing_Normal_Price = clothing_Normal_Price;
    }

    public double getClothing_Percentage_Off() {
        return clothing_Percentage_Off;
    }

    public void setClothing_Percentage_Off(double clothing_Percentage_Off) {
        this.clothing_Percentage_Off = clothing_Percentage_Off;
    }

    public double getClothing_Reduced_Price() {
        return clothing_Reduced_Price;
    }

    public void setClothing_Reduced_Price(double clothing_Reduced_Price) {
        this.clothing_Reduced_Price = clothing_Reduced_Price;
    }

    public String getClothing_Shop_ID() {
        return clothing_Shop_ID;
    }

    public void setClothing_Shop_ID(String clothing_Shop_ID) {
        this.clothing_Shop_ID = clothing_Shop_ID;
    }
    public String getClothing_Specification() {
        return clothing_Specification;
    }

    public void setClothing_Specification(String clothing_Specification) {
        this.clothing_Specification = clothing_Specification;
    }
    public String getClothing_Size() {
        return clothing_Size;
    }

    public void setClothing_Size(String clothing_Size) {
        this.clothing_Size = clothing_Size;
    }

    public String getClothing_Type() {
        return clothing_Type;
    }

    public void setClothing_Type(String clothing_Type) {
        this.clothing_Type = clothing_Type;
    }

    @Override
    public String toString() {
        return "Clothing{" +
                "clothing_ID=" + clothing_ID +
                ", clothing_Type='" + clothing_Type + '\'' +
                ", clothing_Percentage_Off=" + clothing_Percentage_Off +
                ", clothing_Reduced_Price=" + clothing_Reduced_Price +
                ", clothing_Normal_Price=" + clothing_Normal_Price +
                ", clothing_Shop_ID=" + clothing_Shop_ID +
                ", clothing_Size='" + clothing_Size + '\'' +
                ", clothing_Brand_Name='" + clothing_Brand_Name + '\'' +
                ", clothing_Specification='" + clothing_Specification + '\'' +
                ", clothing_Duration=" + clothing_Duration +
                '}';
    }
}
