package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 一周中的第几天
 * @author wan
 * @date 2021.05.27
 ********************************************/
public class LeetCode1185 {

    public String dayOfTheWeek(int day, int month, int year) {
        int[] months = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
        String[] week = {"Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};
        int cnt = 0;
        cnt += day - 1;
        cnt += months[month-1];
        if( year % 4 == 0 &&
                (year % 100 != 0 || year % 400 == 0)
                && month <= 2)
            cnt--;
        year -= 1971;  // 与1971相差多少年
        // year 是多少年, (year-1)/4 闰年的个数(要多一天)
        cnt += year + (year - 1)/4 + 1 - year / 129;
        if( year == 0) cnt--;
        return week[cnt % 7];
    }

    public static void main(String[] args) {
        LeetCode1185 lc = new LeetCode1185();
        int year = 2019;
        int month = 8;
        int day = 31;
        String ret = lc.dayOfTheWeek(day, month, year);
        System.out.println(ret);
    }

}
