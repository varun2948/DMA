package com.example.todoapp;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private String[] tasks = {"Play Football", "Study", "Dinner", "Sleep"};
    private TextView textView;
    private int totalLength;
    int currentIndex;
    private String[] Todos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if (savedInstanceState != null){
            currentIndex = savedInstanceState.getInt("TodoIndex", 0);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources res = getResources();
        Todos = res.getStringArray(R.array.todos);

        textView = findViewById(R.id.textOutput);
        textView.setText(Todos[currentIndex]);
        Log.d("MainActivity", "onCreate()");
        totalLength = tasks.length;

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("TodoIndex",currentIndex);
        Log.d("MainActivity", "onSave()");
    }

    public void prevClick(View view) {
        int newIndex = currentIndex - 1;
        if (newIndex == -1) {
            newIndex = Todos.length - 1;
            currentIndex = newIndex;
        } else {
            currentIndex = newIndex;
        }
        setValueOnView(Todos[newIndex]);
    }

    public void nextClick(View view) {
        int newIndex = currentIndex + 1;
        if (newIndex == Todos.length) {
            newIndex = 0;
            currentIndex = 0;
        } else {
            currentIndex = newIndex;
        }
        setValueOnView(Todos[newIndex]);
    }

    private void setValueOnView(String text) {
        textView.setText(text);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "OnStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity", "onResume()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity", "onPause()");
    }

}