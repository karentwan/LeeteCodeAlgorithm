package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 买卖股票的最佳时机 三
 * @author wan
 * @date 2022.08.27 10:05
 ******************************************/
public class LeetCode123 {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int[][] dp = new int[2][2];  // 两次交易
        dp[0][0] = -prices[0];
        dp[0][1] = dp[1][0] = dp[1][1] = Integer.MIN_VALUE / 2;
        for (int i = 1; i < prices.length; i++) {
            dp[1][1] = Math.max(dp[1][1], dp[1][0] + prices[i]);
            dp[1][0] = Math.max(dp[1][0], dp[0][1] - prices[i]);
            dp[0][1] = Math.max(dp[0][1], prices[i] + dp[0][0]);
            dp[0][0] = Math.max(dp[0][0], -prices[i]);
        }
        return Math.max(0, Math.max(dp[0][1], dp[1][1]));
    }

    public static void main(String[] args) {
        LeetCode123 lc = new LeetCode123();
//        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
//        int[] prices = {1,2,3,4,5};
        int[] prices = {7,6,4,3,1};
        System.out.println(lc.maxProfit(prices));
    }

}
