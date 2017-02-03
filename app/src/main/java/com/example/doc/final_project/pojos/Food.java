package com.example.doc.final_project.pojos;

/**
 * Created by Doc on 2017/02/02.
 */

public class Food {
    public static final String Var_Table = Food.class.getSimpleName();

    public static final String Var_Food_ID = "Food_ID";
    public static final String Var_Food_Type = "Food_Type";
    public static final String Var_Food_Amount_Off = "Food_Amount_Off";
    public static final String Var_Food_Reduced_Price = "Food_Reduced_Price";
    public static final String Var_Food_Normal_Price = "Food_Normal_Price";
    public static final String Var_Food_Shop_ID = "Food_Shop_ID";
    public static final String Var_Food_Weight = "Food_Weight";
    public static final String Var_Food_Brand_Name = "Food_Brand_Name";
    public static final String Var_Food_Special_Duration = "Food_Special_Duration";
    public static final String Var_Food_Specification = "Food_Specification";

    private long food_ID;
    private String food_Type;
    private int food_Amount_Off;
    private double food_Reduced_Price;
    private double food_Normal_Price;
    private long food_Shop_ID;
    private String food_Weight;
    private String food_Brand_Name;
    private String food_Specification;
    /*
    *** Duration must be entered in days....
     */
    private long food_Special_Duration;

    public Food(int food_Amount_Off, String food_Brand_Name, long food_ID, double food_Normal_Price, double food_Reduced_Price, long food_Shop_ID, long food_Special_Duration, String food_Specification, String food_Type, String food_Weight) {
        this.food_Amount_Off = food_Amount_Off;
        this.food_Brand_Name = food_Brand_Name;
        this.food_ID = food_ID;
        this.food_Normal_Price = food_Normal_Price;
        this.food_Reduced_Price = food_Reduced_Price;
        this.food_Shop_ID = food_Shop_ID;
        this.food_Special_Duration = food_Special_Duration;
        this.food_Specification = food_Specification;
        this.food_Type = food_Type;
        this.food_Weight = food_Weight;
    }

    public Food(long food_ID, String food_Brand_Name, long food_Shop_ID) {
        this.food_ID = food_ID;
        this.food_Brand_Name = food_Brand_Name;
        this.food_Shop_ID = food_Shop_ID;
    }

    public Food() {
    }

    public int getFood_Amount_Off() {
        return food_Amount_Off;
    }

    public void setFood_Amount_Off(int food_Amount_Off) {
        this.food_Amount_Off = food_Amount_Off;
    }

    public String getFood_Brand_Name() {
        return food_Brand_Name;
    }

    public void setFood_Brand_Name(String food_Brand_Name) {
        this.food_Brand_Name = food_Brand_Name;
    }

    public double getFood_Normal_Price() {
        return food_Normal_Price;
    }

    public void setFood_Normal_Price(double food_Normal_Price) {
        this.food_Normal_Price = food_Normal_Price;
    }

    public long getFood_ID() {
        return food_ID;
    }

    public void setFood_ID(long food_ID) {
        this.food_ID = food_ID;
    }

    public double getFood_Reduced_Price() {
        return food_Reduced_Price;
    }

    public void setFood_Reduced_Price(double food_Reduced_Price) {
        this.food_Reduced_Price = food_Reduced_Price;
    }

    public long getFood_Shop_ID() {
        return food_Shop_ID;
    }

    public void setFood_Shop_ID(long food_Shop_ID) {
        this.food_Shop_ID = food_Shop_ID;
    }

    public long getFood_Special_Duration() {
        return food_Special_Duration;
    }

    public void setFood_Special_Duration(long food_Special_Duration) {
        this.food_Special_Duration = food_Special_Duration;
    }

    public String getFood_Specification() {
        return food_Specification;
    }

    public void setFood_Specification(String food_Specification) {
        this.food_Specification = food_Specification;
    }

    public String getFood_Type() {
        return food_Type;
    }

    public void setFood_Type(String food_Type) {
        this.food_Type = food_Type;
    }

    public String getFood_Weight() {
        return food_Weight;
    }

    public void setFood_Weight(String food_Weight) {
        this.food_Weight = food_Weight;
    }

    @Override
    public String toString() {
        return "Food{" +
                "food_Amount_Off=" + food_Amount_Off +
                ", food_ID=" + food_ID +
                ", food_Type='" + food_Type + '\'' +
                ", food_Reduced_Price=" + food_Reduced_Price +
                ", food_Normal_Price=" + food_Normal_Price +
                ", food_Shop_ID=" + food_Shop_ID +
                ", food_Weight='" + food_Weight + '\'' +
                ", food_Brand_Name='" + food_Brand_Name + '\'' +
                ", food_Specification='" + food_Specification + '\'' +
                ", food_Special_Duration=" + food_Special_Duration +
                '}';
    }
}
