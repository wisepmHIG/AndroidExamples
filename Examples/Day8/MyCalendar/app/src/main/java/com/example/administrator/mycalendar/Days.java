package com.example.administrator.mycalendar;

/**
 * Created by Administrator on 2016-12-02.
 */

public class Days {
    String day;

    public Days() {
    }

    public Days(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "Days{" +
                "day='" + day + '\'' +
                '}';
    }
}
