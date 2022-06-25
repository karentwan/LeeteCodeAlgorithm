package cn.karent.leetcode_v6;

/******************************************
 * 粉刷房子
 * @author wan
 * @date 2022.06.25 09:14
 ******************************************/
public class Offer091 {

    public int minCost(int[][] costs) {
        int size = costs.length;
        if (size == 0) return 0;
        int[][] dp = new int[size][3];  // 动态规划
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        for (int i = 1; i < size; i++) {
            int[] cost = costs[i];
            dp[i][0] = Math.min(dp[i-1][1] + cost[0], dp[i-1][2] + cost[0]);
            dp[i][1] = Math.min(dp[i-1][0] + cost[1], dp[i-1][2] + cost[1]);
            dp[i][2] = Math.min(dp[i-1][0] + cost[2], dp[i-1][1] + cost[2]);
        }
        return Math.min(dp[size -1][0], Math.min(dp[size-1][1], dp[size-1][2]));
    }

    public static void main(String[] args) {
        Offer091 lc = new Offer091();
        int[][] costs = {{17,2,17},{16,16,5},{14,3,19}};
        System.out.println(lc.minCost(costs));

    }

}
