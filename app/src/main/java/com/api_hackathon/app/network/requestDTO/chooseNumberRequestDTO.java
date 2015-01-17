package com.api_hackathon.app.network.requestDTO;

/**
 * Created by USER on 17-01-2015.
 */
public class chooseNumberRequestDTO {
    private String decryption_key;
    private String circle_code;
    private String rtype;
    private String number_type;
    private String regex;

    public String getDecryption_key() {
        return decryption_key;
    }

    public void setDecryption_key(String decryption_key) {
        this.decryption_key = decryption_key;
    }

    public String getCircle_code() {
        return circle_code;
    }

    public void setCircle_code(String circle_code) {
        this.circle_code = circle_code;
    }

    public String getRtype() {
        return rtype;
    }

    public void setRtype(String rtype) {
        this.rtype = rtype;
    }

    public String getNumber_type() {
        return number_type;
    }

    public void setNumber_type(String number_type) {
        this.number_type = number_type;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }
}
