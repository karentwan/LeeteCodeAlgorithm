package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 删除有序数组中的重复项
 * @author wan
 * @date 2021.04.18
 */
public class LeetCode26 {

    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if( j == 0 || nums[j-1] != nums[i]) nums[j++] = nums[i];
        }
        return j;
    }

    public static void main(String[] args) {
        LeetCode26 lc = new LeetCode26();
        int[] nums = {1,1,2};
        int len = lc.removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

}
