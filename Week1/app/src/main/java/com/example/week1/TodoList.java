package com.example.week1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TodoList extends AppCompatActivity {

    private final static String TAG = "TodoList";

    public ListView simpleList;
    public String countryList[] = {"India", "China", "australia", "Portugle", "America", "NewZealand"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);

        Intent intent = getIntent();
        String key = intent.getStringExtra("key");
        Log.d(TAG, "onCreate: "+key);

        simpleList = findViewById(R.id.simpleListView);
        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countryList);
        simpleList.setAdapter(itemsAdapter);
    }
}
