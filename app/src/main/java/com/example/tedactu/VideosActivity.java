package com.example.tedactu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.tedactu.adapter.PostAdapter;
import com.example.tedactu.adapter.YoutubeAdapter;
import com.example.tedactu.models.CategoriesModel;
import com.example.tedactu.models.YoutubeModel;
import com.google.android.youtube.player.YouTubeBaseActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import okhttp3.Headers;

public class VideosActivity extends YouTubeBaseActivity {
    public static final String BASE_URL = "https://www.googleapis.com/youtube/v3/search?key=AIzaSyDXzlFOMcjv0AtfsDkcoPzf6QRO05Ooq4g&part=snippet&type=video&channelId=UCu8FZWXoBPxnPfkx6Yvh_WQ&maxResults=10";
    public static final String TAG = "VideoActivity";
    List<YoutubeModel> youtubeModels;
    YoutubeAdapter youtubeAdapter;
    YoutubeModel youtubeModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);

        RecyclerView rvVideos = findViewById(R.id.rvVideos);
        youtubeModels= new ArrayList<>();
        youtubeAdapter = new YoutubeAdapter(this,youtubeModels);
        rvVideos.setAdapter(youtubeAdapter);
        rvVideos.setLayoutManager(new LinearLayoutManager(this));

        AsyncHttpClient client = new AsyncHttpClient();

        client.get(BASE_URL, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                JSONObject jsonObject = json.jsonObject;


                try {
                    JSONArray items =jsonObject.getJSONArray("items");
                    for(int i= 0; i<items.length(); i++){
                        JSONObject element = items.getJSONObject(i);
                        // Récupérer les données de chaque vidéo

                        String title = element.getJSONObject("snippet").getString("title");

                        String id = element.getJSONObject("id").getString("videoId");

                        String description = element.getJSONObject("snippet").getString("description");
                        String thumbnailUrl = element.getJSONObject("snippet").getJSONObject("thumbnails").getJSONObject("default").getString("url");
                        youtubeModel = new YoutubeModel(title,thumbnailUrl, id);
                        youtubeModel.setId(id);
                        youtubeModels.add(youtubeModel);
                    }

                    youtubeAdapter.notifyDataSetChanged();
                    Log.i(TAG, " " +youtubeModels.size());
                }

                catch (JSONException e) {
                    Log.e(TAG, "Failed to parse JSON response: " + e.getMessage());
                }
            }


            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
                Log.d(TAG, "ERROR");
            }
        });
    }
}