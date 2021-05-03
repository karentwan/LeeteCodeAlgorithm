package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 移除元素
 * @author wan
 * @date 2021.04.19
 */
public class LeetCode27 {

    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if( nums[i] != val) nums[j++] = nums[i];
        }
        return j;
    }

    public static void main(String[] args) {
        LeetCode27 lc = new LeetCode27();
//        int[] nums  = {3,2,2,3};
//        int val = 3;
        int[] nums  = {0,1,2,2,3,0,4,2};
        int val = 2;
        int l = lc.removeElement(nums, val);
        for (int i = 0; i < l; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

}
