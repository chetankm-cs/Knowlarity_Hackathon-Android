package com.api_hackathon.app.broadcast;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import java.util.Date;

/**
 * Created by USER on 17-01-2015.
 */
public class CallReceiver extends PhoneCallReceiver {

    private final String TAG = "CallReceiver";

    @Override
    protected void onIncomingCallStarted(Context context, String number, Date start) {
        Log.w(TAG, "onIncomingCallStarted:"+ number+" : "+start.toString());
    }

    @Override
    protected void onOutgoingCallStarted(Context context, String number, Date start) {
        Log.w(TAG, "onOutgoingCallStarted:"+ number+" : "+start.toString());
//        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com"));
//        browserIntent.setFlags(browserIntent.FLAG_ACTIVITY_NEW_TASK);
//        context.startActivity(browserIntent);
    }

    @Override
    protected void onIncomingCallEnded(Context context, String number, Date start, Date end) {
        Log.w(TAG, "onIncomingCallEnded:"+ number+" : "+start.toString());
    }

    @Override
    protected void onOutgoingCallEnded(Context context, String number, Date start, Date end) {
        Log.w(TAG, "onOutgoingCallEnded:"+ number+" : "+start.toString());
    }

    @Override
    protected void onMissedCall(Context context, String number, Date start) {
        Log.w(TAG, "onMissedCall:"+ number+" : "+start.toString());
    }

}
