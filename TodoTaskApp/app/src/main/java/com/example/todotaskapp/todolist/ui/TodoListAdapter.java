package com.example.todotaskapp.todolist.ui;

import android.content.Context;
import android.graphics.Paint;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.todotaskapp.R;
import com.example.todotaskapp.todolist.source.Task;

import java.util.LinkedList;
import java.util.List;

public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.WordViewHolder> {
    private final LinkedList<Task> mWordList;
    private LayoutInflater mInflater;
    private OnTaskClickListener listener;

    class WordViewHolder extends RecyclerView.ViewHolder {
        public final TextView wordItemView;
        private final CheckBox checkBox;
        private final TextView tvDate;
        final TodoListAdapter mAdapter;

        public WordViewHolder(View itemView, TodoListAdapter adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
            checkBox = itemView.findViewById(R.id.checkbox);
            tvDate = itemView.findViewById(R.id.tv_date);
            this.mAdapter = adapter;
        }
    }

    public TodoListAdapter(Context context, LinkedList<Task> wordList) {
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
    public TodoListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item,
                parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull final TodoListAdapter.WordViewHolder holder, int position) {
        final Task mCurrent = mWordList.get(position);
        holder.wordItemView.setText(mCurrent.getTitle());
//        if(mCurrent.isCompleted()){
//            holder.wordItemView.setPaintFlags(holder.wordItemView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
//        }
        if(mCurrent.isCompleted() ){

            holder.checkBox.setEnabled(false);
            holder.wordItemView.setPaintFlags(holder.wordItemView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }else{
            holder.wordItemView.setPaintFlags(holder.wordItemView.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
            holder.checkBox.setEnabled(true);
        }
        holder.checkBox.setChecked(mCurrent.isCompleted());
        holder.tvDate.setText(mCurrent.getDateTime());

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mCurrent.setCompleted(!mCurrent.isCompleted());
                if(mCurrent.isCompleted() ){

                    holder.checkBox.setEnabled(false);
                    holder.wordItemView.setPaintFlags(holder.wordItemView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                }else{
                    holder.wordItemView.setPaintFlags(holder.wordItemView.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                    holder.checkBox.setEnabled(true);
                }
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
