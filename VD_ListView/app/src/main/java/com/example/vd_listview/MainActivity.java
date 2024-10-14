package com.example.vd_listview;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final int ADD_CONTACT_REQUEST = 1;
    public static final int EDIT_CONTACT_REQUEST = 2;
    private ListView listView;
    private ContactAdapter contactAdapter;
    private List<Contact> contactList;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list_view);
        contactList = new ArrayList<>();
        contactAdapter = new ContactAdapter(contactList, this);
        listView.setAdapter(contactAdapter);

        contactList.add(new Contact("Quỳnh", "0123456789", R.drawable.img));
        contactList.add(new Contact("Anh", "0987654321", R.drawable.img));
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_item,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(item.getItemId()==R.id.menu_add){
            Intent intent = new Intent(MainActivity.this, AddContactActivity.class);
            startActivityForResult(intent, ADD_CONTACT_REQUEST);
            return true;
        }
        else if (item.getItemId()==R.id.menu_info){
            Toast.makeText(MainActivity.this, "Info hollow", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (item.getItemId()==R.id.menu_setting){
            Toast.makeText(MainActivity.this, "Setting Close", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_CONTACT_REQUEST && resultCode == RESULT_OK) {
            // Thêm liên hệ mới
            Contact newContact = (Contact) data.getSerializableExtra("new_contact");
            contactList.add(newContact);
            contactAdapter.notifyDataSetChanged();
        } else if (requestCode == EDIT_CONTACT_REQUEST && resultCode == RESULT_OK) {
            // Cập nhật liên hệ đã chỉnh sửa
            Contact editedContact = (Contact) data.getSerializableExtra("edited_contact");
            int position = data.getIntExtra("contact_position", -1);
            if (position != -1) {
                contactList.set(position, editedContact); // Cập nhật liên hệ ở vị trí này
                contactAdapter.notifyDataSetChanged();
            }
        }
    }
}
