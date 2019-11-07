package com.example.todotaskapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

public class SingleTaskAdapter extends RecyclerView.Adapter<SingleTaskAdapter.WordViewHolder>  {
    private final LinkedList<String> mWordList;
    private LayoutInflater mInflater;

    class WordViewHolder extends RecyclerView.ViewHolder {
        public final TextView wordItemView;
        final SingleTaskAdapter mAdapter;

        public WordViewHolder(View itemView, SingleTaskAdapter adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
            this.mAdapter = adapter;
        }
    }

    public SingleTaskAdapter(Context context, LinkedList<String> wordList) {
        mInflater = LayoutInflater.from(context);
        this.mWordList = wordList;
    }



    @Override
    public SingleTaskAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item,
                parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull SingleTaskAdapter.WordViewHolder holder, int position) {
        String mCurrent = mWordList.get(position);
        holder.wordItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }
}
