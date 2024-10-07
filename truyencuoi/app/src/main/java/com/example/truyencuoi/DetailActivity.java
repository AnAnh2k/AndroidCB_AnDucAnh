package com.example.truyencuoi;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView titleTextView = findViewById(R.id.titleTextView);
        TextView contentTextView = findViewById(R.id.contentTextView);

        // Nhận dữ liệu từ Intent
        String storyTitle = getIntent().getStringExtra("storyTitle");
        String storyContent = getIntent().getStringExtra("storyContent");

        titleTextView.setText(storyTitle);
        contentTextView.setText(storyContent);
    }
}
