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

    public  YoutubeModel(String title, String thumbnailUrl,String id){
        this.title = title;
       // this.description = description;
        this.thumbnailUrl = thumbnailUrl;

        this.id = id;

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
    /*
    public YoutubeModel(JSONObject jsonObject) throws JSONException {


         title = jsonObject.getString("title");


    }

    public List<YoutubeModel> fromJsonArray(JSONArray jsonArray) throws JSONException {
        List<YoutubeModel> youtubeModels = new ArrayList<>();
        for (int i =0; i<jsonArray.length(); i++){

            if(jsonArray.getJSONObject(i).has("snippet")){
                JSONObject jsonObject =jsonArray.getJSONObject(i).getJSONObject("snippet");

                youtubeModels.add(new YoutubeModel(jsonObject));
            }
            else{
                youtubeModels.add(new YoutubeModel(jsonArray.getJSONObject(i)));
            }

        }
        return  youtubeModels;
    }

    public String getVideoid() {
        return videoid;
    }

    public String getTitle() {
        return title;
    }


    public String getId() {
        return id;
    }

    public String getSnippet() {
        return snippet;
    }

 */
}
