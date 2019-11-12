package com.example.todotaskapp.projectlist;

import android.support.v7.util.DiffUtil;

import java.util.List;

public class ProjectDiffCallback extends DiffUtil.Callback {

    private final List<String> oldTodo;
    private final List<String> newTodo;


    public ProjectDiffCallback(List<String> newTodo, List<String> oldTodo) {
        this.newTodo = newTodo;
        this.oldTodo = oldTodo;
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
    public boolean areItemsTheSame(int i, int i1) {
        return oldTodo.get(i).equals(newTodo.get(i1));
    }

    @Override
    public boolean areContentsTheSame(int i, int i1) {
        return oldTodo.get(i).equals(newTodo.get(i1));
    }
}
