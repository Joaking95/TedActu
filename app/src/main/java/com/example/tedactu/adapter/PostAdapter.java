package com.example.tedactu.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tedactu.R;
import com.example.tedactu.models.CategoriesModel;

import java.util.List;

public class PostAdapter extends  RecyclerView.Adapter<PostAdapter.ViewHolder>{

  Context context;
  List<CategoriesModel> categoriesModels;

    public PostAdapter(Context context, List<CategoriesModel> categoriesModels) {
        this.context = context;
        this.categoriesModels = categoriesModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View postview = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new ViewHolder(postview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      CategoriesModel categoriesModel =categoriesModels.get(position);
      holder.bind(categoriesModel);
    }

    @Override
    public int getItemCount() {
        return categoriesModels.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView slugText;

        public ViewHolder(@NonNull View item){
            super(item);
            slugText = item.findViewById(R.id.slug);




        }

        public void bind(CategoriesModel categoriesModel) {
            slugText.setText(categoriesModel.getSlug());
            Log.i("adapter", ""+slugText);
        }
    }



}
