package com.example.todotaskapp.todolist.source;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

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

    @Query("SELECT * from task WHERE dateTime <= :today AND isCompleted=:notCompleted")
    public abstract List<Task> getOverDueTask(String today,boolean notCompleted);
}
