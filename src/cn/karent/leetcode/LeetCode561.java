package cn.karent.leetcode;

import java.util.*;

/**
 * 数组拆分
 */
public class LeetCode561 {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ret = 0;
        for(int i = 0; i < nums.length; i+=2) {
            ret += nums[i];
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode561 lc = new LeetCode561();
//        int[] nums = {1,4,3,2};
        int[] nums = {6,2,6,5,1,2};
        int ret = lc.arrayPairSum(nums);
        System.out.println(ret);
    }
}
