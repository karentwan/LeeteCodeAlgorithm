package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 第三大的数
 * @author wan
 * @date 2021.05.03
 ********************************************/
public class LeetCode414 {

    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int i = nums.length-1;
        int k = 3;
        while (i >= 0) {
            int j = i;
            while (j >= 0 && nums[j] == nums[i]) j--;
            k--;
            if( k == 1 && j >= 0) return nums[j];
            i = j;
        }
        return nums[nums.length-1];
    }

    public static void main(String[] args) {
        LeetCode414 lc = new LeetCode414();
//        int[] nums = {3,2,1};
//        int[] nums = {2,1};
//        int[] nums = {2,2,3,1};
        int[] nums = {2,2,3,1, 4,4,4,4,4,4};
        int ret = lc.thirdMax(nums);
        System.out.println(ret);
    }

}
