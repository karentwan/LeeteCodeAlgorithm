package cn.karent.leetcode_v6.weeklycontest252;

import java.util.*;

/***********************************************
 * description: 
 * @author wan
 * @date 2021.08.01
 ***********************************************/
public class LeetCode5831 {

    public long numberOfWeeks(int[] milestones) {
        long max = Long.MIN_VALUE;
        long sum = 0;
        for (int milestone : milestones) {
            sum += milestone;
            max = Math.max(max, milestone);
        }
        long rest = sum - max;
        if( max > rest + 1) return rest * 2 + 1;
        return sum;
    }

    public static void main(String[] args) {
        LeetCode5831 lc = new LeetCode5831();
        int[] arr = {1,2,3};
        long ret = lc.numberOfWeeks(arr);
        System.out.println(ret);
    }

}
