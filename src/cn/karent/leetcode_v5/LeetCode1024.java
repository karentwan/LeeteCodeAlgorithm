package cn.karent.leetcode_v5;

import java.util.*;

/***********************************************
 * description: 视频拼接
 * @author wan
 * @date 2021.06.23
 ***********************************************/
public class LeetCode1024 {

    public int videoStitching(int[][] clips, int time) {
        int[] dp = new int[time+1];
        final int MAX_VALUE = Integer.MAX_VALUE / 2;
        Arrays.fill(dp, MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= time; i++) {
            for (int[] clip : clips) {
                int a = clip[0], b = clip[1];
                if( i > a && i <= b) {
                    dp[i] = Math.min(dp[i], dp[a] + 1);
                }
            }
        }
        return dp[time] == MAX_VALUE ? -1 : dp[time];
    }

    public static void main(String[] args) {
        LeetCode1024 lc = new LeetCode1024();
//        int[][] clips = {{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}};
        int[][] clips = {{2,3},{3,4}};
        int T = 4;
        int ret = lc.videoStitching(clips, T);
        System.out.println(ret);
    }

}
