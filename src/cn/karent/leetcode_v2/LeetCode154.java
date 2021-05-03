package cn.karent.leetcode_v2;

import java.util.*;

/**
 * 寻找旋转排序数组中的最小值 二
 * @author wan
 * @date 2021.04.09
 */
public class LeetCode154 {

    public int findMin(int[] nums) {
        int l = 0, r = nums.length-1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if( nums[m] > nums[r]) {
                l = m+1;
            } else if( nums[m] < nums[r]) {
                r = m;
            } else {
                r--;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        LeetCode154 lc = new LeetCode154();
//        int[] nums = {1,3,5};
        int[] nums = {2,2,2,0,1};
        int ret = lc.findMin(nums);
        System.out.println(ret);
    }

}
