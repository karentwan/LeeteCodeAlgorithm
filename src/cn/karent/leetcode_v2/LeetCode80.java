package cn.karent.leetcode_v2;

import java.util.*;

/**
 * 删除有序数组中的重复项 二
 * @author wan
 * @date 2021.04.06
 */
public class LeetCode80 {

    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0;
        while (j < nums.length) {
            if( i < 2 || nums[i-2] != nums[j]) {
                nums[i++] = nums[j];
            }
            j++;
        }
        return i;
    }

    public static void main(String[] args) {
        LeetCode80 lc = new LeetCode80();
        int[] nums = {1,1,2,2,2,2,3,4};
//        int[] nums = {1,1,1,2,2,3,4};
//        int[] nums = {0,0,1,1,1,1,2,3,3};
        int n = lc.removeDuplicates(nums);
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

}
