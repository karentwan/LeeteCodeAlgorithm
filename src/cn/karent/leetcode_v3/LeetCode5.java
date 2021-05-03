package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 最长回文子串
 * @author wan
 * @date 2021.04.09
 */
public class LeetCode5 {

    private String pad(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append('#');
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i) + "#");
        }
        return sb.toString();
    }

    /**
     * 马拉车算法
     * @param s 要匹配的最长字符串长度
     * @return 匹配成功的字符串
     */
    public String longestPalindrome(String s) {
        String str = pad(s);
        int r = 0, c = 0;
        int[] md = new int[str.length()];
        int ret = 0;
        int max = 0;
        for (int i = 1; i < str.length(); i++) {
            md[i] = r > i ? Math.min(md[2 * c - i], r - i) : 1;
            while ( i + md[i] < str.length() && i - md[i] >= 0
                    && str.charAt(i + md[i]) == str.charAt(i - md[i])) {
                md[i]++;
            }
            if( i + md[i] - 1 > r) {
                r = i + md[i];
                c = i;
            }
            if( md[i] > max) {
                ret = i;
                max = md[i] - 1;
            }
        }
        int start = (ret - max) / 2;
        return s.substring(start, start + max);
    }

/*

    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        int ret = 0;
        int start = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                dp[i][j] = (i + 1 > j - 1 || dp[i+1][j-1]) && s.charAt(i) == s.charAt(j);
                if( dp[i][j] && j - i + 1 > ret )  {
                    ret = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + ret);
    }
*/

    public static void main(String[] args) {
        LeetCode5 lc = new LeetCode5();
        String s = "babad";
//        String s = "cbbd";
//        String s = "a";
        String ret = lc.longestPalindrome(s);
        System.out.println(ret);
    }

}
