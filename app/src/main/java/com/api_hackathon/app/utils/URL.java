package com.api_hackathon.app.utils;

import com.api_hackathon.app.network.WebServicesConstants;

/**
 * Created by chetan on 16-01-2015.
 */
public class URL {

    public static String getFullURL(String webServiceName){
        return WebServicesConstants.baseURL + webServiceName;
    }
}
