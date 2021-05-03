package cn.karent.leetcode_v3;

import cn.karent.leetcode_v2.Offer45;

import java.util.*;

/********************************************
 * description: 把数字翻译成字符串
 * @author wan
 * @date 2021.04.22
 ********************************************/
public class Offer46 {

    public int translateNum(int num) {
        String s = String.valueOf(num);
        int n = s.length();
        char[] chs = s.toCharArray();
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        int t = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1];
            if((t = (chs[i-2] - '0') * 10 + (chs[i-1] - '0')) >= 10 && t < 26)
                dp[i] += dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Offer46 lc = new Offer46();
        int n = 12258;
//        int n = 0;
        int ret = lc.translateNum(n);
        System.out.println(ret);
    }

}
