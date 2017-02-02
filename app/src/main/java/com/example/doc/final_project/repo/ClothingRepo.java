package com.example.doc.final_project.repo;

import com.example.doc.final_project.pojos.Clothing;

/**
 * Created by Doc on 2017/02/02.
 */

public class ClothingRepo {
    Clothing clothing;

    public ClothingRepo(){
        clothing = new Clothing();
    }
    public String  createClothingTable(){
        return "Create "+Clothing.class+"( ";
    }

}
