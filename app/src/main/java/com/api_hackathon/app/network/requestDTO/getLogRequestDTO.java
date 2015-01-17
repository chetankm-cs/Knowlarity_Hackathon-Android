package com.api_hackathon.app.network.requestDTO;

/**
 * Created by USER on 17-01-2015.
 */
public class getLogRequestDTO {
    private String decryption_key;
    private String call_id;

    public String getDecryption_key() {
        return decryption_key;
    }

    public void setDecryption_key(String decryption_key) {
        this.decryption_key = decryption_key;
    }

    public String getCall_id() {
        return call_id;
    }

    public void setCall_id(String call_id) {
        this.call_id = call_id;
    }
}
