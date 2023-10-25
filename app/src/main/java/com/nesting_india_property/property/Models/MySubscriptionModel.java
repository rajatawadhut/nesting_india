package com.nesting_india_property.property.Models;

public class MySubscriptionModel {

    public String subscription_title;
    public String subscription_price;
    public String subscription_duration;
    public String subscription_description;
    public String subscription_offer;
    public String subscription_type;
    public String subscription_credit;
    public String status;
    public String payment_status;
    public String credit;
    public String expiry_date;
    public String updated_at;
    public String error;
    public String message;
    public String payment_created_at;

    public MySubscriptionModel(String subscription_title, String subscription_price, String subscription_duration, String subscription_description, String subscription_offer, String subscription_type, String subscription_credit, String status, String payment_status, String credit, String expiry_date, String updated_at, String error, String message, String payment_created_at) {
        this.subscription_title = subscription_title;
        this.subscription_price = subscription_price;
        this.subscription_duration = subscription_duration;
        this.subscription_description = subscription_description;
        this.subscription_offer = subscription_offer;
        this.subscription_type = subscription_type;
        this.subscription_credit = subscription_credit;
        this.status = status;
        this.payment_status = payment_status;
        this.credit = credit;
        this.expiry_date = expiry_date;
        this.updated_at = updated_at;
        this.error = error;
        this.message = message;
        this.payment_created_at = payment_created_at;
    }

    public String getPayment_created_at() {
        return payment_created_at;
    }

    public String getSubscription_title() {
        return subscription_title;
    }

    public String getSubscription_price() {
        return subscription_price;
    }

    public String getSubscription_duration() {
        return subscription_duration;
    }

    public String getSubscription_description() {
        return subscription_description;
    }

    public String getSubscription_offer() {
        return subscription_offer;
    }

    public String getSubscription_type() {
        return subscription_type;
    }

    public String getSubscription_credit() {
        return subscription_credit;
    }

    public String getStatus() {
        return status;
    }

    public String getPayment_status() {
        return payment_status;
    }

    public String getCredit() {
        return credit;
    }

    public String getExpiry_date() {
        return expiry_date;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}
