package com.example;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lap02_bai1.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int[] backgroundColors = {
            Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.CYAN, Color.MAGENTA
    };

    private int[] icons = {
            R.drawable.penguin, R.drawable.moneybag, R.drawable.checklist
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        FrameLayout backgroundContainer = findViewById(R.id.background_container);
        ImageView randomIcon = findViewById(R.id.random_icon);

        // Set random background color
        int randomColor = backgroundColors[new Random().nextInt(backgroundColors.length)];
        backgroundContainer.setBackgroundColor(randomColor);

        // Set random icon
        int randomIconResource = icons[new Random().nextInt(icons.length)];
        randomIcon.setImageResource(randomIconResource);
    }
}