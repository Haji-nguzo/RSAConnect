package com.example.rsaconnect;

public class MainModel {
    private String name, imageUrl, location;

    public MainModel() {
    }

    public MainModel(String name, String imageUrl, String location) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

