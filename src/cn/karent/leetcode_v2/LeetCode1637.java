package cn.karent.leetcode_v2;

import java.util.*;

/**
 * 两点之间不包含任何点的最宽垂直面积
 */
public class LeetCode1637 {

    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (k1, k2) -> {
            return k1[0] - k2[0];
        });
        int ret = 0;
        for (int i = 1; i < points.length; i++) {
            ret = Math.max(points[i][0] - points[i-1][0], ret);
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1637 lc = new LeetCode1637();
//        int[][] points = {{8,7},{9,9},{7,4},{9,7}};
        int[][] points = {{3,1},{9,0},{1,0},{1,4},{5,3},{8,8}};
        int ret = lc.maxWidthOfVerticalArea(points);
        System.out.println(ret);
    }

}
