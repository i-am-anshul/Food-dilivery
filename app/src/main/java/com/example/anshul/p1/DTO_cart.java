package com.example.anshul.p1;

/**
 * Created by Anshul on 1/22/2018.
 */

public class DTO_cart {
    private String name,img,price;
    int qty;
    public DTO_cart(){

    }

    public DTO_cart(String name, String img, String price, int qty) {
        this.name = name;
        this.img = img;
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
