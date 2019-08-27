package com.example.week1.todo_list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.week1.R;
import com.example.week1.countrydetails.CountryDetails;
import com.example.week1.main_activity.MainActivity;
import com.example.week1.model.CountryDetailsModel;

public class TodoList extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private final static String TAG = "TodoList";
    public final static String KEY = "key";
    private Button country_click;
    public ListView simpleList;
    public String countryList[] = {"Nepal", "China", "Australia", "Portugal", "America", "NewZealand","Hongkong","Spain", "Brazil", "Germany", "Netherlands", "India", "England","France"};

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

        country_click= findViewById(R.id.country_btn);
        simpleList.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, ""+position, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(TodoList.this, CountryDetails.class);
        intent.putExtra(KEY,CountryDetailsModel.getCountryDemoList().get(position));
        startActivity(intent);



    }
}
