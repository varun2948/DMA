package com.example.week1.countrydetails;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;

import com.example.week1.R;
import com.example.week1.model.CountryDetailsModel;

import static com.example.week1.todo_list.TodoList.KEY;

public class CountryDetails extends AppCompatActivity {
    TextView tvCountryName, tvCountryDesc ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_details);

        tvCountryName = findViewById(R.id.country_header);
        tvCountryDesc = findViewById(R.id.country_detail);

        getNewIntent(getIntent());

    }

    private void getNewIntent(Intent intent) {
        if(intent != null){

            CountryDetailsModel countryDetailsModel = intent.getParcelableExtra(KEY);

            tvCountryName.setText(countryDetailsModel.getName());
            tvCountryDesc.setText(countryDetailsModel.getDesc());
        }
    }
}
