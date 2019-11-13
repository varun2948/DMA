package com.example.todotaskapp.db;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

import com.example.todotaskapp.todolist.source.Task;
import com.example.todotaskapp.todolist.source.TaskDAO;

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
