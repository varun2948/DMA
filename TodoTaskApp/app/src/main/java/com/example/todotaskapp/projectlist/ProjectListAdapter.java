package com.example.todotaskapp.projectlist;

import android.content.Context;
import android.graphics.Color;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.todotaskapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ProjectListAdapter extends RecyclerView.Adapter<ProjectListAdapter.CustomViewHolder> {
    private Context context;
    private ArrayList<String> items;
    private OnProjectClickListener listener;

    public void setOnClickListener(OnProjectClickListener listener) {
        this.listener = listener;
    }

    public ProjectListAdapter(Context context, ArrayList<String> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.items, parent, false));
    }

    public void updateList(List<String> newList) {
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new ProjectDiffCallback(newList, items));
        items.clear();
        items.addAll(newList);
        diffResult.dispatchUpdatesTo(this);
    }

    @Override
    public void onBindViewHolder(@NonNull final CustomViewHolder holder, int position) {
        final String projectName = items.get(position);
        final int color = Color.parseColor(getColorByPos(position));
        holder.itemTitle.setText(projectName);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onProjectTap(projectName, color, holder.itemView);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                listener.onProjectLongTap(projectName);
                return true;
            }
        });
        holder.rootLayout.setCardBackgroundColor(color);
    }


    private String getColorByPos(int pos) {
        if (pos < colors.length) {
            return colors[pos];
        } else {
            int newPos = pos - colors.length;
            return getColorByPos(newPos);
        }
    }

    public static int getRandomColor(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return Color.parseColor(array[rnd]);

    }


    private String[] colors = new String[]{
            "#b71c1c", "#aa00ff", "#651fff", "#3d5afe", "#2979ff",
            "#00b0ff", "#00b8d4", "#004d40", "#2e7d32", "#ffd600",
            "#ffab00", "#3e2723"

    };


    @Override
    public int getItemCount() {
        return items.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        private TextView itemTitle;
        private CardView rootLayout;

        public CustomViewHolder(View view) {
            super(view);
            itemTitle = view.findViewById(R.id.tv_project_name);
            rootLayout = view.findViewById(R.id.root_layout);
        }
    }

    public interface OnProjectClickListener {
        void onProjectTap(String projectName, int color, View itemView);

        void onProjectLongTap(String projectName);
    }
}
