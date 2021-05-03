package cn.karent.leetcode_v2;

import java.util.*;

/**
 * 删除有序数组中的重复项
 * @author wan
 * @date 2021.04.06
 */
public class LeetCode26 {

    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0;
        while (j < nums.length) {
            if( j < 1 || nums[i-1] != nums[j]) {
                nums[i++] = nums[j];
            }
            j++;
        }
        return i;
    }

    public static void main(String[] args) {
        LeetCode26 lc = new LeetCode26();
        int[] nums = {1,1,2};
        int n = lc.removeDuplicates(nums);
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

}
