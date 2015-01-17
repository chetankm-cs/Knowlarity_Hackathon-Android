package com.api_hackathon.app.network.asyncTask;

import android.os.AsyncTask;
import android.util.Log;
import com.api_hackathon.app.network.WebServicesConstants;
import com.api_hackathon.app.utils.AppConstants;
import com.api_hackathon.app.utils.HTTPJsonPost;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 17-01-2015.
 */
public class AsyncTaskForCreateOrder extends AsyncTask<Void, List<NameValuePair>, Void> {

    private static final String TAG = "AsyncTaskForCreateOrder";

    @Override
    protected Void doInBackground(Void... params) {
        Log.w(TAG, "Response is : " + HTTPJsonPost.postRequest(WebServicesConstants.ivrURL + WebServicesConstants.createOrder, generateRequest()));
        return null;
    }


    private List<NameValuePair> generateRequest() {
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);

        nameValuePairs.add(new BasicNameValuePair(AppConstants.decryption_key, AppConstants.decryption_key_value));
        nameValuePairs.add(new BasicNameValuePair(AppConstants.ivr_key, AppConstants.ivr_id_value));
        nameValuePairs.add(new BasicNameValuePair(AppConstants.phone_book_key, AppConstants.phone_book_value));


        return nameValuePairs;
    }
}
