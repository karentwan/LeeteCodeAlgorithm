package cn.karent.leetcode_v2;

import java.util.*;

/**
 * 颠倒二进制位
 */
public class LeetCode190 {

    public int reverseBits(int n) {
        int t = 0;
        int cnt = 31;
        while ( n != 0) {
            if( ( n & 1) != 0) {
                t |= ( 1 << cnt);
            }
            cnt--;
            n >>>= 1;
        }
        return t;
    }

    public static void main(String[] args) {
        LeetCode190 lc = new LeetCode190();
//        int
    }

}
