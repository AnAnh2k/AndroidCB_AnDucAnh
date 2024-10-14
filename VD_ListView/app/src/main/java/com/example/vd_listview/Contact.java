package com.example.vd_listview;

import java.io.Serializable;

public class Contact implements Serializable {
    private String name;
    private String phone;
    private int imageResId;

    public Contact(String name, String phone, int imageResId) {
        this.name = name;
        this.phone = phone;
        this.imageResId = imageResId;
    }


    public Contact(String name, String phone) {
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public int getImageResId() {
        return imageResId;
    }
}
