package com.api_hackathon.app.views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.api_hackathon.app.callback.Config;
import com.api_hackathon.app.network.asyncTask.AsyncTaskForShareRegisterId;
import com.api_hackathon.app.utils.AppConstants;
import com.google.android.gms.gcm.GoogleCloudMessaging;

import java.io.IOException;

/**
 * Created by USER on 18-01-2015.
 */
public class GCMAcitivityRegister {
    GoogleCloudMessaging gcm;
    Context context;
    String regId;
    private String phoneNumber;


    private static final String APP_VERSION = "appVersion";

    static final String TAG = "Register Activity";

    public GCMAcitivityRegister(Context context, String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.context = context;
        final SharedPreferences prefs = context.getSharedPreferences(
                MainActivity.class.getSimpleName(), Context.MODE_PRIVATE);
        regId = prefs.getString(AppConstants.REG_ID,"");
        Log.w(TAG, " Fucking RegId:"+regId);
        if (TextUtils.isEmpty(regId)) {
            regId = registerGCM();
            Log.d("RegisterActivity", "GCM RegId: " + regId);
        } else {
            Toast.makeText(context.getApplicationContext(),
                    "Already Registered with GCM Server!",
                    Toast.LENGTH_LONG).show();
            Log.w(TAG, "RegId:"+regId +" phoneNumber:"+phoneNumber);
            new AsyncTaskForShareRegisterId(context,regId,phoneNumber).execute();
        }
    }

    public String registerGCM() {

        gcm = GoogleCloudMessaging.getInstance(context);
        regId = getRegistrationId(context);

        if (TextUtils.isEmpty(regId)) {

            registerInBackground();

        } else {
            Toast.makeText(context.getApplicationContext(),
                    "RegId already available. RegId: " + regId,
                    Toast.LENGTH_LONG).show();
        }
        return regId;
    }

    private String getRegistrationId(Context context) {
        final SharedPreferences prefs = context.getSharedPreferences(
                MainActivity.class.getSimpleName(), Context.MODE_PRIVATE);
        String registrationId = prefs.getString(AppConstants.REG_ID, "");
        if (registrationId.isEmpty()) {
            Log.i(TAG, "Registration not found.");
            return "";
        }
        int registeredVersion = prefs.getInt(APP_VERSION, Integer.MIN_VALUE);
        int currentVersion = getAppVersion(context);
        if (registeredVersion != currentVersion) {
            Log.i(TAG, "App version changed.");
            return "";
        }
        return registrationId;
    }

    private static int getAppVersion(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Log.d("RegisterActivity",
                    "I never expected this! Going down, going down!" + e);
            throw new RuntimeException(e);
        }
    }

    private void registerInBackground() {
        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                String msg = "";
                try {
                    if (gcm == null) {
                        gcm = GoogleCloudMessaging.getInstance(context);
                    }
                    Log.w(TAG,"Request Send");
                    regId = gcm.register(Config.GOOGLE_PROJECT_ID);
                    Log.d("RegisterActivity", "registerInBackground - regId: "
                            + regId);
                    msg = "Device registered, registration ID=" + regId;

                    storeRegistrationId(context, regId);
                } catch (IOException ex) {
                    msg = "Error :" + ex.getMessage();
                    Log.d("RegisterActivity", "Error: " + msg);
                }
                Log.d("RegisterActivity", "AsyncTask completed: " + msg);
                return msg;
            }

            @Override
            protected void onPostExecute(String msg) {
                Toast.makeText(context.getApplicationContext(),
                        "Registered with GCM Server." + msg, Toast.LENGTH_LONG)
                        .show();

                if (TextUtils.isEmpty(regId)) {
                    Toast.makeText(context.getApplicationContext(), "RegId is empty!",
                            Toast.LENGTH_LONG).show();
                } else {
                    shareRegKey();
                }
            }
        }.execute();
    }

    private void storeRegistrationId(Context context, String regId) {
        final SharedPreferences prefs = context.getSharedPreferences(
                MainActivity.class.getSimpleName(), Context.MODE_PRIVATE);
        int appVersion = getAppVersion(context);
        Log.i(TAG, "Saving regId on app version " + appVersion);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(AppConstants.REG_ID, regId);
        editor.putInt(APP_VERSION, appVersion);
        editor.commit();
    }

    private void shareRegKey() {
        new AsyncTaskForShareRegisterId(context,regId, phoneNumber).execute();
    }
}

