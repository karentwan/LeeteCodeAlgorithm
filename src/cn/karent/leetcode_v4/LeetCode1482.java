package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 制作m束花所需的最少天数
 * @author wan
 * @date 2021.05.09
 ********************************************/
public class LeetCode1482 {

    public int minDays(int[] bloomDay, int m, int k) {
        if( bloomDay.length < m * k) return -1;
        int l = 0, r = 0;
        for (int item : bloomDay) {
            r = Math.max(r, item);
        }
        while (l < r) {
            int mid = l + (r - l)/2;
            if( count(bloomDay, mid, k) >= m) r = mid;
            else l = mid+1;
        }
        return l;
    }

    private int count(int[] bloomDay, int mid, int k) {
        int ret = 0, cnt = 0;
        for (int item : bloomDay) {
            if( item <= mid) {
                cnt++;
            } else cnt = 0;
            if( cnt == k) {
                ret++;
                cnt = 0;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1482 lc = new LeetCode1482();
//        int[] bloomDay = {1, 10, 3, 10, 2};
//        int m = 3;
//        int k = 1;
//        int[] bloomDay = {1,10,3,10,2};
//        int m = 2;
//        int k = 3;
        int[] bloomDay = {7,7,7,7,12,7,7};
        int m = 2;
        int k = 3;
        int ret = lc.minDays(bloomDay, m, k);
        System.out.println(ret);
    }

}
