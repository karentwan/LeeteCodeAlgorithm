package cn.karent.leetcode_v6;

import java.util.*;

/***********************************************
 * description: H指数
 * @author wan
 * @date 2021.07.11
 ***********************************************/
public class LeetCode274 {

    public int hIndex(int[] citations) {
        Integer[] tmps = new Integer[citations.length];
        for (int i = 0; i < citations.length; i++) {
            tmps[i] = citations[i];
        }
        Arrays.sort(tmps, (k1, k2)->k2 - k1);
        int idx = search(tmps);
        return idx+1;
    }

/*
  6 5 3 1 0
  0 1 2 3 4
 */
    private int search(Integer[] tmps) {
        int l = 0, r = tmps.length-1;
        while (l <= r) {
            int m = l + (r - l)/2;
            if( tmps[m] < (m+1)) r = m-1;
            else l = m+1;
        }
        return r;
    }

    public static void main(String[] args) {
        LeetCode274 lc = new LeetCode274();
        int[] arr = {3, 0, 6, 1, 5};
        int ret = lc.hIndex(arr);
        System.out.println(ret);
    }

}
