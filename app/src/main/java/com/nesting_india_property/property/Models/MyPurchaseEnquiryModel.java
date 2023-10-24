package com.nesting_india_property.property.Models;

public class MyPurchaseEnquiryModel {

    String id;
    String userid;
    String minprice;
    String maxprice;
    String type;
    String category;
    String state;
    String city;
    String locality;
    String name;
    String email;
    String date;
    String time;
    String status;
    String propertylistfor;

    public MyPurchaseEnquiryModel(String id, String userid, String minprice, String maxprice, String type, String category, String state, String city, String locality, String name, String email, String date, String time, String status, String propertylistfor) {
        this.id = id;
        this.userid = userid;
        this.minprice = minprice;
        this.maxprice = maxprice;
        this.type = type;
        this.category = category;
        this.state = state;
        this.city = city;
        this.locality = locality;
        this.name = name;
        this.email = email;
        this.date = date;
        this.time = time;
        this.status = status;
        this.propertylistfor = propertylistfor;
    }

    public String getPropertylistfor() {
        return propertylistfor;
    }

    public String getId() {
        return id;
    }

    public String getUserid() {
        return userid;
    }

    public String getMinprice() {
        return minprice;
    }

    public String getMaxprice() {
        return maxprice;
    }

    public String getType() {
        return type;
    }

    public String getCategory() {
        return category;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getLocality() {
        return locality;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getStatus() {
        return status;
    }
}
