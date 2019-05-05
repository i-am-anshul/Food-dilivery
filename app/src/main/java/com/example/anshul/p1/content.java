package com.example.anshul.p1;

/**
 * Created by Anshul on 1/16/2018.
 */

public class content {

        private String name,address,img;

    public content() {
    }
    public content(String name,String address,String img)
    {
        this.name=name;
        this.address=address;
        this.img=img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
