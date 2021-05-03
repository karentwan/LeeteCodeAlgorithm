package cn.karent.leetcode_v3;

import java.util.*;

/**
 * @author wan
 * @date 2021.04.11
 */
public class LeetCode1201 {

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private long lcm(long a, long b) {
        if( a < b) {
            long t = a;
            a = b;
            b = t;
        }
        return a * b / gcd(a, b);
    }

    public int nthUglyNumber(int n, int a, int b, int c) {
        long ab = lcm(a, b);
        long bc = lcm(b, c);
        long ac = lcm(a, c);
        long abc = lcm(ab, c);
        long l = 1, r = Math.min(a, Math.min(b, c)) * n;
        while (l < r) {
            long m = l + ( r - l) / 2;
            long cnt = m / a + m / b + m / c - m / ab - m / ac - m / bc + m / abc;
            if( cnt >= n) {
                r = m;
            } else {
                l = m+1;
            }
        }
        return ((int) l);
    }

    public static void main(String[] args) {
        LeetCode1201 lc = new LeetCode1201();
        int n = 3;
        int a = 2;
        int b = 3;
        int c = 5;
        int ret = lc.nthUglyNumber(n, a, b, c);
        System.out.println(ret);
    }

}
