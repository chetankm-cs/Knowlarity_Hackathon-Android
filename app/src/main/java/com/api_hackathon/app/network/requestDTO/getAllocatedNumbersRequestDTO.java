package com.api_hackathon.app.network.requestDTO;

/**
 * Created by USER on 17-01-2015.
 */
public class GetAllocatedNumbersRequestDTO {

    private String decryption_key;
    private String ivr_id;

    public String getDecryption_key() {
        return decryption_key;
    }

    public void setDecryption_key(String decryption_key) {
        this.decryption_key = decryption_key;
    }

    public String getIvr_id() {
        return ivr_id;
    }

    public void setIvr_id(String ivr_id) {
        this.ivr_id = ivr_id;
    }
}
