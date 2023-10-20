package com.nesting_india_property.property.Models;

public class LeadDataModel {

    String fullname;
    String email;
    String mobile;
    String city;
    String date;
    String time;
    String propertyid;
    String type;
    String category;
    String locality;
    String credit;
    String creditStatus;
    String leadStatus;
    String id;


    public LeadDataModel(String id,String fullname, String email, String mobile, String city, String date, String time, String propertyid, String type, String category, String locality, String credit, String creditStatus, String leadStatus){

        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.mobile = mobile;
        this.city = city;
        this.date = date;
        this.time = time;
        this.propertyid = propertyid;
        this.type = type;
        this.category = category;
        this.locality = locality;
        this.credit = credit;
        this.creditStatus = credit;
        this.leadStatus = leadStatus;


    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLeadStatus() {
        return leadStatus;
    }

    public void setLeadStatus(String leadStatus) {
        this.leadStatus = leadStatus;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getCreditStatus() {
        return creditStatus;
    }

    public void setCreditStatus(String creditStatus) {
        this.creditStatus = creditStatus;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPropertyid() {
        return propertyid;
    }

    public void setPropertyid(String propertyid) {
        this.propertyid = propertyid;
    }
}