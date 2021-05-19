package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 航班预订统计
 * @author wan
 * @date 2021.05.19
 ********************************************/
public class LeetCode1109 {
/*
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] rets = new int[n];
        for (int[] booking : bookings) {
            for (int i = booking[0]-1; i < booking[1]; i++) {
                rets[i] += booking[2];
            }
        }
        return rets;
    }
    */

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] rets = new int[n];
        for (int[] booking : bookings) {
            rets[booking[0]-1] += booking[2];
            if( booking[1] < n) rets[booking[1]] -= booking[2];
        }
        for (int i = 1; i < n; i++) {
            rets[i] += rets[i-1];
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode1109 lc = new LeetCode1109();
        int[][] arr = {{1,2,10},{2,3,20},{2,5,25}};
        int n = 5;
        int[] rets = lc.corpFlightBookings(arr, n);
        for (int ret : rets) {
            System.out.print(ret + " ");
        }

    }

}
