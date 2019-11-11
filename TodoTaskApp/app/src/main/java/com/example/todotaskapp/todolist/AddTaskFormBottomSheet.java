package com.example.todotaskapp.todolist;

import android.arch.lifecycle.Observer;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.example.todotaskapp.R;

import java.util.ArrayList;
import java.util.List;

public class AddTaskFormBottomSheet extends BottomSheetDialogFragment {
    private View rootView;
    private TaskLocalSource localSource;
    AutoCompleteTextView projectTextView;
    Context context;
    private ArrayAdapter<String> adapter;

    public static AddTaskFormBottomSheet newInstance() {
        return new AddTaskFormBottomSheet();
    }

    public void setOnClickListener(OnAddTask onClickListener) {
        this.listener = onClickListener;
    }

    private OnAddTask listener;

    public void updateProject(List<String> projects) {
        adapter.clear();
        adapter.addAll(projects);
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.bottom_sheet_add_task, container, false);
        localSource = new TaskLocalSource(getContext());
        final TextInputLayout textInputLayout = rootView.findViewById(R.id.ti_add_task);
        projectTextView = rootView.findViewById(R.id.auto_tv);

        rootView.findViewById(R.id.btn_add_task)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String title = textInputLayout.getEditText().getText().toString();
                        String projectName = projectTextView.getEditableText().toString();

                        textInputLayout.getEditText().getText().clear();
                        projectTextView.getText().clear();

                        dismiss();
                        listener.onAddTask(title, projectName);

                    }
                });


        projectTextView.setThreshold(1);


        this.context = rootView.getContext();
        adapter = new ArrayAdapter<String>
                (context, android.R.layout.select_dialog_item, new ArrayList<String>());


        updateProject(new ArrayList<String>());


        new TaskLocalSource(context).getAllProjects().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(@Nullable List<String> projects) {
                updateProject(projects);
            }
        });


        return rootView;
    }


    public interface OnAddTask {
        void onAddTask(String title, String projectName);
    }


}
