package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 一和零
 * @author wan
 * @date 2021.06.06
 ********************************************/
public class LeetCode474 {

    private int countZeros(String s) {
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            if( s.charAt(i) == '0') ret++;
        }
        return ret;
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len][m+1][n+1];
        if( len == 0) return 0;
        int zeros = countZeros(strs[0]);
        int ones = strs[0].length() - zeros;
        if( zeros <= m && ones <= n)
            dp[0][zeros][ones] = 1;
        for (int i = 1; i < len; i++) {
            zeros = countZeros(strs[i]);
            ones = strs[i].length() - zeros;
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if( zeros <= j && ones <= k) {
                        dp[i][j][k] = Math.max(dp[i-1][j][k], dp[i-1][j - zeros][k - ones] + 1);
                    } else dp[i][j][k] = dp[i-1][j][k];
                }
            }
        }
        int ret = 0;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                ret = Math.max(ret, dp[len-1][i][j]);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode474 lc = new LeetCode474();
//        String[] strs = {"10", "0001", "111001", "1", "0"};
//        int m = 5;
//        int n = 3;
//        String[] strs = {"10", "0", "1"};
//        int m = 1;
//        int n = 1;
//        String[] strs = {"00", "000"};
//        int m = 1;
//        int n = 10;
        String[] strs = {"10","0001","111001","1","0"};
        int m = 3;
        int n = 4;
        int ret = lc.findMaxForm(strs, m, n);
        System.out.println(ret);
    }

}
