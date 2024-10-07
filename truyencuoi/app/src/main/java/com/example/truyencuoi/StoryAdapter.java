package com.example.truyencuoi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.MyViewHolder> {

    private List<Story> storyList;
    private Context context;

    public StoryAdapter(List<Story> storyList, Context context) {
        this.storyList = storyList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_story, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Story story = storyList.get(position);
        holder.titleTextView.setText(story.getTitle());

        // Đặt OnClickListener cho itemView
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển đến SubcategoryActivity
                Intent intent = new Intent(context, SubcategoryActivity.class);
                intent.putExtra("storyTitle", story.getTitle()); // Sử dụng đối tượng story
                intent.putExtra("storyContent", story.getContent());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return storyList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
        }
    }
}
