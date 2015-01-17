package com.api_hackathon.app.network.requestDTO;

/**
 * Created by USER on 17-01-2015.
 */
public class BloodRequest {
    private String contactNumber;
    private String bloodGroup;
    private String contact_list;

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getContact_list() {
        return contact_list;
    }

    public void setContact_list(String contact_list) {
        this.contact_list = contact_list;
    }
}
