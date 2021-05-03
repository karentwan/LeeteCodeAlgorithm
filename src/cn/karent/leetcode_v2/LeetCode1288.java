package cn.karent.leetcode_v2;

import java.util.*;

/**
 * 删除被覆盖区间
 */
public class LeetCode1288 {

    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (k1, k2) -> {
            return k1[0] == k2[0] ? k2[1] - k1[1] : k1[0] - k2[0];
        });
        int i = 0;
        int ret = 0;
        while (i < intervals.length) {
            int j = i+1;
            while (j < intervals.length && intervals[j][0] >= intervals[i][0] &&
                            intervals[j][1] <= intervals[i][1]) {
                ret++;
                j++;
            }
            i = j;
        }
        return intervals.length - ret;
    }

    public static void main(String[] args) {
        LeetCode1288 lc = new LeetCode1288();
        int[][] intervals =  {{1,4},{3,6},{2,8}};
        int ret = lc.removeCoveredIntervals(intervals);
        System.out.println(ret);
    }

}
