package com.example.lap02_bai2;

import android.os.Bundle; // Thêm import này để sử dụng Bundle
import androidx.appcompat.app.AppCompatActivity; // Thêm import này để sử dụng AppCompatActivity

public class ThucHienCuocGoiActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Gán layout cho Activity
        setContentView(R.layout.thuc_hien_cuoc_goi);
    }
}
