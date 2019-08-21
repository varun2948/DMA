package com.example.tododetails;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.tododetails.MainActivity.TODO_INDEX;

public class TodoDetailActivity extends AppCompatActivity {

    private TextView textoutput;
    private String[] Todos;
    public static String IS_TODO_COMPLETE = "com.example.is_todo_complete";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_detail);
        Intent intent= getIntent();
        Resources res = getResources();
        Todos = res.getStringArray(R.array.todosdescription);
        int todo_index= intent.getIntExtra(TODO_INDEX,0);

        textoutput=findViewById(R.id.textOutput);
        textoutput.setText(Todos[todo_index]);

        CheckBox checkboxIsComplete = findViewById(R.id.checkBoxIsComplete);
        checkboxIsComplete.setOnClickListener(mTodoListener);

    }
    private View.OnClickListener mTodoListener = new View.OnClickListener() {
        public void onClick(View v){
            switch (v.getId()){
                case R.id.checkBoxIsComplete:
                    CheckBox checkBoxIsComplete =(CheckBox)findViewById(R.id.checkBoxIsComplete);
                    setIsComplete(checkBoxIsComplete.isChecked());
                    finish();
                    break;
                    default:
                        break;
            }
        }
    };

    private void setIsComplete(boolean isChecked) {

        // celebrate with a static Toast!
        if(isChecked){
            Toast.makeText(TodoDetailActivity.this,
                    "Hurray, it's done!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(TodoDetailActivity.this,
                    "There is always tomorrow!", Toast.LENGTH_LONG).show();
        }

        Intent intent = new Intent(TodoDetailActivity.this, MainActivity.class);
        intent.putExtra(IS_TODO_COMPLETE, isChecked);
        startActivity(intent);
//        setResult(RESULT_OK, intent);
    }

//    private void setIsComplete(boolean isChecked  ) {
//        if(isChecked){
//            Toast.makeText(this, ""+Todos[todo_index], Toast.LENGTH_SHORT).show();
//        }
//        else{
//            Toast.makeText(this, "There is Always Tomorrow!", Toast.LENGTH_SHORT).show();
//        }
//        Intent intent = new Intent();
//        intent.putExtra(IS_TODO_COMPLETE, isChecked);
//        setResult(RESULT_OK, intent);
//    }
}
