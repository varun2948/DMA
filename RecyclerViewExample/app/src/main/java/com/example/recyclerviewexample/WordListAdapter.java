package com.example.recyclerviewexample;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private List<String> data;
    Context context;
    public WordListAdapter(List<String> data, Context context){
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.wordlist_item,parent ,false);
        return new WordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, final int position) {
        String item = data.get(position);
        holder.textView.setText(item);
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "CLICKING ", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }




    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textView;
        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }

        @Override
        public void onClick(View v) {
//            int mPosition = getLayoutPosition();
            Log.d("check","CLICKED");
            Toast.makeText(textView.getContext(), "Clicked", Toast.LENGTH_LONG).show();
        }
    }
}




