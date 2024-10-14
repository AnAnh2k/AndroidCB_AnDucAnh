package com.example.vd_listview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddContactActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextPhone;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        editTextName = findViewById(R.id.edit_text_name);
        editTextPhone = findViewById(R.id.edit_text_phone);
        btnSave = findViewById(R.id.btn_save);

        btnSave.setOnClickListener(v -> saveContact());
    }

    private void saveContact() {
        String name = editTextName.getText().toString().trim();
        String phone = editTextPhone.getText().toString().trim();

        if (name.isEmpty() || phone.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Tạo đối tượng Contact mới
        Contact newContact = new Contact(name, phone, R.drawable.img); // Thay đổi hình ảnh liên hệ nếu cần

        // Trả kết quả về MainActivity
        Intent resultIntent = new Intent();
        resultIntent.putExtra("new_contact", newContact);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
