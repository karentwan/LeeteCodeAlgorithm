package cn.karent.leetcode_v3.weeklycontest236;

import java.util.*;

/**
 * 最少侧跳次数
 * @author wan
 * @date 2021.04.11
 */
public class ALgo5728 {

    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        final int INFINITY = Integer.MAX_VALUE/2;
        int[][] dp = new int[n][3];
        for (int i = obstacles.length-2; i >= 0; i--) {
            if( obstacles[i] == 1) {
                dp[i][0] = INFINITY;
                dp[i][1] = Math.min(dp[i+1][1], dp[i+1][2]+1);
                dp[i][2] = Math.min(dp[i+1][2], dp[i+1][1]+1);
            } else if(obstacles[i] == 2) {
                dp[i][1] = INFINITY;
                dp[i][0] = Math.min(dp[i+1][0], dp[i+1][2]+1);
                dp[i][2] = Math.min(dp[i+1][2], dp[i+1][0]+1);
            } else if(obstacles[i] == 3){
                dp[i][2] = INFINITY;
                dp[i][0] = Math.min(dp[i+1][0], dp[i+1][1]+1);
                dp[i][1] = Math.min(dp[i+1][1], dp[i+1][0]+1);
            } else {
                dp[i][0] = Math.min(Math.min(dp[i+1][0], dp[i+1][1]+1), dp[i+1][2]+1);
                dp[i][1] = Math.min(Math.min(dp[i+1][1], dp[i+1][0]+1), dp[i+1][2]+1);
                dp[i][2] = Math.min(Math.min(dp[i+1][2], dp[i+1][0]+1), dp[i+1][1]+1);
            }
        }
        return dp[0][1];
    }

    public static void main(String[] args) {
        ALgo5728 lc = new ALgo5728();
//        int[] obstacles = {0,1,1,3,3,0};
        int[] obstacles = {0,1,2,3,0};
//        int[] obstacles = {0,2,1,0,3,0};
        int ret = lc.minSideJumps(obstacles);
        System.out.println(ret);
    }

}
