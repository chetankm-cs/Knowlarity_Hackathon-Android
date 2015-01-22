package com.api_hackathon.app.callback;

/**
 * Created by USER on 18-01-2015.
 */
public interface Config {

        // used to share GCM regId with application server - using php app server
        static final String APP_SERVER_URL = "http://whispering-reaches-1551.herokuapp.com/register/";

        // GCM server using java
        // static final String APP_SERVER_URL =
        // "http://192.168.1.17:8080/GCM-App-Server/GCMNotification?shareRegId=1";

        // Google Project Number
        static final String GOOGLE_PROJECT_ID = "843021130536";
        static final String MESSAGE_KEY = "message";

}
