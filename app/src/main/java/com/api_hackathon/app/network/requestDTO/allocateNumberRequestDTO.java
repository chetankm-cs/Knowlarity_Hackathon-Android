package com.api_hackathon.app.network.requestDTO;

/**
 * Created by USER on 17-01-2015.
 */
public class allocateNumberRequestDTO {

    private String username;
    private String password;
    private String domain;
    private String plan_id;
    private String choosen_number;
    private String grace_days;
    private String rtype;

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

    public String getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(String plan_id) {
        this.plan_id = plan_id;
    }

    public String getChoosen_number() {
        return choosen_number;
    }

    public void setChoosen_number(String choosen_number) {
        this.choosen_number = choosen_number;
    }

    public String getGrace_days() {
        return grace_days;
    }

    public void setGrace_days(String grace_days) {
        this.grace_days = grace_days;
    }

    public String getRtype() {
        return rtype;
    }

    public void setRtype(String rtype) {
        this.rtype = rtype;
    }
}
