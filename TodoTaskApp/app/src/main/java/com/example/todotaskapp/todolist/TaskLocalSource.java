package com.example.todotaskapp.todolist;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import com.example.todotaskapp.db.TodoDatabase;

import java.util.List;

public class TaskLocalSource {

    private TaskDAO dao;


    TaskLocalSource(Context context) {
        dao = TodoDatabase.getDatabase(context).getTaskDao();
    }

    public void saveTask(Task task) {
        dao.saveTask(task);
    }

    public void deleteTask(Task task) {
        dao.deleteTask(task);
    }

    public LiveData<List<Task>> getTaskByProjectName(String projectName) {
        return dao.getTaskByDate(projectName, false);
    }


    public void update(Task task) {
        dao.update(task);
    }

    public LiveData<List<String>> getAllProjects(){
        return dao.getAllProjects();
    }

    public List<String> getAllProjectsOnce() {
        return dao.getAllProjectsOnce();
    }
}
