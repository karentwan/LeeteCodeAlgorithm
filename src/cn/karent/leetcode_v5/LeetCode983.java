package cn.karent.leetcode_v5;

import java.util.*;

/***********************************************
 * description: 最低票价
 * @author wan
 * @date 2021.06.22
 ***********************************************/
public class LeetCode983 {

    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[366];
        for (int i = 1, idx = 0; i < 366; i++) {
            if( idx < days.length && i == days[idx]) {
                dp[i] = Math.min(Math.min(dp[i-1] + costs[0], dp[Math.max(0, i-7)] + costs[1]),
                        dp[Math.max(0, i-30)] + costs[2]);
                idx++;
            } else {
                dp[i] = dp[i-1];
            }
        }
        return dp[365];
    }

    public static void main(String[] args) {
        LeetCode983 lc = new LeetCode983();
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2,7,15};
        int ret = lc.mincostTickets(days, costs);
        System.out.println(ret);
    }

}
