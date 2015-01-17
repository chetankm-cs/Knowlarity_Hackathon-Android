package com.api_hackathon.app.network.requestDTO;

/**
 * Created by USER on 17-01-2015.
 */
public class deallocateNumberRequestDTO {

    private String username;
    private String password;
    private String domain;
    private String ivr_id;
    private String display_value;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getIvr_id() {
        return ivr_id;
    }

    public void setIvr_id(String ivr_id) {
        this.ivr_id = ivr_id;
    }

    public String getDisplay_value() {
        return display_value;
    }

    public void setDisplay_value(String display_value) {
        this.display_value = display_value;
    }
}
