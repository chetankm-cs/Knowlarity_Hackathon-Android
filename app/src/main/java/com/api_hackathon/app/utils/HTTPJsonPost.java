package com.api_hackathon.app.utils;

import android.util.Log;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.util.Arrays;
import java.util.List;

public class HTTPJsonPost {

    private static final String TAG = HTTPJsonPost.class.getSimpleName();

    public static String getExactURL(String baseURL, String referenceURL) {

        // //DivaLog.d(Log_TAG, "THE FULL URL :" + mURL.toString());
        return baseURL + referenceURL;
    }

    public static String postData(String url, String bodyParams) {

        // Create a new HttpClient and Post Header

        HttpParams myParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(myParams, 30000);
        HttpProtocolParams.setVersion(myParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(myParams, HTTP.UTF_8);
        HttpConnectionParams.setSoTimeout(myParams, 30000);
        HttpClient httpclient = new DefaultHttpClient(myParams);
        String responseText;
        try {
            HttpPost httppost = new HttpPost(url);
            // httppost.setHeader("Content-type", "application/json");

            if (bodyParams != null) {

                StringEntity se = new StringEntity(bodyParams);
                // se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,
                // "application/json"));
                httppost.setEntity(se);
            }
            Log.d(TAG, url);
            Log.d(TAG, "Body params: " + bodyParams);
            HttpResponse response = httpclient.execute(httppost);
            responseText = EntityUtils.toString(response.getEntity());
            Log.d(TAG, "Response for " + url + ": " + responseText);

        } catch (Exception e) {

            Log.e(TAG, "Exception : " + e.getMessage() + " :StackTrace : " + Arrays.toString(e.getStackTrace()));
            responseText = null;
        }
        return responseText;
    }

    public static String getData(String url) {

        String responseText;
        try {
            HttpParams myParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(myParams, 30000);
            HttpProtocolParams.setVersion(myParams, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(myParams, HTTP.UTF_8);
            HttpConnectionParams.setSoTimeout(myParams, 30000);
            HttpClient httpclient = new DefaultHttpClient(myParams);

            HttpGet get = new HttpGet(url);

            // HttpClient client = new DefaultHttpClient();

            HttpResponse response = httpclient.execute(get);

            responseText = EntityUtils.toString(response.getEntity());
//			Log.w(TAG, url + ": " + responseText);

        } catch (Exception e) {

            Log.e(TAG, "Exception : " + e.getMessage() + " :StackTrace : " + Arrays.toString(e.getStackTrace()));
            responseText = null;
        }
        return responseText;
    }


    public static String postRequest(String url, List<NameValuePair> nameValuePairs) {
        try {
            HttpPost httppost = new HttpPost(url);
            HttpParams myParams = new BasicHttpParams();
            HttpClient httpclient = new DefaultHttpClient(myParams);
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse response = httpclient.execute(httppost);
            String responseText = EntityUtils.toString(response.getEntity());
            Log.d(TAG, "Response for " + url + ": " + responseText);
            return responseText;
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "Problem in postRequest");
            return null;
        }
    }
}
