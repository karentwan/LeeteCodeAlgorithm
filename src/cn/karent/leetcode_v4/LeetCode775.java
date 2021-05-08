package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 全局倒置和局部倒置
 * 局部倒置一定是全局倒置, 全局倒置不一定是全局倒置, 因此只要找出不是局部倒置的全局倒置
 * 的数量即可
 * @author wan
 * @date 2021.05.07
 ********************************************/
public class LeetCode775 {

    public boolean isIdealPermutation(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int i = nums.length-1; i >= 2; i--) {
            min = Math.min(min, nums[i]);
            if( nums[i-2] > min) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode775 lc = new LeetCode775();
        int[] nums = {1,0,2};
        boolean ret = lc.isIdealPermutation(nums);
        System.out.println(ret);
    }

}
