package com.nesting_india_property.property.Models;

public class UserDataModel {


        public String id;
        public String fname;
        public String lname;
        public String mobile;
        public String email;
        public String address;
        public String city;
        public String state;
        public String time;
        public String date;
        public String status;
        public String usercategory;
        public String profilepic;

    public UserDataModel(String id, String fname, String lname, String mobile, String email, String address, String city, String state, String time, String date, String status, String usercategory, String profilepic) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
        this.city = city;
        this.state = state;
        this.time = time;
        this.date = date;
        this.status = status;
        this.usercategory = usercategory;
        this.profilepic = profilepic;
    }

    public String getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public String getUsercategory() {
        return usercategory;
    }

    public String getProfilepic() {
        return profilepic;
    }
}
