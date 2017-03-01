package com.example.administrator.newsapp2;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Administrator on 2016-10-15.
 <item>
 <author>손인식</author>
 <category>사는이야기</category>
 <title>
 <![CDATA[ [모이] 웨딩 촬영에 등장한 '개들러리' ]]>
 </title>
 <link>
 http://www.ohmynews.com/NWS_Web/View/at_pg.aspx?CNTN_CD=A0002251588
 </link>
 <pubDate>2016-10-15T14:35:10+09:00</pubDate>
 <description>
 <![CDATA[
 <DIV align=center><IMG id=IIE002035458 src="http://ojsfile.ohmynews.com/STD_IMG_FILE/2016/1015/IE002035458_STD.jpg" align=center></DIV><BR>
 <DIV align=center><IMG id=IIE002035459 src="http://ojsfile.ohmynews.com/STD_IMG_FILE/2016/1015/IE002035459_STD.jpg" align=center></DIV><BR>
 <DIV align=center>
 ]]>
 <![CDATA[
 <IMG id=IIE002035460 src="http://ojsfile.ohmynews.com/STD_IMG_FILE/2016/1015/IE002035460_STD.jpg" align=center></DIV>
 <P><BR>스페인의 수도 마드리드 인접한 고도로 유명한 톨레도입니다.<BR>톨레도 대성당 근처 자그마한 광장 한 쪽에 결혼기념 야외 촬영을 위해 예비부부가 나타났습니다.</P>
 <P><BR>건강한 애완견 두 마리와 함께요. 제대로 포즈를 취해주지 않는 개, 한동안 실랑이를 하더니 한 마리 개만 옆에 두고 뽀뽀를 합니다. 사진 담당은 열심히 촬영합니다.<BR></P>
 <P>둘만의 사랑을 개와 관광객들 그리고 멀리 날아온 이국의 나그네에게까지 두 사람의 사랑과 그리고 결혼을 널리 공표합니다.<BR><BR>부부가 정말 행복하기를~<!-- s:moiad --><BR><BR>▶ 해당 기사는 모바일 앱 모이(moi) 에서 작성되었습니다.<BR>▶ <A href="http://www.moi.so/Moi_Web/csCenter/moi_info.aspx" target="'_blank'">모이(moi)란?</A> 일상의 이야기를 쉽게 기사화 할 수 있는 SNS 입니다.<BR>▶ <A href="http://www.moi.so/" target="'_blank'">더 많은 모이 보러가기</A><!-- e:moiad --></P>
 ]]>
 </description>
 </item>
 */
@Root
public class Item {
    @Element
    private String author;
    @Element
    private String category;
    @Element
    private String title;
    @Element
    private String link;
    @Element
    private String pubDate;
    @Element
    private String description ;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

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

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Item{" +
                "author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", pubDate='" + pubDate + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
