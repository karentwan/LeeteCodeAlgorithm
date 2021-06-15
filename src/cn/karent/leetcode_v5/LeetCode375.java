package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 猜数字大小 二
 *  -- 求最小最大, 单次猜测要结果最差就表示求最大, 总体结果要最好就表示求最小
 * @author wan
 * @date 2021.06.15
 ********************************************/
public class LeetCode375 {

    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        for (int i = n; i >= 1; i--) {
            for (int j = i+1; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE / 2;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i][k-1], dp[k+1][j]) + k);
                }
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        LeetCode375 lc = new LeetCode375();
        int n = 10;
        int ret = lc.getMoneyAmount(n);
        System.out.println(ret);
    }

}
