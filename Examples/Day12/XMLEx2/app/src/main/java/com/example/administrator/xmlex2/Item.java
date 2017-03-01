package com.example.administrator.xmlex2;

/**
 * Created by Administrator on 2017-02-19.
 <item>
 <title>&lt;b&gt;java&lt;/b&gt; 인강 ☞ 자바 중급자 실력다지기 동영상 강좌</title>
 <link>http://blog.naver.com/beta700?Redirect=Log&amp;logNo=220938503453</link>
 <description>컴퓨터티쳐 컴티입니다:) 오늘 포스팅은 자바(&lt;b&gt;java&lt;/b&gt;) 중급자 실력다지기 동영상 강좌에 대한 리뷰입니다. &lt;b&gt;Java&lt;/b&gt;는 미국의 썬마이크로시스템사(Sun Microsystems)에서 만든 객체지향언어입니다. 기존의 대표적인... </description>
 <bloggername>컴퓨터티쳐 컴티</bloggername>
 <bloggerlink>http://blog.naver.com/beta700</bloggerlink>
 <postdate>20170218</postdate>
 </item>
 * */

public class Item {
    private String title;
    private String link;
    private String description;
    private String bloggername;
    private String bloggerlink;
    private String postdate;

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

    public String getBloggername() {
        return bloggername;
    }

    public void setBloggername(String bloggername) {
        this.bloggername = bloggername;
    }

    public String getBloggerlink() {
        return bloggerlink;
    }

    public void setBloggerlink(String bloggerlink) {
        this.bloggerlink = bloggerlink;
    }

    public String getPostdate() {
        return postdate;
    }

    public void setPostdate(String postdate) {
        this.postdate = postdate;
    }
}
