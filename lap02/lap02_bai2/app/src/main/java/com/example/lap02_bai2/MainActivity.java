package com.example.lap02_bai2;
import static com.example.lap02_bai2.R.id.circularProgressBar;

import android.annotation.SuppressLint;
import android.widget.*;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.m001_act_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ProgressBar circularProgressBar;
        circularProgressBar = findViewById(R.id.circularProgressBar);

        // Create an animation that spins the progress bar in a full circle
        ObjectAnimator progressAnimator = ObjectAnimator.ofFloat(circularProgressBar, "rotation", 0f, 360f);
        progressAnimator.setDuration(5000);
        // progressAnimator.setRepeatCount(ObjectAnimator.INFINITE);
        progressAnimator.setInterpolator(new LinearInterpolator());
        progressAnimator.start();
    }

    public void makePhoneCall(View view) {
        String phoneNumber = "tel:0906262004";
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse(phoneNumber));

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "No app to handle phone calls", Toast.LENGTH_SHORT).show();
        }
    }
}