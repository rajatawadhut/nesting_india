package com.nesting_india_property.property.Models;


public class DescriptionDataModel {

    String id, status, description;

    public DescriptionDataModel(String id, String status, String description) {
        this.id = id;
        this.status = status;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }
}