package com.example.up_to_timenews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.viewholder> {
   ArrayList<NewsModel> list;
    Context context;
    //static Recyclerviewinterface recyclerviewinterface;


    public NewsAdapter(Context context, ArrayList<NewsModel> list) {
        this.list = list;
        this.context = context;
      //  this.recyclerviewinterface=recyclerviewinterface;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.newslist,parent,false);
       
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.viewholder holder, int position) {
        NewsModel info= list.get(position);
        holder.text.setText(info.title);
        holder.author.setText(info.author);
      //  Glide.with(holder.itemView.getContext()).load(info.urlImage).into(holder.image);




    }

    @Override
    public int getItemCount() {
        return list.size();
    }

   public  void update(ArrayList<NewsModel> newsModels){

        list.clear();
        list.addAll(newsModels);
        notifyDataSetChanged();
    }

    public static class viewholder extends RecyclerView.ViewHolder{
        TextView text,author;
        //ImageView image;


        public viewholder(@NonNull View itemView) {
            super(itemView);
            text=itemView.findViewById(R.id.name);
            author=itemView.findViewById(R.id.author);
           // image=itemView.findViewById(R.id.urlimg);




        }

    }


}

