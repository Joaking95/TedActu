package com.example.tedactu.models;

import com.example.tedactu.adapter.YoutubeAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Parcel
public class YoutubeModel {
    private String title;
    private String description;
    private String thumbnailUrl;
    private String id;

    public  YoutubeModel(){

    }



    public YoutubeModel(JSONObject jsonObject) throws JSONException {

         title = jsonObject.getJSONObject("snippet").getString("title");
         id = jsonObject.getJSONObject("id").getString("videoId");
         thumbnailUrl = jsonObject.getJSONObject("snippet").getJSONObject("thumbnails").getJSONObject("default").getString("url");

    }

    public List<YoutubeModel> fromJsonArray(JSONArray jsonArray) throws JSONException {
        List<YoutubeModel> youtubeModels = new ArrayList<>();
        for (int i =0; i<jsonArray.length(); i++){

                youtubeModels.add(new YoutubeModel(jsonArray.getJSONObject(i)));
        }
        return  youtubeModels;
    }


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public String getId() {
        return id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(String id) {
        this.id = id;
    }


}
