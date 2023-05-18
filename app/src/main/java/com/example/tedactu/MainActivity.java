package com.example.tedactu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.tedactu.models.CategoriesModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Iterator;

import okhttp3.Headers;


public class MainActivity extends AppCompatActivity {
    Button bt1;
    CategoriesModel categoriesModel = new CategoriesModel();
   Button tv1;
    public static final String BASE_URL = "https://tedactu.com/wp-json/wp/v2/posts?categories=240";
    public static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1 = findViewById(R.id.bt1);
        tv1 = findViewById(R.id.tv1);



        Log.d(TAG, "Slug " +categoriesModel.getSlug());

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CategoryActivity.class));
            }
        });

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,VideosActivity.class));
            }
        });

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
                        //Log.i(TAG, " element" +element.getString("slug"));
                        categoriesModel.setSlug(element.getString("slug"));

                        // Récupérer les clés et les valeurs de l'élément
                        Iterator<String> keys = element.keys();
                        while (keys.hasNext()) {
                            String key = keys.next();
                            String value = element.getString(key);

                            // Ajouter la paire clé-valeur à l'objet JSON final
                            jsonObject.put(key, value);


                        }
                        tv1.setText(categoriesModel.getSlug());
                        Log.d(TAG, " oui" +categoriesModel.getSlug());
                    }

                    //Log.d(TAG, " oui" +categoriesModel.getSlug());


                    // postAdapter.notifyDataSetChanged();


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