package com.example.todofragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_content);

        if(fragment == null){
            TodoFragment todoFragment = new TodoFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_content, todoFragment)
                    .commit();
        }
    }
}
