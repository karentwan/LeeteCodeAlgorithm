package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 到最近的人的最大距离
 * @author wan
 * @date 2021.05.11
 ********************************************/
public class LeetCode849 {

    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, Integer.MIN_VALUE/2);
        Arrays.fill(right, Integer.MAX_VALUE/2);
        int idx = Integer.MIN_VALUE/2;
        for (int i = 0; i < n; i++) {
            left[i] = idx;
            if( seats[i] == 1) idx = i;
        }
        idx = Integer.MAX_VALUE/2;
        for (int i = n-1; i >= 0; i--) {
            right[i] = idx;
            if( seats[i] == 1) idx = i;
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            if( seats[i] != 1) {
                ret = Math.max(ret, Math.min(i - left[i], right[i] - i));
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode849 lc = new LeetCode849();
//        int[] seats = {1, 0, 0, 0, 1, 0, 1};
//        int[] seats = {1,0,0,0};
        int[] seats = {};
        int ret = lc.maxDistToClosest(seats);
        System.out.println(ret);
    }

}
