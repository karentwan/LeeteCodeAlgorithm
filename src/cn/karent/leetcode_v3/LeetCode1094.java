package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 拼车
 * @author wan
 * @date 2021.04.15
 */
public class LeetCode1094 {

    public boolean carPooling(int[][] trips, int capacity) {
        int[] path = new int[1001];
        for (int[] trip : trips) {
            int s = trip[1];
            int e = trip[2];
            int n = trip[0];
            path[s] += n;
            path[e] -= n;
        }
        int n = 0;
        for (int i = 0; i < 1001; i++) {
            n += path[i];
            if( n > capacity) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode1094 lc = new LeetCode1094();
//        int[][] trips = {{2,1,5},{3,3,7}};
//        int capacity = 4;
//        int[][] trips = {{2,1,5},{3,3,7}};
//        int capacity = 5;
        int[][] trips = {{3,2,7},{3,7,9},{8,3,9}};
        int capacity = 11;
        boolean ret = lc.carPooling(trips, capacity);
        System.out.println(ret);
    }

}
