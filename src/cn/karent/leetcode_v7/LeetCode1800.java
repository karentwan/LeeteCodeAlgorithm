package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 最大升序子数组和
 * @author wan
 * @date 2022.10.07 09:57
 ******************************************/
public class LeetCode1800 {

    public int maxAscendingSum(int[] nums) {
        int wnd = nums[0], ret = nums[0];
        for (int i = 1; i < nums.length; i++) {
            wnd = nums[i] > nums[i - 1] ? wnd + nums[i] : nums[i];
            ret = Math.max(wnd, ret);
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1800 lc = new LeetCode1800();
    }

}
