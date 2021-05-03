package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 检查数组对是否可以被k整除
 * @author wan
 * @date 2021.04.17
 */
public class LeetCode1497 {

    public boolean canArrange(int[] arr, int k) {
        int n = arr.length;
        if( n == 0) return true;
        if( n == 1 ) return false;
        int[] cache = new int[k+1];
        for (int i = 0; i < arr.length; i++) {
            cache[(arr[i] % k + k) % k]++;
        }
        for (int i = 1; i + i < k; i++) {
            if( cache[i] != cache[k-i]) return false;
        }
        return cache[0] % 2 == 0;
    }

    public static void main(String[] args) {
        LeetCode1497 lc = new LeetCode1497();
        int[] arr = {1,2,3,4,5,10,6,7,8,9};
        int k = 5;
//        int[] arr = {1,2,3,4,5,6};
//        int k = 7;
//        int[] arr = {1,2,3,4,5,6};
//        int k = 10;
//        int[] arr = {-10,10};
//        int k = 2;
//        int[] arr = {-1,1,-2,2,-3,3,-4,4};
//        int k = 3;
//        int[] arr = {-4,-7,5,2,9,1,10,4,-8,-3};
//        int k = 3;
        boolean ret = lc.canArrange(arr, k);
        System.out.println(ret);
    }

}
