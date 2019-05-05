package com.example.anshul.p1;

/**
 * Created by Anshul on 1/18/2018.
 */

public class cont_rest {

    private String name,img,contents;
    int price;
    public cont_rest() {

    }



    public cont_rest(String name, String img, String contents, int price) {
        this.name = name;
        this.img = img;
        this.contents = contents;
        this.price = price;


    }

    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }

    public String getContents() {
        return contents;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
