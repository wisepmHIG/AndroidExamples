package com.example.administrator.newsapp2;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Administrator on 2016-10-15.
 <channel>
 <title>오마이뉴스 - 전체기사</title>
 <link>http://www.ohmynews.com/</link>
 <language/>
 <description/>
 <copyright>Copyright (c) OhmyNews.com All rights reserved</copyright>
 <lastBuildDate>2016-10-16T09:40:02+09:00</lastBuildDate>
 <item>...</item>
 */
@Root
public class Channel {
    @Element
    private String title;
    @Element
    private String link;
    @Element(required = false)
    private String language;
    @Element(required = false)
    private String description;
    @Element
    private String copyright;
    @Element
    private String lastBuildDate;
    @ElementList(inline=true)
    private List<Item> item;

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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getLastBuildDate() {
        return lastBuildDate;
    }

    public void setLastBuildDate(String lastBuildDate) {
        this.lastBuildDate = lastBuildDate;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", language='" + language + '\'' +
                ", description='" + description + '\'' +
                ", copyright='" + copyright + '\'' +
                ", lastBuildDate='" + lastBuildDate + '\'' +
                ", item=" + item +
                '}';
    }
}
