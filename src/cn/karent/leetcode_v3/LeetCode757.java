package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 设置交集大小至少为2
 * @author wan
 * @date 2021.04.13
 */
public class LeetCode757 {

    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (k1, k2) -> k1[0] != k2[0] ? k1[0] - k2[0] : k2[1] - k1[1]);
//        Arrays.sort(intervals, (k1, k2) ->k1[0] - k2[0]);  // 这一题以后还得重新做
        int n = intervals.length;
        int[] todo = new int[n];
        Arrays.fill(todo, 2);
        int t = n;
        int ret = 0;
        while (--t >= 0) {
            int s = intervals[t][0];
            int e = intervals[t][1];
            int m = todo[t];
            for (int p = s; p < s + m; p++) {
                for (int i = 0; i < t; i++) {
                    if( todo[i] > 0 && p <= intervals[i][1]) todo[i]--;
                }
                ret++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode757 lc = new LeetCode757();
//        int[][] intervals = {{1, 3}, {1, 4}, {2, 5}, {3, 5}};
        int[][] intervals = {{1, 2}, {2, 3}, {2, 4}, {4, 5}};
        int ret = lc.intersectionSizeTwo(intervals);
        System.out.println(ret);
    }

}
