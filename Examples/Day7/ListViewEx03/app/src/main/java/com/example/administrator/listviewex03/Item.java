package com.example.administrator.listviewex03;

/**
 * Created by Administrator on 2017-02-04.
 */

public class Item {
    private int imageID;
    private String title;
    private String content;

    public Item() {
    }

    public Item(int imageID, String title, String content) {
        this.imageID = imageID;
        this.title = title;
        this.content = content;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Item{" +
                "imageID=" + imageID +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
