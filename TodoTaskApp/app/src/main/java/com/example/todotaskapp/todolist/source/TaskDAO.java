package com.example.todotaskapp.todolist.source;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.todotaskapp.todolist.source.Task;

import java.util.List;

@Dao
public abstract class TaskDAO {

    @Insert
    public abstract void saveTask(Task task);

    @Delete
    public abstract void deleteTask(Task task);

    @Query("SELECT * FROM task WHERE projectName =:projectName ")
    public abstract LiveData<List<Task>> getTaskByDate(String projectName);

    @Query("SELECT DISTINCT(projectName) FROM task")
    public abstract LiveData<List<String>> getAllProjects();

    @Update
    public abstract void update(Task task);

    @Query("SELECT DISTINCT(projectName) FROM task")
    public abstract List<String> getAllProjectsOnce();

    @Query("DELETE from task WHERE projectName=:projectName")
    public abstract void deleteByProjectName(String projectName);
}
