package com.api_hackathon.app.utils;

import android.content.Context;
import android.database.Cursor;

import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;

import java.util.ArrayList;

/**
 * Created by USER on 17-01-2015.
 */
public class PhoneBookList {

    private Context context;
    public PhoneBookList(Context context){
        this.context = context;
    }

    private ArrayList<ContactList> setContactsToAdapter() {
        ArrayList<ContactList> listPhoneBook = new ArrayList<ContactList>();
        Cursor cursor = getContacts();
        cursor.moveToFirst();
        while (cursor.moveToNext()) {
            ContactList contactList = new ContactList();
            String name = cursor.getString(cursor
                    .getColumnIndex(Phone.DISPLAY_NAME));
            String phone = cursor.getString(cursor
                    .getColumnIndex(Phone.NUMBER));

            contactList.setName(name);
            contactList.setPhone(phone);
            listPhoneBook.add(contactList);
        }
        return listPhoneBook;
    }

    private Cursor getContacts() {
        Uri uri = Phone.CONTENT_URI;
        String[] projection = new String[]{
                Phone.DISPLAY_NAME,
                Phone.NUMBER
        };
        String selection = ContactsContract.Contacts.IN_VISIBLE_GROUP + " = '"
                + ("1") + "'";
        String orderBy = Phone.DISPLAY_NAME+" DESC";

        return context.getContentResolver().query(uri, projection, selection, null, orderBy);
    }
}
