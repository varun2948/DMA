package com.example.fragmenthw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public void fragmentReplace(int position) {
        SingleTodoTask singleTodoTask = new SingleTodoTask();
        Bundle bundle = new Bundle();
        bundle.putInt("id", position);
        singleTodoTask.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, singleTodoTask).addToBackStack("v").commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            SingleTodoFragment singleTodoFragment = new SingleTodoFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, singleTodoFragment)
                    .commit();
        }

    }
}
