package com.example.todotaskapp.todolist.ui;

import androidx.recyclerview.widget.DiffUtil;

import com.example.todotaskapp.todolist.source.Task;

import java.util.List;

public class TodoDiffCallback extends DiffUtil.Callback {

    private final List<Task> oldTodo;
    private final List<Task> newTodo;

    public TodoDiffCallback(List<Task> newGeneralForms, List<Task> oldGeneralForms) {
        this.newTodo = newGeneralForms;
        this.oldTodo = oldGeneralForms;
    }


    @Override
    public int getOldListSize() {
        return oldTodo.size();
    }

    @Override
    public int getNewListSize() {
        return newTodo.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldTodo.get(oldItemPosition).getId()
                .equals(newTodo.get(newItemPosition).getId());
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldTodo.get(oldItemPosition).equals(newTodo.get(newItemPosition));
    }
}
