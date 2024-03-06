package com.example.ubsapp;

public class Users {

    private String name;
    private String details;
    private Integer image;


    public Users(String name, String details, Integer image) {
        this.name = name;
        this.details = details;
        this.image = image;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }


}
