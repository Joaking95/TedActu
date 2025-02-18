package com.example.tedactu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;


import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.tedactu.adapter.CategoryAdapter;
import com.example.tedactu.models.CategoriesModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;


public class CategoryActivity extends AppCompatActivity {

    public static final String BASE_URL = "https://tedactu.com/wp-json/wp/v2/categories";
    public static final String TAG = "PostActivity";
    List<CategoriesModel> categoriesModels;
    CategoriesModel categoriesModel = new CategoriesModel();

    CategoryAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        RecyclerView rvPosts = findViewById(R.id.rvPost);
        categoriesModels = new ArrayList<>();
        postAdapter = new CategoryAdapter(this, categoriesModels);
        rvPosts.setAdapter(postAdapter);
        rvPosts.setLayoutManager(new LinearLayoutManager(this));

        // Créer une instance d'AsyncHttpClient
        AsyncHttpClient client = new AsyncHttpClient();

        client.get(BASE_URL, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {

                try {
                    // Créer un nouvel objet JSON vide
                    JSONObject jsonObject = new JSONObject();

                    JSONArray response = json.jsonArray;
                    Log.i(TAG, " oui" +response);

                    for(int i=0; i<response.length(); i++){

                        JSONObject element = response.getJSONObject(i);

                         categoriesModels.add(new CategoriesModel(element));

                        Log.d(TAG, " oui" +categoriesModel.getSlug());
                    }
                    Log.d(TAG, " oui" +categoriesModels.size());


                  postAdapter.notifyDataSetChanged();


                }catch (Exception e){

                }

            }

            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
                Log.i(TAG, " echec " +response);
            }


        });

    }

}