package com.example.todotaskapp.todolist;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.example.todotaskapp.todolist.source.Task;
import com.example.todotaskapp.todolist.source.TaskLocalSource;

import java.util.List;

public class TodoViewModel extends AndroidViewModel {

    private TaskLocalSource localSource;

    public TodoViewModel(@NonNull Application application) {
        super(application);
        localSource = new TaskLocalSource(application.getApplicationContext());
    }

    public LiveData<List<Task>> getTaskByProjectName(String dateTime) {
        return localSource.getTaskByProjectName(dateTime);
    }

    public boolean isTaskValidated(String title, String dateTime) {
        return !TextUtils.isEmpty(title) && !TextUtils.isEmpty(dateTime);
    }

    public boolean isProjectValid(String project) {
        return TextUtils.isEmpty(project);
    }


    public boolean isTaskValid(String task) {
        return TextUtils.isEmpty(task);
    }

    public Task mapInputToTask(String title, String dateTime, String projectName) {
        return new Task(title, dateTime, false, projectName);
    }

    public void saveTask(String title, String dateTime, String projectName) {
        boolean isValidated = isTaskValidated(title, dateTime);
        if (isValidated) {
            Task task = mapInputToTask(title, dateTime, projectName);
            saveTask(task);
        }
    }

    private void saveTask(final Task task) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                localSource.saveTask(task);
            }
        });

    }

    public void update(final Task task) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                localSource.update(task);
            }
        });
    }

    public LiveData<List<String>> getAllProjects() {
        return localSource.getAllProjects();
    }


    public List<String> getAllProjectsOnce() {
        return localSource.getAllProjectsOnce();
    }

    public void deleteByProjectName(final String projectName) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                localSource.deleteByProjectName(projectName);
            }
        });
    }
}
