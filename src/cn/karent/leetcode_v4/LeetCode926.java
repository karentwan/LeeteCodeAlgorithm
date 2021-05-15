package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 将字符串翻转到单调递增
 * @author wan
 * @date 2021.05.15
 ********************************************/
public class LeetCode926 {

    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        if( n == 0) return 0;
        int[] dp = new int[2];
        char[] chs = s.toCharArray();
        if( chs[0] == '0') dp[1] = 1;
        else dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[1] = Math.min(dp[0], dp[1]) + (chs[i] == '1' ? 0 : 1);
            dp[0] = dp[0] + (chs[i] == '0' ? 0 : 1);
        }
        return Math.min(dp[0], dp[1]);
    }

    public static void main(String[] args) {
        LeetCode926 lc = new LeetCode926();
//        String s = "00110";
//        String s = "010110";
        String s = "00011000";
        int ret = lc.minFlipsMonoIncr(s);
        System.out.println(ret);
    }

}
