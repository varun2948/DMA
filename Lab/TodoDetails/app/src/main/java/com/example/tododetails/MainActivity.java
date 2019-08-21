package com.example.tododetails;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static com.example.tododetails.TodoDetailActivity.IS_TODO_COMPLETE;

public class MainActivity extends AppCompatActivity {

    private static final int IS_SUCCESS = -1;
    private String[] tasks = {"Play Football", "Study", "Dinner", "Sleep"};
    private TextView textView;
    private int totalLength;
    private Button detailButton;
    public static String TODO_INDEX = "com.example.tododetail";
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
        detailButton = findViewById(R.id.viewBtn);
        detailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent((MainActivity.this),TodoDetailActivity.class);
                intent.putExtra(TODO_INDEX,currentIndex);
                startActivity(intent);
            }
        });
        textView.setText(Todos[currentIndex]);
        Log.d("MainActivity", "onCreate()");
        totalLength = tasks.length;


        getNewIntent(getIntent());

    }

    private void getNewIntent(Intent intent) {
        if(intent != null){
            boolean isChecked = intent.getBooleanExtra(IS_TODO_COMPLETE, false);
            updateTodoComplete(isChecked);
        }
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

    protected void onActivityResult (int requestCode, int resultCode, Intent intent){
        if(resultCode == IS_SUCCESS){
            if(intent != null) {
                boolean isTodoComplete = intent.getBooleanExtra(IS_TODO_COMPLETE, false);
                updateTodoComplete(isTodoComplete);
            }
            else{
                Toast.makeText( this, "Back Button Pressed", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(this, "Code Mismatch",Toast.LENGTH_SHORT).show();
        }
    }


    private void updateTodoComplete(boolean is_todo_complete) {

        final TextView textViewTodo;
        textViewTodo = findViewById(R.id.textOutput);
        if(is_todo_complete){
            textViewTodo.setBackgroundColor(ContextCompat.getColor(this,R.color.colorAccent));
            textViewTodo.setTextColor(ContextCompat.getColor(this,android.R.color.white));

        }
    }

}
