package com.example.administrator.newsapp;

/**
 * Created by Administrator on 2017-02-19.
 */

public class ETNews {
    private String category;
    private String link;


    public ETNews(String category, String link) {
        this.category = category;
        this.link = link;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
