package cn.karent.leetcode_v3;

import java.util.*;

/********************************************
 * description: 在D天内送达包裹的能力
 * @author wan
 * @date 2021.04.26
 ********************************************/
public class LeetCode1011 {

    private boolean finish(int[] weights, int m, int D) {
        int ret = 0;
        int wnd = 0;
        for (int weight : weights) {
            if( weight > m) return false;
            else if( wnd + weight > m) {
                wnd = weight;
                ret++;
            } else wnd += weight;
        }
        return ret + 1 <= D;
    }

    public int shipWithinDays(int[] weights, int D) {
        int sum = 0;
        for (int weight : weights) {
            sum += weight;
        }
        int l = 1, r = sum;
        while (l < r) {
            int m = l + (r - l)/2;
            if( finish(weights, m, D) ) r = m;
            else l = m+1;
        }
        return l;
    }

    public static void main(String[] args) {
        LeetCode1011 lc = new LeetCode1011();
//        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        int D = 5;
        int[] weights = {3,2,2,4,1,4};
        int D = 3;
        int ret = lc.shipWithinDays(weights, D);
        System.out.println(ret);
    }

}
