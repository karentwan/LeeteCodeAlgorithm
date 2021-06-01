package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 你能在你最喜欢的那天吃到你最喜欢的糖果吗
 * @author wan
 * @date 2021.06.01
 ********************************************/
public class LeetCode1744 {

    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n = candiesCount.length;
        long[] preSum = new long[n+1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i-1] + candiesCount[i-1];
        }
        int m = queries.length;
        boolean[] rets = new boolean[m];
        for (int i = 0; i < m; i++) {
            int ft = queries[i][0];  // favoriteType
            int fd = queries[i][1] + 1;  // favoriteDay
            int dc = queries[i][2];  // dailyCap
            long a = preSum[ft] / dc + 1;  // 以最大速度吃, 最早吃到
            long b = preSum[ft+1];         // 以最慢速度吃, 最晚吃到
            rets[i] = a <= fd && b >= fd;
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode1744 lc = new LeetCode1744();
//        int[] candiesCount = {7, 4, 5, 3, 8};
//        int[][] queries = {{0,2,2},{4,2,4},{2,13,1000000000}};
        int[] candiesCount = {5,2,6,4,1};
        int[][] queries = {{3,1,2},{4,10,3},{3,10,100},{4,100,30},{1,3,1}};
        boolean[] rets = lc.canEat(candiesCount, queries);
        for (boolean ret : rets) {
            System.out.print(ret + " ");
        }
    }

}
