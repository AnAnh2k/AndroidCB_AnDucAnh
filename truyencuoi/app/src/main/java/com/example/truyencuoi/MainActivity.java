package com.example.truyencuoi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StoryAdapter storyAdapter;
    private List<Story> storyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Khởi tạo danh sách câu chuyện
        storyList = new ArrayList<>();
        storyList.add(new Story("Truyện Cười Dân Gian", "Nội dung Công sở..."));
        storyList.add(new Story("Truyện Cười Thông Minh", "Nội dung Cười 18..."));
        storyList.add(new Story("Truyện Cười Tình Huống", "Nội dung Cực hài..."));

        storyAdapter = new StoryAdapter(storyList, this);
        recyclerView.setAdapter(storyAdapter);
    }
}
