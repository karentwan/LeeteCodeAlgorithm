package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 丑数
 * @author wan
 * @date 2021.04.10
 */
public class LeetCode263 {

    public boolean isUgly(int n) {
        while ( n > 0) {
            if( n % 2 == 0) {
                n /= 2;
            } else if( n % 3 == 0) {
                n /= 3;
            } else if( n % 5 == 0) {
                n /= 5;
            } else {
                break;
            }
        }
        return n == 1;
    }

    public static void main(String[] args) {
        LeetCode263 lc = new LeetCode263();
        int n = 14;
        boolean ret = lc.isUgly(n);
        System.out.println(ret);
    }

}
