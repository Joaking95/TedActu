package com.example.tedactu.models;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;
@Parcel
public class CategoriesModel {

    int id;
    int counter;
    String description;
    String link;
    String name;


    String slug;
    String taxonomy;
    int parent;
   // Object meta;


    //Constructor vide
     public CategoriesModel(){

     }


     //Constructor with JSONObject
    public CategoriesModel(JSONObject jsonObject) throws JSONException {
      slug = jsonObject.getString("slug");

    }


    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

}
