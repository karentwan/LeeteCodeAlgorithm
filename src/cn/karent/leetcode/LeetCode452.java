package cn.karent.leetcode;

import java.util.*;

/**
 * 用最少数量的箭引爆气球
 */
public class LeetCode452 {

    public int findMinArrowShots(int[][] points) {
        if( points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (int[] item1, int[] item2) -> {
            if( item1[0] == item2[0]) {
                return Integer.compare(item1[1], item2[1]);
            }
            return Integer.compare(item1[0], item2[0]);
        });
        int n = points.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int ret = 1;
        for(int i = 1; i < n; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(points[j][1] < points[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode452 lc = new LeetCode452();
//        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
//        int[][] points = {{-2147483646,-2147483645},{2147483646,2147483647}};
        int[][] points = {{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}};
        int ret = lc.findMinArrowShots(points);
        System.out.println(ret);
    }
}
