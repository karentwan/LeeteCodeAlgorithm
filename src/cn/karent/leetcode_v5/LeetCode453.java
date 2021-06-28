package cn.karent.leetcode_v5;

import java.util.*;

/***********************************************
 * description: 最小操作次数使数组元素相等
 * @author wan
 * @date 2021.06.28
 ***********************************************/
public class LeetCode453 {

    public int minMoves(int[] nums) {
        int n = nums.length;
        if( n <= 1) return 0;
        int ret = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ret += nums[i];
            min = Math.min(min, nums[i]);
        }
        return ret - min * n;
    }

    public static void main(String[] args) {

    }

}
