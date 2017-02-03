package com.example.doc.final_project.pojos;

/**
 * Created by Doc on 2017/02/02.
 */

public class Clothing {
    public static final String Var_Table = Clothing.class.getSimpleName();

    public static final String Var_Clothing_ID = "Clothing_ID";
    public static final String Var_ClothingType = "Clothing_Type";
    public static final String Var_Clothing_Percentage_Off = "Clothing_Percentage_Off";
    public static final String Var_ClothingI_Reduced_Price = "Clothing_Reduced_Price";
    public static final String Var_Clothing_Normal_Price = "Clothing_Normal_Price";
    public static final String Var_Clothing_Shop_ID = "Clothing_Shop_ID";
    public static final String Var_Clothing_Size = "Clothing_Size";
    public static final String Var_Clothing_Brand_Name = "Clothing_Brand_Name";
    public static final String Var_Clothing_Duration = "Clothing_Duration";

    private long clothing_ID;
    private String clothing_Type;
    private int clothing_Percentage_Off;
    private double clothing_Reduced_Price;
    private double clothing_Normal_Price;
    private long clothing_Shop_ID;
    private String clothing_Size;
    private String clothing_Brand_Name;
    /*
    *** Duration must be entered in days....
     */
    private long clothing_Duration;

    public Clothing(String clothing_Brand_Name, long clothing_Duration, long clothing_ID, double clothing_Normal_Price, int clothing_Percentage_Off, double clothing_Reduced_Price, long clothing_Shop_ID, String clothing_Size, String clothing_Type) {
        this.clothing_Brand_Name = clothing_Brand_Name;
        this.clothing_Duration = clothing_Duration;
        this.clothing_ID = clothing_ID;
        this.clothing_Normal_Price = clothing_Normal_Price;
        this.clothing_Percentage_Off = clothing_Percentage_Off;
        this.clothing_Reduced_Price = clothing_Reduced_Price;
        this.clothing_Shop_ID = clothing_Shop_ID;
        this.clothing_Size = clothing_Size;
        this.clothing_Type = clothing_Type;
    }

    public Clothing(String clothing_Brand_Name, long clothing_ID, long clothing_Shop_ID) {
        this.clothing_Brand_Name = clothing_Brand_Name;
        this.clothing_ID = clothing_ID;
        this.clothing_Shop_ID = clothing_Shop_ID;
    }

    public Clothing() {
    }

    public String getClothing_Brand_Name() {
        return clothing_Brand_Name;
    }

    public void setClothing_Brand_Name(String clothing_Brand_Name) {
        this.clothing_Brand_Name = clothing_Brand_Name;
    }

    public long getClothing_Duration() {
        return clothing_Duration;
    }

    public void setClothing_Duration(long clothing_Duration) {
        this.clothing_Duration = clothing_Duration;
    }

    public long getClothing_ID() {
        return clothing_ID;
    }

    public void setClothing_ID(long clothing_ID) {
        this.clothing_ID = clothing_ID;
    }

    public double getClothing_Normal_Price() {
        return clothing_Normal_Price;
    }

    public void setClothing_Normal_Price(double clothing_Normal_Price) {
        this.clothing_Normal_Price = clothing_Normal_Price;
    }

    public int getClothing_Percentage_Off() {
        return clothing_Percentage_Off;
    }

    public void setClothing_Percentage_Off(int clothing_Percentage_Off) {
        this.clothing_Percentage_Off = clothing_Percentage_Off;
    }

    public double getClothing_Reduced_Price() {
        return clothing_Reduced_Price;
    }

    public void setClothing_Reduced_Price(double clothing_Reduced_Price) {
        this.clothing_Reduced_Price = clothing_Reduced_Price;
    }

    public long getClothing_Shop_ID() {
        return clothing_Shop_ID;
    }

    public void setClothing_Shop_ID(long clothing_Shop_ID) {
        this.clothing_Shop_ID = clothing_Shop_ID;
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
                "clothing_Brand_Name='" + clothing_Brand_Name + '\'' +
                ", clothing_ID=" + clothing_ID +
                ", clothing_Type='" + clothing_Type + '\'' +
                ", clothing_Percentage_Off=" + clothing_Percentage_Off +
                ", clothing_Reduced_Price=" + clothing_Reduced_Price +
                ", clothing_Normal_Price=" + clothing_Normal_Price +
                ", clothing_Shop_ID=" + clothing_Shop_ID +
                ", clothing_Size='" + clothing_Size + '\'' +
                ", clothing_Duration=" + clothing_Duration +
                '}';
    }
}
