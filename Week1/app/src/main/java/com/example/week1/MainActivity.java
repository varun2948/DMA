package com.example.week1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button detailButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Display display = getWindowManager().getDefaultDisplay();
        textView= findViewById(R.id.orientationView);
//        int width = display.getWidth();
//        int height = display.getHeight();
//        if(width<height){
//            Toast.makeText(getApplicationContext(),"Device is in portrait mode",Toast.LENGTH_LONG ).show();
//            textView.setText("Device is in Potrait Mode");
//        }
//        else{
//            Toast.makeText(getApplicationContext(),"Device is in landscape  mode",Toast.LENGTH_LONG ).show();
//            textView.setText("Device is in Landscape Mode");
//        }
//        detailButton = findViewById(R.id.todo_btn);
//        detailButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent((MainActivity.this),TodoList.class);
////                intent.putExtra(TODO_INDEX,currentIndex);
//                startActivity(intent);
//            }
//        });
        detailButton = findViewById(R.id.todo_btn);
        detailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent((MainActivity.this),TodoList.class);
                intent.putExtra("key","value samir");
                startActivity(intent);
            }
        });

    }
    public void nextClick(View view){
        Toast.makeText(this, "You Clicked Next Button", Toast.LENGTH_SHORT).show();
    }
    public void prevClick(View view){
        Toast.makeText(this, "You Clicked Previous Button", Toast.LENGTH_SHORT).show();
    }
}
