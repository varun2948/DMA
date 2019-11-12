package com.example.todotaskapp;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.todotaskapp.common.DateUtils;
import com.example.todotaskapp.todolist.AddTaskFormBottomSheet;
import com.example.todotaskapp.todolist.TasksLists;
import com.example.todotaskapp.todolist.TodoViewModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AddTaskFormBottomSheet.OnAddTask, CustomAdapter.OnProjectClickListener {
    private TodoViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ArrayList<String> items = new ArrayList<>();
        final CustomAdapter adapter = new CustomAdapter(this, items);
        adapter.setOnClickListener(this);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        SnapHelper startSnapHelper = new PagerSnapHelper();
        startSnapHelper.attachToRecyclerView(recyclerView);

        recyclerView.setAdapter(adapter);

        ViewModelFactory factory = ViewModelFactory.getInstance();
        viewModel = ViewModelProviders.of(this, factory).get(TodoViewModel.class);

        viewModel.getAllProjects().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(@Nullable List<String> projects) {
                if (projects != null) {
                    adapter.updateList(projects);
                }
            }
        });


        findViewById(R.id.Add_btn)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showAddTaskDialog(viewModel.getAllProjectsOnce(), null);
                    }
                });
    }

    private void showAddTaskDialog(List<String> projects, String projectName) {
        final View view = LayoutInflater.from(this)
                .inflate(R.layout.add_task_layout, null);
        final AutoCompleteTextView autoCompleteTextView = view.findViewById(R.id.auto_tv);
        final TextInputLayout taskName = view.findViewById(R.id.ti_add_task);
        final TextView tvDate = view.findViewById(R.id.tv_date);

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
                                MainActivity.this, R.style.anim_dialog, new DatePickerDialog.OnDateSetListener() {
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
                        boolean isValidated = viewModel.isTaskValidated(title, projectName);
                        if (isValidated) {
                            viewModel.saveTask(title,
                                    date,
                                    projectName);
                        } else {
                            final Animation animShake = AnimationUtils.loadAnimation(MainActivity.this, R.anim.shake);

                        }


                    }
                })
                .setNegativeButton("Dismiss", null);

        dialog.show();
    }


    private void showDeleteConfirmationDialog(final String projectName) {

        AlertDialog.Builder dialog = new AlertDialog.Builder(this, R.style.anim_dialog).
                setTitle("Delete " + projectName)
                .setMessage(String.format("Delete %s along with all its tasks", projectName))
                .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        viewModel.deleteByProjectName(projectName);
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
    public void onAddTask(String title, String projectName) {
        viewModel.saveTask(title, String.valueOf(System.currentTimeMillis()), projectName);
    }


    @Override
    public void onProjectTap(String projectName, int color, View view) {

        Intent intent = new Intent(this, TasksLists.class);
        intent.putExtra("extra_project_name", projectName);
        intent.putExtra("extra_project_color", color);
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, view, "profile");
        startActivity(intent, options.toBundle());


    }

    @Override
    public void onProjectLongTap(String projectName) {
        showDeleteConfirmationDialog(projectName);
    }
}
