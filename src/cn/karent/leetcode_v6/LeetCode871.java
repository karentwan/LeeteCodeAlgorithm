package cn.karent.leetcode_v6;

import java.util.*;

/******************************************
 * 最低加油次数
 * @author wan
 * @date 2022.07.02 10:52
 ******************************************/
public class LeetCode871 {
    // dp解法
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        if (n == 0) return startFuel >= target ? 0 : -1;
        int[][] tmp = new int[n+2][2];
        tmp[0][1] = startFuel;
        for (int i = 1; i < n+1; i++) {
            tmp[i][0] = stations[i-1][0];
            tmp[i][1] = stations[i-1][1];
        }
        tmp[n+1][0] = target;
        tmp[n+1][1] = 0;
        final int INF = Integer.MIN_VALUE / 2;
        // dp(i, j)表示从出发点到第i个加油站中间经停j次所剩余的最大加油量
        // 状态转移方程为: dp(i, j) = max_i
        int[][] dp = new int[n+2][n+2];
        // 第一列
        for (int i = 1; i < n + 2; i++) {
            dp[i][0] = INF;
        }
        dp[0][0] = startFuel;
        for (int i = 1; i < n+2; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = INF;
                for (int k = j-1; k < i; k++) {
                    if (dp[k][j-1] + tmp[k][0] >= tmp[i][0]) {
                        dp[i][j] = Math.max(dp[i][j], dp[k][j-1] - tmp[i][0] + tmp[k][0] + tmp[i][1]);
                    }
                }
            }
        }
        // 求最终的结果
        for (int i = 0; i < n + 2; i++) {
            if (dp[n+1][i] >= 0) {
                return i-1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        LeetCode871 lc = new LeetCode871();
//        int target = 1;
//        int startFuel = 1;
//        int[][] stations = new int[0][0];
//        int target = 100;
//        int startFuel = 1;
//        int[][] stations = {{10,100}};
//        int target = 100;
//        int startFuel = 1;
//        int[][] stations = new int[0][0];
//        int target = 100;
//        int startFuel = 10;
//        int[][] stations = {{10,60},{20,30},{30,30},{60,40}};
        int target = 1000;
        int startFuel = 299;
        int[][] stations = {{13,21},{26,115},{100,47},{225,99},{299,141},{444,198},{608,190},{636,157},{647,255},{841,123}};
        System.out.println(lc.minRefuelStops(target, startFuel, stations));
    }

}
