package com.api_hackathon.app.network.requestDTO;

/**
 * Created by USER on 17-01-2015.
 */
public class quickCallsRequestDTO {

    private String decryption_key;
    private String session_unique_key;
    private String ivr_id;
    private String phone_book;
    private String times_try;
    private String retry_time;
    private String caller_id;
    private String is_transactional;

    public String getDecryption_key() {
        return decryption_key;
    }

    public void setDecryption_key(String decryption_key) {
        this.decryption_key = decryption_key;
    }

    public String getSession_unique_key() {
        return session_unique_key;
    }

    public void setSession_unique_key(String session_unique_key) {
        this.session_unique_key = session_unique_key;
    }

    public String getIvr_id() {
        return ivr_id;
    }

    public void setIvr_id(String ivr_id) {
        this.ivr_id = ivr_id;
    }

    public String getTimes_try() {
        return times_try;
    }

    public void setTimes_try(String times_try) {
        this.times_try = times_try;
    }

    public String getRetry_time() {
        return retry_time;
    }

    public void setRetry_time(String retry_time) {
        this.retry_time = retry_time;
    }

    public String getCaller_id() {
        return caller_id;
    }

    public void setCaller_id(String caller_id) {
        this.caller_id = caller_id;
    }

    public String getIs_transactional() {
        return is_transactional;
    }

    public void setIs_transactional(String is_transactional) {
        this.is_transactional = is_transactional;
    }

    public String getPhone_book() {
        return phone_book;
    }

    public void setPhone_book(String phone_book) {
        this.phone_book = phone_book;
    }
}
