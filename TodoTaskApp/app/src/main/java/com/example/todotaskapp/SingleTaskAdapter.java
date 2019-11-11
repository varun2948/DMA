package com.example.todotaskapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.todotaskapp.todolist.Task;
import com.example.todotaskapp.todolist.TodoDiffCallback;

import java.util.LinkedList;
import java.util.List;

public class SingleTaskAdapter extends RecyclerView.Adapter<SingleTaskAdapter.WordViewHolder> {
    private final LinkedList<Task> mWordList;
    private LayoutInflater mInflater;
    private OnTaskClickListener listener;

    class WordViewHolder extends RecyclerView.ViewHolder {
        public final TextView wordItemView;
        private final CheckBox checkBox;
        final SingleTaskAdapter mAdapter;

        public WordViewHolder(View itemView, SingleTaskAdapter adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
            checkBox = itemView.findViewById(R.id.checkbox);
            this.mAdapter = adapter;
        }
    }

    public SingleTaskAdapter(Context context, LinkedList<Task> wordList) {
        mInflater = LayoutInflater.from(context);
        this.mWordList = wordList;
    }

    public void updateList(List<Task> newList) {
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new TodoDiffCallback(newList, mWordList));
        mWordList.clear();
        mWordList.addAll(newList);
        diffResult.dispatchUpdatesTo(this);
    }

    public void setOnClickListener(OnTaskClickListener onClickListener) {
        this.listener = onClickListener;
    }

    @NonNull
    @Override
    public SingleTaskAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item,
                parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull SingleTaskAdapter.WordViewHolder holder, int position) {
        final Task mCurrent = mWordList.get(position);
        holder.wordItemView.setText(mCurrent.getTitle());
        holder.checkBox.setChecked(mCurrent.isCompleted());

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mCurrent.setCompleted(!mCurrent.isCompleted());
                listener.OnTaskCheckToggled(mCurrent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }

    public interface OnTaskClickListener {
        void OnTaskCheckToggled(Task task);
    }
}
