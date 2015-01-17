package com.api_hackathon.app.views;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.*;
import com.api_hackathon.app.R;
import com.api_hackathon.app.animations.BasicAnimations;
import com.api_hackathon.app.network.asyncTask.AsyncTaskForSendPhoneNumber;
import com.api_hackathon.app.network.requestDTO.BloodRequest;
import com.api_hackathon.app.utils.AppConstants;
import com.api_hackathon.app.utils.ContactList;
import com.api_hackathon.app.utils.POJOToJSON;

import java.util.ArrayList;
import java.util.List;

public class IvrActivity extends Activity {
    private static final String TAG = "IvrActivity";
    private PhoneBookAdapter phoneBookAdapter;
    private List<ContactList> listPhoneBook;
    private Button sendButton;
    private BasicAnimations basicAnimations;
    private EditText searchEditText;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_ivr);
        basicAnimations = new BasicAnimations(this);
        ListView phoneList = (ListView) findViewById(R.id.contacts_list_view);
        listPhoneBook = new ArrayList<ContactList>();

        phoneBookAdapter = new PhoneBookAdapter(IvrActivity.this, listPhoneBook);
        phoneList.setAdapter(phoneBookAdapter);
        setContactsToAdapter();
        sendButton = (Button) findViewById(R.id.send_button);
        searchEditText = (EditText) findViewById(R.id.search_edit_text);
        searchEditText.addTextChangedListener(textWatcher);
        sendButton.setOnClickListener(onClickListener);

        Spinner spinner = (Spinner) findViewById(R.id.blood_group_spinner);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(IvrActivity.this, R.layout.normal_text, getResources().getStringArray(R.array.blood_group));
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(arrayAdapter);

    }

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence text, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence text, int start, int before, int count) {
            phoneBookAdapter.getFilter().filter(text.toString());
            phoneBookAdapter.notifyDataSetChanged();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private void setContactsToAdapter() {
        Cursor cursor = getContacts();
        cursor.moveToFirst();
        while (cursor.moveToNext()) {
            ContactList contacts = new ContactList();
            String name = cursor.getString(cursor
                    .getColumnIndex(Phone.DISPLAY_NAME));
            String phone = cursor.getString(cursor
                    .getColumnIndex(Phone.NUMBER));

            contacts.setName(name);
            contacts.setPhone(phone);
            listPhoneBook.add(contacts);
        }
        phoneBookAdapter.notifyDataSetChanged();
    }

    private Cursor getContacts() {
        Uri uri = Phone.CONTENT_URI;
        String[] projection = new String[]{
                Phone.DISPLAY_NAME,
                Phone.NUMBER
        };
        String selection = ContactsContract.Contacts.IN_VISIBLE_GROUP + " = '"
                + ("1") + "'";

        return getContentResolver().query(uri, projection, selection, null, null);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            sendButton.startAnimation(basicAnimations.zoomIn);
            BloodRequest bloodRequest = getRequestObject();
            if (bloodRequest != null) {
                Toast.makeText(IvrActivity.this, "Request sent successfully ", Toast.LENGTH_SHORT).show();
                new AsyncTaskForSendPhoneNumber(getRequestObject()).execute();
            } else {
                Toast.makeText(IvrActivity.this, "Problem in sending request", Toast.LENGTH_SHORT).show();
            }
        }
    };

    private BloodRequest getRequestObject() {
        try {
            Spinner bloodGroupEditText = (Spinner) findViewById(R.id.blood_group_spinner);
            BloodRequest bloodRequest = new BloodRequest();
            bloodRequest.setBloodGroup(bloodGroupEditText.getSelectedItem().toString());
            SharedPreferences sharedPreference = getSharedPreferences(
                    AppConstants.APP_SHARED_PREFERENCE, Context.MODE_PRIVATE);
            bloodRequest.setContactNumber(sharedPreference.getString(AppConstants.myContactPrefKey, ""));
            StringBuffer stringBuffer = new StringBuffer();
            for (ContactList contact : listPhoneBook) {
                if (contact.isSelected()) {
                    String phone = contact.getPhone().replace("-", "");
                    phone = phone.replace(" ", "");
                    StringBuffer phoneNumber = new StringBuffer();
                    phoneNumber.append(phone);
                    if (phoneNumber.length() > 10) {
                        stringBuffer.append(phoneNumber.substring(phoneNumber.length() - 10, phoneNumber.length()) + ",");
                        ;
                    } else {
                        stringBuffer.append(contact.getPhone() + ",");
                    }

                }
            }
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            bloodRequest.setContact_list(stringBuffer.toString());
            Log.w(TAG, "Request: " + POJOToJSON.toJson(bloodRequest, false));
            return bloodRequest;
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "Problem in generating JSON request");
            return null;
        }
    }
}
