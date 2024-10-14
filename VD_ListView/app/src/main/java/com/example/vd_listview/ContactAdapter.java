package com.example.vd_listview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends BaseAdapter {

    private List<Contact> contactList;
    private Context context;

    public ContactAdapter(List<Contact> contactList, Context context) {
        this.contactList = contactList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return contactList.size();
    }

    @Override
    public Object getItem(int position) {
        return contactList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.contact_item, parent, false);
        }

        Contact contact = contactList.get(position);

        ImageView contactImage = convertView.findViewById(R.id.contact_image);
        TextView contactName = convertView.findViewById(R.id.contact_name);
        TextView contactPhone = convertView.findViewById(R.id.contact_phone);
        Button btnCall = convertView.findViewById(R.id.btn_call);
        Button btnMessage = convertView.findViewById(R.id.btn_message);
        Button btnSetting = convertView.findViewById(R.id.setting);

        contactImage.setImageResource(contact.getImageResId());
        contactName.setText(contact.getName());
        contactPhone.setText(contact.getPhone());

        // Xử lý sự kiện click nút Call và Sent
        btnCall.setOnClickListener(v -> {
            // Mở ứng dụng gọi điện
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:" + contact.getPhone()));
            context.startActivity(callIntent);
        });

        btnMessage.setOnClickListener(v -> {
            // Mở ứng dụng nhắn tin
            Intent smsIntent = new Intent(Intent.ACTION_VIEW);
            smsIntent.setData(Uri.parse("sms:" + contact.getPhone()));
            context.startActivity(smsIntent);
        });

        btnSetting.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(context, btnSetting);
            MenuInflater inflater = popupMenu.getMenuInflater();
            inflater.inflate(R.menu.menu_contact, popupMenu.getMenu());
            popupMenu.show(); // Hiển thị menu

            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    if (menuItem.getItemId() == R.id.menu_fix) {
                        Intent intent = new Intent(context, EditContactActivity.class);
                        intent.putExtra("contact_position", position);
                        intent.putExtra("contact", contact);
                        ((Activity) context).startActivityForResult(intent, MainActivity.EDIT_CONTACT_REQUEST);
                        return true;
                    } else if (menuItem.getItemId() == R.id.menu_delete) {
                        contactList.remove(position);
                        notifyDataSetChanged();
                        return true;
                    }
                    return false;
                }
            });
        });
        return convertView;
    }
}
