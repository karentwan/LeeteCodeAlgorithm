package cn.karent.leetcode_v6;

import java.util.*;

/***********************************************
 * description: H指数 二
 * @author wan
 * @date 2021.07.12
 ***********************************************/
public class LeetCode275 {

    public int hIndex(int[] citations) {
        int n = citations.length;
        int l = 0, r = n-1;
        while (l <= r) {
            int m = l + (r-l)/2;
            if( citations[m] >= n - m)
                r = m-1;
            else l = m+1;
        }
        return n - l;
    }

    public static void main(String[] args) {

    }

}
