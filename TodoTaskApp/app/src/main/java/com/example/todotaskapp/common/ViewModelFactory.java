package com.example.todotaskapp.common;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.App;
import com.example.todotaskapp.todolist.TodoViewModel;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private static ViewModelFactory viewModelFactory;

    public static synchronized ViewModelFactory getInstance() {
        if (viewModelFactory == null) {
            viewModelFactory = new ViewModelFactory();
        }

        return viewModelFactory;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(TodoViewModel.class)) {
            //noinspection unchecked
            return (T) new TodoViewModel(App.getInstance());
        }
        throw new IllegalArgumentException("Unknown ViewModel class" + modelClass.getName());
    }
}
