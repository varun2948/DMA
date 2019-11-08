package com.example.todotaskapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);



        ArrayList<HackSmileModelClass> items = new ArrayList<>();
        CustomAdapter adapter = new CustomAdapter(this, items);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);
// let's create 10 random items
        for (int i = 0; i < 10; i++) {
            items.add(new HackSmileModelClass(R.drawable.ic_launcher_background, "Title " + i));
            adapter.notifyDataSetChanged();
        }
    }
    public void sendMessage(View view)
    {
        Intent intent = new Intent(this, TasksLists.class);
        startActivity(intent);
    }
}
