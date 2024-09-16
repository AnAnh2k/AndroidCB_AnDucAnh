package com.example.lap02_bai4;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lap02_bai4.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnProject1 = findViewById(R.id.btnProject1);
        Button btnProject2 = findViewById(R.id.btnProject2);

        // Chuyển đến Project 1
        btnProject1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchApp(".MainActivity");
            }
        });

        // Chuyển đến Project 2
        btnProject2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchApp("com.example.otherproject2");
            }
        });
    }

    // Hàm để khởi động ứng dụng khác
    private void launchApp(String packageName) {
        Intent intent = getPackageManager().getLaunchIntentForPackage(packageName);
        if (intent != null) {
            startActivity(intent);  // Khởi chạy ứng dụng khác
        } else {
            Toast.makeText(MainActivity.this, "Ứng dụng chưa được cài đặt", Toast.LENGTH_LONG).show();
        }
    }
}
