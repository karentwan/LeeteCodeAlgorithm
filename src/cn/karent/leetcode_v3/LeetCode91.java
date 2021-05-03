package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 解码方法
 * @author wan
 * @date 2021.04.20
 */
public class LeetCode91 {

    public int numDecodings(String s) {
        if( s.length() == 0) return 0;
        int[] dp = new int[s.length()+1];
        char[] chs = s.toCharArray();
        int t = 0;
        dp[1] = chs[0] == '0' ? 0 : 1;
        for (int i = 2; i < chs.length+1; i++) {
            if( chs[i-1] >= '1') dp[i] = dp[i-1];
            if( (t = (chs[i-2] - '0') * 10 + (chs[i-1] - '0')) >= 10 && t <= 26 )
                dp[i] += i-2 == 0 ? 1 : dp[i-2];
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        LeetCode91 lc = new LeetCode91();
//        String s = "12";
//        String s = "226";
//        String s = "06";
        String s = "10011";
        int ret = lc.numDecodings(s);
        System.out.println(ret);
    }

}
