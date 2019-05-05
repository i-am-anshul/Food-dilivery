package com.example.anshul.p1;

/**
 * Created by Anshul on 1/19/2018.
 */

public class cont_rest2 {

    private String name,img,contents,date;
    int rating;
    public cont_rest2() {

    }



    public cont_rest2(String name, String img, String contents, String date, int rating) {
        this.name = name;
        this.img = img;
        this.contents = contents;
        this.date = date;
        this.rating = rating;


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

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
