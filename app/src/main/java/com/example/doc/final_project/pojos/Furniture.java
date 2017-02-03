package com.example.doc.final_project.pojos;

/**
 * Created by Doc on 2017/02/02.
 */

public class Furniture {

    public static final String Var_Table = Furniture.class.getSimpleName();

    public static final String Var_Furniture_ID = "Furniture_ID";
    public static final String Var_Furniture_Type = "Furniture_Type";
    public static final String Var_Furniture_Percentage_Off = "Furniture_Percentage_Off";
    public static final String Var_Furniture_Reduced_Price = "Furniture_Reduced_Price";
    public static final String Var_Furniture_Normal_Price = "Furniture_Normal_Price";
    public static final String Var_Furniture_Shop_ID = "Furniture_Shop_ID";
    public static final String Var_Furniture_Size = "Furniture_Size";
    public static final String Var_Furniture_Color = "Furniture_Color";
    public static final String Var_Furniture_Brand_Name = "Furniture_Brand_Name";
    public static final String Var_Furniture_Special_Duration = "Furniture_Special_Duration";
    public static final String Var_Furniture_Specification = "Furniture_Specification";

    private long furniture_ID;
    private String furniture_Type;
    private int furniture_Percentage_Off;
    private double furniture_Reduced_Price;
    private double furniture_Normal_Price;
    private long furniture_Shop_ID;
    private String furniture_Size;
    private String furniture_Color;
    private String furniture_Brand_Name;
    private String furniture_Specification;
    /*
    *** Duration must be entered in days....
     */
    private long furniture_Special_Duration;

    public Furniture(String furniture_Brand_Name, String furniture_Color, long furniture_ID, double furniture_Normal_Price, int furniture_Percentage_Off, double furniture_Reduced_Price, long furniture_Shop_ID, String furniture_Size, long furniture_Special_Duration, String furniture_Specification, String furniture_Type) {
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
    }

    public Furniture(String furniture_Brand_Name, long furniture_ID, long furniture_Shop_ID) {
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

    public long getFurniture_ID() {
        return furniture_ID;
    }

    public void setFurniture_ID(long furniture_ID) {
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

    public long getFurniture_Shop_ID() {
        return furniture_Shop_ID;
    }

    public void setFurniture_Shop_ID(long furniture_Shop_ID) {
        this.furniture_Shop_ID = furniture_Shop_ID;
    }

    public String getFurniture_Size() {
        return furniture_Size;
    }

    public void setFurniture_Size(String furniture_Size) {
        this.furniture_Size = furniture_Size;
    }

    public long getFurniture_Special_Duration() {
        return furniture_Special_Duration;
    }

    public void setFurniture_Special_Duration(long furniture_Special_Duration) {
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
