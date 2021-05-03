package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 不含连续1的非负整数
 * @author wan
 * @date 2021.05.03
 ********************************************/
public class LeetCode600 {

    public int findIntegers(int n) {
        int[] dp = new int[32];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        int ret = 0, prev = 0, i = 30;
        while (i >= 0) {
            if( (n & (1 << i)) != 0) {
                ret += dp[i];
                if( prev == 1) {
                    ret--;
                    break;
                }
                prev = 1;
            } else prev = 0;
            i--;
        }
        return ret + 1;
    }

    public static void main(String[] args) {
        LeetCode600 lc = new LeetCode600();
        int n = 5;
        int ret = lc.findIntegers(n);
        System.out.println(ret);
    }

}
