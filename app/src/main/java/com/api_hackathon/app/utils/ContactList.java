package com.api_hackathon.app.utils;

/**
 * Created by USER on 17-01-2015.
 */
public class ContactList {
    private String name;
    private String phone;
    private boolean isSelected;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    @Override
    public String toString() {
        return name;
    }
}
