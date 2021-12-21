package com.example.up_to_timenews;

public class NewsModel {
    String title,author;

    public NewsModel(String title,  String author) {
        this.title = title;
      //  this.urlImage = urlImage;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

   /* public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }*/

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
