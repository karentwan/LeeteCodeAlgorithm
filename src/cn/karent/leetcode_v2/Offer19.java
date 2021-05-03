package cn.karent.leetcode_v2;

import java.util.*;

/**
 * 正则表达式匹配
 * @author wan
 * @date 2021.04.08
 */
public class Offer19 {

    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            if( p.charAt(i-1) == '*') {
                dp[0][i] = dp[0][i-2];
            }
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if( p.charAt(j-1) == '.' || s.charAt(i-1) == p.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else if( p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i][j-1] || dp[i][j-2];
                    if( p.charAt(j-2) == '.' || p.charAt(j-2) == s.charAt(i-1)) {
                        dp[i][j] = dp[i][j] || dp[i-1][j];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        Offer19 lc = new Offer19();
//        String s = "aab";
//        String p = "c*a*b";
//        String s = "aa";
//        String p = "a";
        String s = "ab";
        String p = ".*";
//        String s = "mississippi";
//        String p = "mis*is*p*.";
//        String s = "aaa";
//        String p =  "ab*a*c*a";
        boolean ret = lc.isMatch(s, p);
        System.out.println(ret);
    }

}
