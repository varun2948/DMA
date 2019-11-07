package com.example.todotaskapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.LinkedList;

public class TasksLists extends AppCompatActivity {

    private final LinkedList<String> mWordList = new LinkedList<>();

    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks_lists);

        for (int i = 0; i < 20; i++) {
            mWordList.addLast("Word " + i);
        }
//        mRecyclerView = findViewById(R.id.single_task_recyclerview);
//// Create an adapter and supply the data to be displayed.
//        mAdapter = new WordListAdapter(this, mWordList);
//// Connect the adapter with the RecyclerView.
//        mRecyclerView.setAdapter(mAdapter);
//// Give the RecyclerView a default layout manager.
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
