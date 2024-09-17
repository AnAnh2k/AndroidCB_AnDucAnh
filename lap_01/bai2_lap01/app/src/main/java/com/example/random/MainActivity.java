package com.example.random;
import android.widget.*;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.random.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView txtNumber;
    private Button btnGenerate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNumber = findViewById(R.id.txtNumber);
        btnGenerate = findViewById(R.id.btnGenerate);

        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int number = random.nextInt(100) + 1; // Generate a random number between 1 and 100
                txtNumber.setText(String.valueOf(number));
            }
        });
    }
}
