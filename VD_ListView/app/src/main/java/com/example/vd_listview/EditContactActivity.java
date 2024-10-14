package com.example.vd_listview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vd_listview.Contact;

public class EditContactActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextPhone;
    private Button btnSave;
    private int contactPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        editTextName = findViewById(R.id.edit_text_name);
        editTextPhone = findViewById(R.id.edit_text_phone);
        btnSave = findViewById(R.id.btn_save);

        // Lấy dữ liệu từ Intent
        Contact contact = (Contact) getIntent().getSerializableExtra("contact");
        contactPosition = getIntent().getIntExtra("contact_position", -1);

        if (contact != null) {
            editTextName.setText(contact.getName());
            editTextPhone.setText(contact.getPhone());
        }

        // Sự kiện nút Save
        btnSave.setOnClickListener(v -> saveEditedContact());
    }

    private void saveEditedContact() {
        String name = editTextName.getText().toString().trim();
        String phone = editTextPhone.getText().toString().trim();

        if (name.isEmpty() || phone.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        Contact editedContact = new Contact(name, phone, R.drawable.trongcom);

        Intent resultIntent = new Intent();
        resultIntent.putExtra("edited_contact", editedContact);
        resultIntent.putExtra("contact_position", contactPosition);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
