package com.api_hackathon.app.network.requestDTO;

/**
 * Created by USER on 17-01-2015.
 */
public class AddCallsToOrderRequestDTO {

    private String decryption_key;
    private String order_id;
    private String phone_book;
    private String caller_id;

    public String getDecryption_key() {
        return decryption_key;
    }

    public void setDecryption_key(String decryption_key) {
        this.decryption_key = decryption_key;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getPhone_book() {
        return phone_book;
    }

    public void setPhone_book(String phone_book) {
        this.phone_book = phone_book;
    }

    public String getCaller_id() {
        return caller_id;
    }

    public void setCaller_id(String caller_id) {
        this.caller_id = caller_id;
    }
}
