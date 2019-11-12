package com.example.todotaskapp.todolist.source;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = "task")
public class Task {
    @PrimaryKey(autoGenerate = true)
    private
    Long id;
    private String title;
    private String dateTime;
    private boolean isCompleted;
    private String projectName;


    public Task(String title, String dateTime, boolean isCompleted, String projectName) {
        this.title = title;
        this.dateTime = dateTime;
        this.isCompleted = isCompleted;
        this.projectName = projectName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return isCompleted == task.isCompleted &&
                Objects.equals(id, task.id) &&
                Objects.equals(title, task.title) &&
                Objects.equals(dateTime, task.dateTime) &&
                Objects.equals(projectName, task.projectName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, dateTime, isCompleted, projectName);
    }
}
