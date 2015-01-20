package com.api_hackathon.app.network.asyncTask;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import com.api_hackathon.app.network.WebServicesConstants;
import com.api_hackathon.app.utils.AppConstants;
import com.api_hackathon.app.utils.HTTPJsonPost;
import com.api_hackathon.app.views.IvrActivity;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 17-01-2015.
 */
public class AsyncTaskForShareRegisterId extends AsyncTask<Void, List<NameValuePair>, Void> {
    private String regId, phoneNumber;
    private static final String TAG = "AsyncTaskForCreateOrder";
    private Context context;
    public AsyncTaskForShareRegisterId(Context context, String regId, String phoneNumber){
        this.regId = regId;
        this.phoneNumber = phoneNumber;
        this.context = context;
    }
    @Override
    protected Void doInBackground(Void... params) {
        Log.w(TAG, "Response is : " + HTTPJsonPost.postRequest(WebServicesConstants.serverURL + WebServicesConstants.register, generateRequest()));
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Intent i = new Intent(context.getApplicationContext(),
                IvrActivity.class);
        context.startActivity(i);
        ((Activity) context).finish();
    }

    private List<NameValuePair> generateRequest() {
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
        nameValuePairs.add(new BasicNameValuePair("device_id", regId));
        nameValuePairs.add(new BasicNameValuePair("phone_number", phoneNumber));


        return nameValuePairs;
    }
}
