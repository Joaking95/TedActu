package com.example.tedactu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.tedactu.models.YoutubeModel;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import org.parceler.Parcels;

public class PlayYoutubeActivity extends YouTubeBaseActivity {

    YouTubePlayerView youTubePlayerView;
    public static final String BASE_URL = "https://www.googleapis.com/youtube/v3/search?key=AIzaSyDXzlFOMcjv0AtfsDkcoPzf6QRO05Ooq4g&part=snippet&type=video&channelId=UCu8FZWXoBPxnPfkx6Yvh_WQ&maxResults=10";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_youtube);
        youTubePlayerView= findViewById(R.id.player);
        YoutubeModel youtubeModel= Parcels.unwrap(getIntent().getParcelableExtra("youtubemodel"));
        String id = youtubeModel.getId();
        Log.e("loll", ""+id);

        youTubePlayerView.initialize(BASE_URL, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(id);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });
    }
}