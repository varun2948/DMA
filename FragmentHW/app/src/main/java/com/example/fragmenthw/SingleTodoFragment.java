package com.example.fragmenthw;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SingleTodoFragment extends ListFragment {




    public SingleTodoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_single_todo, container, false);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.Planets, android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
//        getListView().setOnItemClickListener((AdapterView.OnItemClickListener) this);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        List<String> Lines = Arrays.asList(getResources().getStringArray(R.array.Planets));
        ((MainActivity)requireActivity()).fragmentReplace(position);
        Toast.makeText(getActivity(), "Item: " + Lines.get(position), Toast.LENGTH_SHORT).show();

    }
}
