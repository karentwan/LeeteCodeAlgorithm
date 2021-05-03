package cn.karent.leetcode_v3;

import java.util.*;

/********************************************
 * description: 青蛙过河
 * @author wan
 * @date 2021.04.29
 ********************************************/
public class LeetCode403 {

/*    private Map<String, Boolean> memo = new HashMap<>();

    private boolean dfs(int[] stones, int idx, int k, Map<Integer, Integer> map) {
        if( idx >= stones.length-1) return true;
        int next = 0;
        String key = idx + "-" + k;
        if( memo.getOrDefault(key, null) != null)
            return memo.get(key);
        for (int i = k-1; i <= k+1; i++) {
            if( i >= 1 && (next = map.getOrDefault(stones[idx] + i, -1)) != -1
            && dfs(stones, next, i, map)) {
                memo.put(key, true);
                return true;
            }
        }
        memo.put(key, false);
        return false;
    }

    public boolean canCross(int[] stones) {
        if( stones.length < 2) return true;
        if( stones[0] + 1 < stones[1]) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], i);
        }
        return dfs(stones, 1, 1, map);
    }
   */

    // 动态规划解法
    public boolean canCross(int[] stones) {
        if( stones.length == 0) return true;
        boolean[][] dp = new boolean[stones.length][stones.length];
        dp[0][0] = dp[0][1] = true;
        for (int i = 1; i < stones.length; i++) {
            for (int j = 0; j < i; j++) {
                int k = stones[i] - stones[j];
                if( k < stones.length-1) {
                    dp[i][k] = dp[j][k-1] || dp[j][k] || dp[j][k+1];
                }
            }
        }
        for (int i = 0; i < stones.length; i++) {
            if(dp[stones.length-1][i]) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode403 lc = new LeetCode403();
//        int[] stones = {0, 1, 3, 5, 6, 8, 12, 17};
        int[] stones = {0,1,2,3,4,8,9,11};
//        int[] stones = {0,1,3,4,5,7,9,10,12};
//        int[] stones = {0,1,3,6,7};
//        int[] stones = {0,1,3,6,10,15,16,21};
        boolean ret = lc.canCross(stones);
        System.out.println(ret);
    }

}
