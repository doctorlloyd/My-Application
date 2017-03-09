package com.example.admin.myapplication.pojos;

import java.io.Serializable;

/**
 * Created by Doc on 2017/02/02.
 */

public class Furniture implements Serializable{

    public static final String Var_Table = Furniture.class.getSimpleName();

    private String furniture_ID;
    private String furniture_Type;
    private int furniture_Percentage_Off;
    private double furniture_Reduced_Price;
    private double furniture_Normal_Price;
    private String furniture_Shop_ID;
    private String furniture_Size;
    private String furniture_Color;
    private String furniture_Brand_Name;
    private String furniture_Specification;
    /*
    *** Duration must be entered in days....
     */
    private String furniture_Special_Duration;
    private String image;

    public Furniture(String furniture_Brand_Name,String image, String furniture_Color, String furniture_ID, double furniture_Normal_Price, int furniture_Percentage_Off, double furniture_Reduced_Price, String furniture_Shop_ID, String furniture_Size, String furniture_Special_Duration, String furniture_Specification, String furniture_Type) {
        this.furniture_Brand_Name = furniture_Brand_Name;
        this.furniture_Color = furniture_Color;
        this.furniture_ID = furniture_ID;
        this.furniture_Normal_Price = furniture_Normal_Price;
        this.furniture_Percentage_Off = furniture_Percentage_Off;
        this.furniture_Reduced_Price = furniture_Reduced_Price;
        this.furniture_Shop_ID = furniture_Shop_ID;
        this.furniture_Size = furniture_Size;
        this.furniture_Special_Duration = furniture_Special_Duration;
        this.furniture_Specification = furniture_Specification;
        this.furniture_Type = furniture_Type;
        this.image = image;
    }

    public Furniture(String furniture_Brand_Name, String furniture_ID, String furniture_Shop_ID) {
        this.furniture_Brand_Name = furniture_Brand_Name;
        this.furniture_ID = furniture_ID;
        this.furniture_Shop_ID = furniture_Shop_ID;
    }

    public String getFurniture_Brand_Name() {
        return furniture_Brand_Name;
    }

    public Furniture() {
    }

    public void setFurniture_Brand_Name(String furniture_Brand_Name) {
        this.furniture_Brand_Name = furniture_Brand_Name;
    }

    public String getFurniture_Color() {
        return furniture_Color;
    }

    public void setFurniture_Color(String furniture_Color) {
        this.furniture_Color = furniture_Color;
    }

    public String getFurniture_ID() {
        return furniture_ID;
    }

    public void setFurniture_ID(String furniture_ID) {
        this.furniture_ID = furniture_ID;
    }

    public double getFurniture_Normal_Price() {
        return furniture_Normal_Price;
    }

    public void setFurniture_Normal_Price(double furniture_Normal_Price) {
        this.furniture_Normal_Price = furniture_Normal_Price;
    }

    public int getFurniture_Percentage_Off() {
        return furniture_Percentage_Off;
    }

    public void setFurniture_Percentage_Off(int furniture_Percentage_Off) {
        this.furniture_Percentage_Off = furniture_Percentage_Off;
    }

    public double getFurniture_Reduced_Price() {
        return furniture_Reduced_Price;
    }

    public void setFurniture_Reduced_Price(double furniture_Reduced_Price) {
        this.furniture_Reduced_Price = furniture_Reduced_Price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFurniture_Shop_ID() {
        return furniture_Shop_ID;
    }

    public void setFurniture_Shop_ID(String furniture_Shop_ID) {
        this.furniture_Shop_ID = furniture_Shop_ID;
    }

    public String getFurniture_Size() {
        return furniture_Size;
    }

    public void setFurniture_Size(String furniture_Size) {
        this.furniture_Size = furniture_Size;
    }

    public String getFurniture_Special_Duration() {
        return furniture_Special_Duration;
    }

    public void setFurniture_Special_Duration(String furniture_Special_Duration) {
        this.furniture_Special_Duration = furniture_Special_Duration;
    }

    public String getFurniture_Specification() {
        return furniture_Specification;
    }

    public void setFurniture_Specification(String furniture_Specification) {
        this.furniture_Specification = furniture_Specification;
    }

    public String getFurniture_Type() {
        return furniture_Type;
    }

    public void setFurniture_Type(String furniture_Type) {
        this.furniture_Type = furniture_Type;
    }

    @Override
    public String toString() {
        return "Furniture{" +
                "furniture_Brand_Name='" + furniture_Brand_Name + '\'' +
                ", furniture_ID=" + furniture_ID +
                ", furniture_Type='" + furniture_Type + '\'' +
                ", furniture_Percentage_Off=" + furniture_Percentage_Off +
                ", furniture_Reduced_Price=" + furniture_Reduced_Price +
                ", furniture_Normal_Price=" + furniture_Normal_Price +
                ", furniture_Shop_ID=" + furniture_Shop_ID +
                ", furniture_Size='" + furniture_Size + '\'' +
                ", furniture_Color='" + furniture_Color + '\'' +
                ", furniture_Specification='" + furniture_Specification + '\'' +
                ", furniture_Special_Duration=" + furniture_Special_Duration +
                '}';
    }
}
