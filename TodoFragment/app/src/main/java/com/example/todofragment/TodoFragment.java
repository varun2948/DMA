package com.example.todofragment;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class TodoFragment extends Fragment {

//    private static final String ARG_TODO_ID= todo_id ;
    private Todo mTodo;
    private EditText mEditTextTitle;
    private Button mButtonDate;
    private CheckBox mCheckBoxIsComplete;

    public TodoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTodo = new Todo();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_todo, container,false);

        mEditTextTitle = view.findViewById(R.id.todo_title);
        mEditTextTitle.setText(mTodo.getTodoTitle());
        mEditTextTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Toast.makeText(getActivity(),"Text Changed", Toast.LENGTH_LONG).show();
                mTodo.setTodoTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mButtonDate = view.findViewById(R.id.todo_date);
        mButtonDate.setText(mTodo.getTodoDate().toString());
        mButtonDate.setEnabled(false);


        mCheckBoxIsComplete = (CheckBox) view.findViewById(R.id.todo_complete);
        mCheckBoxIsComplete.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(getActivity(),"checkbox: "+isChecked, Toast.LENGTH_LONG).show();
                mTodo.setTodoIsComplete(isChecked);
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

}
