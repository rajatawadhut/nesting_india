package com.nesting_india_property.property.Models;


public class AdsDataModel {

    String id, image, url;

    public AdsDataModel(String id, String image, String url) {
        this.id = id;
        this.image = image;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}