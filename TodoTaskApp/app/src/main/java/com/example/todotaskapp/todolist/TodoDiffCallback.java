package com.example.todotaskapp.todolist;

import android.support.v7.util.DiffUtil;

import java.util.List;

public class TodoDiffCallback extends DiffUtil.Callback {

    private final List<Task> oldGeneralForms;
    private final List<Task> newGeneralForms;

    public TodoDiffCallback(List<Task> newGeneralForms, List<Task> oldGeneralForms) {
        this.newGeneralForms = newGeneralForms;
        this.oldGeneralForms = oldGeneralForms;
    }


    @Override
    public int getOldListSize() {
        return oldGeneralForms.size();
    }

    @Override
    public int getNewListSize() {
        return newGeneralForms.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldGeneralForms.get(oldItemPosition).getId()
                .equals(newGeneralForms.get(newItemPosition).getId());
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldGeneralForms.get(oldItemPosition).equals(newGeneralForms.get(newItemPosition));
    }
}
