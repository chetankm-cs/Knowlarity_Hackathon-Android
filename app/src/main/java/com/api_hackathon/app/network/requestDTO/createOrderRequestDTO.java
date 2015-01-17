package com.api_hackathon.app.network.requestDTO;

/**
 * Created by USER on 17-01-2015.
 */
public class CreateOrderRequestDTO {
    private String decryption_key;
    private String ivr_id;
    private String end_time;
    private String start_time;
    private String retry_time;
    private String num_tries;
    private String priority;
    private String call_start_time;
    private String call_stop_time;
    private String skip_days;
    private String is_transaction;

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

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getRetry_time() {
        return retry_time;
    }

    public void setRetry_time(String retry_time) {
        this.retry_time = retry_time;
    }

    public String getNum_tries() {
        return num_tries;
    }

    public void setNum_tries(String num_tries) {
        this.num_tries = num_tries;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getCall_start_time() {
        return call_start_time;
    }

    public void setCall_start_time(String call_start_time) {
        this.call_start_time = call_start_time;
    }

    public String getCall_stop_time() {
        return call_stop_time;
    }

    public void setCall_stop_time(String call_stop_time) {
        this.call_stop_time = call_stop_time;
    }

    public String getSkip_days() {
        return skip_days;
    }

    public void setSkip_days(String skip_days) {
        this.skip_days = skip_days;
    }

    public String getIs_transaction() {
        return is_transaction;
    }

    public void setIs_transaction(String is_transaction) {
        this.is_transaction = is_transaction;
    }
}
