package com.example.tedactu.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tedactu.PlayYoutubeActivity;
import com.example.tedactu.R;
import com.example.tedactu.models.YoutubeModel;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

import org.parceler.Parcels;

import java.util.List;

public class YoutubeAdapter extends  RecyclerView.Adapter<YoutubeAdapter.viewholder>{


    Context context;
    List<YoutubeModel> youtubeModels;

    public YoutubeAdapter(Context context, List<YoutubeModel> youtubeModels) {
        this.context = context;
        this.youtubeModels = youtubeModels;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View youtubeview = LayoutInflater.from(context).inflate(R.layout.youtube_item, parent,false);
        return new viewholder(youtubeview);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
       YoutubeModel youtubeModel = youtubeModels.get(position);
       holder.bind(youtubeModel);
    }

    @Override
    public int getItemCount() {
        return youtubeModels.size();
    }

    public class  viewholder extends RecyclerView.ViewHolder{

        TextView videoTitle;
        ImageView youtube;
        LinearLayout layout;
        public viewholder(@NonNull View item) {
            super(item);
            videoTitle = item.findViewById(R.id.txtTitle);
            youtube = item.findViewById(R.id.ImageViewHolder);
        }

        public void bind(YoutubeModel youtubeModel) {

            videoTitle.setText(youtubeModel.getTitle());
            Glide.with(context).load(youtubeModel.getThumbnailUrl()).into(youtube);

            youtube.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent(context, PlayYoutubeActivity.class);
                    //i.putExtra("videoId", youtubeModel.getId());
                    i.putExtra("youtubemodel", Parcels.wrap(youtubeModel));
                    context.startActivity(i);
                }
            });

        }
    }
}
