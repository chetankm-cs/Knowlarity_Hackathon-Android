package com.api_hackathon.app.network.requestDTO;

/**
 * Created by USER on 17-01-2015.
 */
public class getOrderDetailsRequestDTO {
    private String decryption_key;
    private String order_id;
    private String page_no;

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

    public String getPage_no() {
        return page_no;
    }

    public void setPage_no(String page_no) {
        this.page_no = page_no;
    }
}
