package com.example.todotaskapp.todolist;

import android.app.AlertDialog;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.example.todotaskapp.R;
import com.example.todotaskapp.SingleTaskAdapter;
import com.example.todotaskapp.ViewModelFactory;

import java.util.LinkedList;
import java.util.List;

public class TasksLists extends AppCompatActivity implements SingleTaskAdapter.OnTaskClickListener {

    private TodoViewModel viewModel;


    private final LinkedList<Task> mWordList = new LinkedList<>();

    private RecyclerView mRecyclerView;

    private SingleTaskAdapter mAdapter;
    private String projectName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks_lists);


        ViewModelFactory factory = ViewModelFactory.getInstance();
        viewModel = ViewModelProviders.of(this, factory).get(TodoViewModel.class);


        projectName = getIntent().getStringExtra("extra_project_name");

        mRecyclerView = findViewById(R.id.single_task_recyclerview);
        // Create an adapter and supply the data to be displayed.
        mAdapter = new SingleTaskAdapter(this, mWordList);
        mAdapter.setOnClickListener(this);
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        viewModel.getTaskByProjectName(projectName)
                .observe(this, new Observer<List<Task>>() {
                    @Override
                    public void onChanged(@Nullable List<Task> tasks) {
                        if (tasks != null) {
                            mAdapter.updateList(tasks);
                        }
                    }
                });

        findViewById(R.id.Add_btn)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showAddTaskDialog(viewModel.getAllProjectsOnce(), projectName);
                    }
                });
    }


    private void showAddTaskDialog(List<String> projects, String projectName) {
        final View view = LayoutInflater.from(this)
                .inflate(R.layout.add_task_layout, null);
        final AutoCompleteTextView autoCompleteTextView = view.findViewById(R.id.auto_tv);
        final TextInputLayout taskName = view.findViewById(R.id.ti_add_task);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, projects);
        autoCompleteTextView.setAdapter(adapter);
        if (projectName != null) {
            autoCompleteTextView.setText(projectName);
        }


        AlertDialog.Builder dialog = new AlertDialog.Builder(this).
                setTitle("Add task in " + projectName)
                .setView(view)
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String title = taskName.getEditText().getText().toString();
                        String projectName = autoCompleteTextView.getEditableText().toString();

                        taskName.getEditText().getText().clear();
                        autoCompleteTextView.getText().clear();

                        viewModel.saveTask(title,
                                String.valueOf(System.currentTimeMillis()),
                                projectName);

                    }
                })
                .setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

        dialog.show();
    }

    @Override
    public void OnTaskCheckToggled(Task task) {
        viewModel.update(task);
    }

}
