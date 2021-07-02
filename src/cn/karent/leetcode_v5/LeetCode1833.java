package cn.karent.leetcode_v5;

import java.util.*;

/***********************************************
 * description: 雪糕的最大数量
 * @author wan
 * @date 2021.07.02
 ***********************************************/
public class LeetCode1833 {

    public int maxIceCream1(int[] costs, int coins) {
        int n = costs.length;
        int[][] dp = new int[n+1][coins+1];
        for (int i = 1; i <= n; i++) {
            int cost = costs[i-1];
            for (int j = 1; j <= coins; j++) {
                if( j >= cost) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-cost] + 1);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][coins];
    }

    public int maxIceCream(int[] costs, int coins) {
        int n = costs.length;
        Arrays.sort(costs);
        int ret = 0, cost = 0;
        for (int i = 0; i < n ; i++) {
            if( cost + costs[i] > coins) break;
            cost += costs[i];
            ret++;
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1833 lc = new LeetCode1833();
//        int[] costs = {1, 3, 2, 4, 1};
//        int coins = 7;
        int[] costs = {27,23,33,26,46,86,70,85,89,82,57,66,42,18,18,5,46,56,42,82,52,78,4,27,96,74,74,52,2,24,78,18,42,10,12,10,80,30,60,38,32,7,98,26,18,62,50,42,15,14,32,86,93,98,47,46,58,42,74,69,51,53,58,40,66,46,65,2,10,82,94,26,6,78,2,101,97,16,12,18,71,5,46,22,58,12,18,62,61,51,2,18,34,12,36,58,20,12,17,70};
        int coins = 241;
        int ret = lc.maxIceCream1(costs, coins);
        System.out.println(ret);
    }

}
