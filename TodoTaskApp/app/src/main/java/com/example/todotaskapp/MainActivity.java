package com.example.todotaskapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private final LinkedList<String> mWordList = new LinkedList<>();

    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < 20; i++) {
            mWordList.addLast("Word " + i);
        }


        mRecyclerView = findViewById(R.id.recyclerview);
// Create an adapter and supply the data to be displayed.
        mAdapter = new WordListAdapter(this, mWordList);
// Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
// Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }
    public void sendMessage(View view)
    {
        Intent intent = new Intent(this, TasksLists.class);
        startActivity(intent);
    }

}
