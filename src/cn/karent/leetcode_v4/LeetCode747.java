package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 至少是其他数字两倍的最大数
 * @author wan
 * @date 2021.05.11
 ********************************************/
public class LeetCode747 {

    public int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE;
        int idx = -1;
        for (int i = 0; i < nums.length; i++) {
            if( nums[i] > max) {
                max = nums[i];
                idx = i;
            }
        }
        for (int num : nums) {
            if( num != max && max < num * 2) return -1;
        }
        return idx;
    }

    public static void main(String[] args) {
        LeetCode747 lc = new LeetCode747();
        int[] nums = {3, 6, 1, 0};
        int ret = lc.dominantIndex(nums);
        System.out.println(ret);
    }

}
