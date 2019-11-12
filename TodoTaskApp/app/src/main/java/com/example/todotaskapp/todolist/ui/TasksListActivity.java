package com.example.todotaskapp.todolist.ui;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.todotaskapp.R;
import com.example.todotaskapp.common.ViewModelFactory;
import com.example.todotaskapp.common.DateUtils;
import com.example.todotaskapp.todolist.TodoViewModel;
import com.example.todotaskapp.todolist.source.Task;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class TasksListActivity extends AppCompatActivity implements TodoListAdapter.OnTaskClickListener {

    private TodoViewModel viewModel;


    private final LinkedList<Task> mWordList = new LinkedList<>();

    private RecyclerView mRecyclerView;

    private TodoListAdapter mAdapter;
    private String projectName;
    private int projectColor;
    private CardView cardView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks_lists);


        ViewModelFactory factory = ViewModelFactory.getInstance();
        viewModel = ViewModelProviders.of(this, factory).get(TodoViewModel.class);


        projectName = getIntent().getStringExtra("extra_project_name");
        projectColor = getIntent().getIntExtra("extra_project_color", 0);

        bindUI();
        setupRecyclerView();

        cardView.setCardBackgroundColor(projectColor);


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

    private void setupRecyclerView() {
        // Create an adapter and supply the data to be displayed.
        mAdapter = new TodoListAdapter(this, mWordList);
        mAdapter.setOnClickListener(this);
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void bindUI() {
        cardView = findViewById(R.id.card_view);
        mRecyclerView = findViewById(R.id.single_task_recyclerview);

    }

    private void showAddTaskDialog(List<String> projects, String projectName) {
        final View view = LayoutInflater.from(this)
                .inflate(R.layout.add_task_layout, null);
        final AutoCompleteTextView autoCompleteTextView = view.findViewById(R.id.auto_tv);
        final TextInputLayout taskName = view.findViewById(R.id.ti_add_task);
        final TextView tvDate = view.findViewById(R.id.tv_date);

//        autoCompleteTextView.setFocusable(false);
//        autoCompleteTextView.setClickable(false);
        autoCompleteTextView.setEnabled(false);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, projects);
        autoCompleteTextView.setAdapter(adapter);
        if (projectName != null) {
            autoCompleteTextView.setText(projectName);
        }


        Calendar calendar = Calendar.getInstance();
        final int startYear = calendar.get(Calendar.YEAR);
        final int starthMonth = calendar.get(Calendar.MONTH);
        final int startDay = calendar.get(Calendar.DAY_OF_MONTH);
        String date = DateUtils.formatDate(startYear, starthMonth, startDay);
        tvDate.setText(date);

        view.findViewById(R.id.tv_date)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        DatePickerDialog datePickerDialog = new DatePickerDialog(
                                TasksListActivity.this, R.style.anim_dialog, new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                                String date = DateUtils.formatDate(year, monthOfYear, dayOfMonth);
                                tvDate.setText(date);
                            }
                        }, startYear, starthMonth, startDay);

                        datePickerDialog.show();
                    }
                });

        final AlertDialog.Builder dialog = new AlertDialog.Builder(this, R.style.anim_dialog)
                .setTitle("Add task")
                .setView(view)
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String title = taskName.getEditText().getText().toString();
                        String projectName = autoCompleteTextView.getEditableText().toString();
                        String date = tvDate.getText().toString();

                        taskName.getEditText().getText().clear();
                        autoCompleteTextView.getText().clear();
//                        autoCompleteTextView.setClickable(false);
                        viewModel.saveTask(title,
                                date,
                                projectName);


                    }
                })
                .setNegativeButton("Dismiss", null);

        dialog.show();
    }

    @Override
    public void OnTaskCheckToggled(Task task) {
        viewModel.update(task);
    }

}
