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

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m001_act_profile); // Gán layout cho Activity

        // Bắt sự kiện click cho ImageView
        ImageView imageView = findViewById(R.id.your_image_view_id); // Khởi tạo ImageView bên trong onCreate
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển sang ThucHienCuocGoiActivity
                Intent intent = new Intent(MainActivity.this, ThucHienCuocGoiActivity.class);
                startActivity(intent);
            }
        });

        // Cấu hình Edge-to-Edge và insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Xử lý ProgressBar
        ProgressBar circularProgressBar = findViewById(R.id.circularProgressBar);
        ObjectAnimator progressAnimator = ObjectAnimator.ofFloat(circularProgressBar, "rotation", 0f, 360f);
        progressAnimator.setDuration(5000);
        progressAnimator.setInterpolator(new LinearInterpolator());
        progressAnimator.start();
    }

    // Hàm thực hiện cuộc gọi
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
