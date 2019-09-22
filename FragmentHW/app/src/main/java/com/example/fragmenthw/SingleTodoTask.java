package com.example.fragmenthw;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class SingleTodoTask extends Fragment {


    public SingleTodoTask() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Integer id = getArguments().getInt("id");
        Toast.makeText( requireActivity(), "" + id, Toast.LENGTH_SHORT).show();

        return inflater.inflate(R.layout.fragment_single_todo_task, container, false);
    }

}
