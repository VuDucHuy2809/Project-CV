package com.example.thanhnguyen.model;

import android.graphics.Bitmap;

import java.io.Serializable;

public class Currency implements Serializable{
    private String type;
    private String image_url;
    private Bitmap bitmap;
    private String price;

    public Currency(String type, String image_url, Bitmap bitmap, String price) {
        this.type = type;
        this.image_url = image_url;
        this.bitmap = bitmap;
        this.price = price;
    }

    public Currency() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
