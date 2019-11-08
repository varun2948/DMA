package com.example.todotaskapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.ArrayList;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
    private Context context;
    private ArrayList<HackSmileModelClass> items;
    public CustomAdapter(Context context, ArrayList<HackSmileModelClass> items) {
        this.context = context;
        this.items = items;
    }
    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.items, parent, false));
    }
    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.itemTitle.setText(items.get(position).getTitle());
        holder.itemTitle.setText(items.get(position).getTitle());
//        holder.itemImage.setImageResource(items.get(position).getImage());
    }
    @Override
    public int getItemCount() {
        return items.size();
    }
    public class CustomViewHolder extends RecyclerView.ViewHolder {
//        private ImageView itemImage;
        private TextView itemTitle;
        private TextView itemTitle1;
        public CustomViewHolder(View view) {
            super(view);
//            itemImage = view.findViewById(R.id.item_image);
            itemTitle = view.findViewById(R.id.item_title);
            itemTitle1 = view.findViewById(R.id.item_title1);
        }
    }
}
