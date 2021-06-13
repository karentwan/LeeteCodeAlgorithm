package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 数位成本和为目标值的最大数字
 * @author wan
 * @date 2021.06.12
 ********************************************/
public class LeetCode1449 {
/*
    private Map<String, String> memo = new HashMap<>();

    private String max(String s1, String s2) {
        if( s1 == null) return s2;
        if( s2 == null) return s1;
        if( s1.length() < s2.length()) return s2;
        else if( s1.length() > s2.length()) return s1;
        if(s1.compareTo(s2) < 0) return s2;
        return s1;
    }

    private String dfs(int[] cost, StringBuilder sb, int target) {
        if( target == 0) return sb.toString();
        String ret = null;
        String key = sb.toString() + target;
        if( memo.containsKey(key)) return memo.get(key);
        for (int i = 0; i < cost.length; i++) {
            int c = cost[i];
            if( target - c < 0) continue;
            int len = sb.length();
            sb.append(i+1);
            ret = max(ret, dfs(cost, sb, target - c));
            sb.delete(len, sb.length());
        }
        memo.put(key, ret);
        return ret;
    }
    // 超时
    public String largestNumber(int[] cost, int target) {
        String ret = dfs(cost, new StringBuilder(), target);
        return ret == null ? "0" : ret;
    }
    */

    // 完全背包问题
    public String largestNumber(int[] cost, int target) {
        int n = cost.length;
        int[] dp = new int[target+1];
        Arrays.fill(dp, Integer.MIN_VALUE / 2);
        dp[0] = 0;
        for (int i = 1; i <= 9; i++) {
            int c = cost[i-1];
            for (int j = c; j <= target; j++) {
                if( j >= c) dp[j] = Math.max(dp[j], dp[j-c]+1);
            }
        }
        if( dp[target] < 0) return "0";
        StringBuilder ret = new StringBuilder();
        for (int i = 9, j = target; i >= 1; i--) {
            int c = cost[i-1];
            while (j >= c && dp[j] == dp[j-c]+1) {
                j -= c;
                ret.append(i);
            }
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        LeetCode1449 lc = new LeetCode1449();
        int[] cost = {4, 3, 2, 5, 6, 7, 2, 5, 5};
        int target = 9;
//        int[] cost = {7,6,5,5,5,6,8,7,8};
//        int target = 12;
        String ret = lc.largestNumber(cost, target);
        System.out.println(ret);
    }

}
