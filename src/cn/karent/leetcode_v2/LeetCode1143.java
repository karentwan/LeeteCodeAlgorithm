package cn.karent.leetcode_v2;


/**
 * 最长公共子序列
 */
public class LeetCode1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[] dp = new int[n+1];
        for (int i = 1; i < m+1; i++) {
            int prev = 0, t = 0;
            for (int j = 1; j < n+1; j++) {
                t = dp[j];
                dp[j] = text1.charAt(i-1) == text2.charAt(j-1) ? prev + 1 : Math.max(dp[j], dp[j-1]);
                prev = t;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        LeetCode1143 lc = new LeetCode1143();
        String text1 = "abcde";
        String text2 = "ace";
        int ret = lc.longestCommonSubsequence(text1, text2);
        System.out.println(ret);
    }

}
