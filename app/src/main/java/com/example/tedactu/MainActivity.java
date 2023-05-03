package com.example.tedactu;

import androidx.appcompat.app.AppCompatActivity;
import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.RequestParams;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.codepath.asynchttpclient.callback.TextHttpResponseHandler;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import okhttp3.Headers;

public class MainActivity extends AppCompatActivity {
    Button bt1;
    public static final String BASE_URL = "https://tedactu.com/wp-json/wp/v2/categories?page=1&per_page=10&search=e";
    public  static final String TAG = "MAinActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1 = findViewById(R.id.bt1);


       //Send a request ton the endpoint wp
        AsyncHttpClient client = new AsyncHttpClient();

        client.get(BASE_URL, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
               Log.d(TAG,"SUCCESS" ) ;

            }

            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
                Log.e(TAG,"Faillure" ) ;
            }
        });





    }
}