package com.example.administrator.newsapp;

/**
 * Created by Administrator on 2017-02-19.
 <item>
     <title></title>
     <link></link>
     <description></description>
     <author></author>
     <guid>20170217000209</guid>
     <comments>http://www.etnews.com/20170217000209#comments</comments>
     <pubDate>Sun, 19 Feb 2017 15:00:00 +0900</pubDate>
 </item>
 */
public class NewsItem {
    private String title;
    private String link;
    private String description;
    private String author;
    private String guid;
    private String comments;
    private String pubDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }
}
