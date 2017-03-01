package com.example.administrator.mycalendar;

/**
 * Created by Administrator on 2016-12-02.
 */

public class CalUtil {
    // 윤년을 판단하는 메서드
    // 년도가 400의 배수이면 윤년이다.
    // 년도가 4의 배수이면서 100의 배수가 아니면 윤년이다.
    public static boolean isLeapYear(int year){
        return (year%400==0 || year%4==0 && year%100!=0);
    }
    // 월의 마지막 날짜를 리턴하는 메서드
    public static int getLastDay(int year,int month){
        int[] m = {31,28,31,30,31,30,31,31,30,31,30,31};
        m[1] = isLeapYear(year) ? 29 : 28;
        return m[month-1];
    }
    // 1년 1월 1일부터의 총일수를 구하는 메서드
    public static int getDays(int year,int month,int date){
        int sum = (year-1)*365 + (year/4) - (year/100) + (year/400);
        for(int i=1;i<month;i++) sum += getLastDay(year,i);
        return  sum + date;
    }
    // 요일을 구하는 메서드
    public static int getWeek(int year,int month,int date){ return getDays(year,month,date)%7+1;}
}
