package com.example.todotaskapp.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.todotaskapp.todolist.Task;
import com.example.todotaskapp.todolist.TaskDAO;

@Database(entities = Task.class, version = 1)
public abstract class TodoDatabase extends RoomDatabase {
    private static TodoDatabase todoDatabase;


    public abstract TaskDAO getTaskDao();

    public static TodoDatabase getDatabase(final Context context) {
        if (todoDatabase != null) {
            return todoDatabase;
        }

        synchronized (TodoDatabase.class) {
            if (todoDatabase == null) {
                todoDatabase = Room.databaseBuilder(context.getApplicationContext(),
                        TodoDatabase.class, "todo.db")
                        .allowMainThreadQueries()
                        .build();
            }
        }

        return todoDatabase;
    }

}
