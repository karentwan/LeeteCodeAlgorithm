package cn.karent.leetcode_v1;

/**
 * 分割回文串 二
 */
public class LeetCode132 {

    private boolean isPalindrome(String s, int start, int end) {
        while( start < end) {
            if( s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public int minCut(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 1; i < n; i++) {
            for (int j = i-1; j >= 0; j--) {
//                if( !isPalindrome(s, j, i)) {
//                    dp[j][i] = Integer.MAX_VALUE;
//                    for (int k = j; k < i; k++) {
//                        dp[j][i] = Math.min(dp[j][i], dp[j][k] + dp[k+1][i] + 1);
//                    }
//                }
                if( s.charAt(j) == s.charAt(i) && dp[j+1][i-1] == 0) {
                    continue;
                }
                dp[j][i] = Integer.MAX_VALUE;
                for (int k = j; k < i; k++) {
                    dp[j][i] = Math.min(dp[j][i], dp[j][k] + dp[k+1][i] + 1);
                }
            }
        }
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        LeetCode132 lc = new LeetCode132();
        String s = "aab";
//        String s = "ab";
        int ret = lc.minCut(s);
        System.out.println(ret);
    }

}
