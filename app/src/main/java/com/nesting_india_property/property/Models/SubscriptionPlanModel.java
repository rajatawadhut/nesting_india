package com.nesting_india_property.property.Models;


public class SubscriptionPlanModel {

    String id, subscription_title, subscription_price, subscription_duration, subscription_description, subscription_offer, subscription_type, status, subscription_credit;

    public SubscriptionPlanModel(String id, String subscription_title, String subscription_price, String subscription_duration, String subscription_description, String subscription_offer, String subscription_type, String status, String subscription_credit) {
        this.id = id;
        this.subscription_title = subscription_title;
        this.subscription_price = subscription_price;
        this.subscription_duration = subscription_duration;
        this.subscription_description = subscription_description;
        this.subscription_offer = subscription_offer;
        this.subscription_type = subscription_type;
        this.status = status;
        this.subscription_credit = subscription_credit;
    }

    public String getId() {
        return id;
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

    public String getStatus() {
        return status;
    }

    public String getSubscription_credit() {
        return subscription_credit;
    }
}