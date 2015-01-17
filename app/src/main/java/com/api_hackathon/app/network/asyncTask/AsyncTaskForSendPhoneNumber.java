package com.api_hackathon.app.network.asyncTask;

import android.os.AsyncTask;
import com.api_hackathon.app.network.WebServicesConstants;
import com.api_hackathon.app.network.requestDTO.BloodRequest;
import com.api_hackathon.app.utils.HTTPJsonPost;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 17-01-2015.
 */
public class AsyncTaskForSendPhoneNumber extends AsyncTask<Void, Void, Void> {
    private static final String TAG = "AsyncTaskForCreateOrder";
    private BloodRequest bloodRequest;

    public AsyncTaskForSendPhoneNumber(BloodRequest bloodRequest) {
        this.bloodRequest = bloodRequest;
    }

    @Override
    protected Void doInBackground(Void... params) {
        HTTPJsonPost.postRequest(WebServicesConstants.serverURL + WebServicesConstants.snippets, generateRequest());
        return null;
    }


    private List<NameValuePair> generateRequest() {
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
        nameValuePairs.add(new BasicNameValuePair("phone_number", bloodRequest.getContactNumber()));
        nameValuePairs.add(new BasicNameValuePair("blood_group", bloodRequest.getBloodGroup()));
        nameValuePairs.add(new BasicNameValuePair("contact_list", bloodRequest.getContact_list()));
        return nameValuePairs;
    }
}
