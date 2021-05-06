package cn.karent.leetcode_v4;

import cn.karent.leetcode_v2.MyCircularDeque;

import java.util.*;

/********************************************
 * description: 我的日程安排表 一
 * @author wan
 * @date 2021.05.06
 ********************************************/
public class MyCalendar {

    private int[][] calender = new int[1001][2];

    private int n = 0;

    public MyCalendar() {

    }

    private int get(int target) {
        int l = 0, r = n;
        while ( l < r) {
            int m = l + (r-l)/2;
            if( calender[m][0] >= target) r = m;
            else l = m+1;
        }
        return l;
    }

    public boolean book(int start, int end) {
        int r = get(start);
        int l = r - 1;
        if( r < n) {
            if( r == 0) {
                if( end > calender[r][0]) return false;
            } else if( (start < calender[l][1] || end > calender[r][0]))
                return false;
        } else if( l >= 0 && start < calender[l][1]) return false;
        int i = n++;
        while ( i >= r) {
            calender[i+1] = calender[i];
            i--;
        }
        calender[i+1] = new int[]{start, end};
        return true;
    }

    public static void main(String[] args) {
//        test1();
        MyCalendar mc = new MyCalendar();
        System.out.println(mc.book(20, 29));
        System.out.println(mc.book(13, 22));
        System.out.println(mc.book(44, 50));
        System.out.println(mc.book(1, 7));
        System.out.println(mc.book(2, 10));
        System.out.println(mc.book(14, 20));
        System.out.println(mc.book(19, 25));
    }

    private static void test1() {
        MyCalendar mc = new MyCalendar();
        System.out.println(mc.book(10, 20));
        System.out.println(mc.book(15, 25));
        System.out.println(mc.book(20, 30));
        System.out.println(mc.book(50, 60));
        System.out.println(mc.book(30, 40));
        System.out.println(mc.book(40, 50));
    }

}
