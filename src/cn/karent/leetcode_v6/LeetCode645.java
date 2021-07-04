package cn.karent.leetcode_v6;

import java.util.*;

/***********************************************
 * description: 错误的集合
 * @author wan
 * @date 2021.07.04
 ***********************************************/
public class LeetCode645 {

    public int[] findErrorNums(int[] nums) {
        if( nums.length == 0) return new int[0];
        for (int i = 0; i < nums.length; i++) {
            while ( i < nums.length && nums[nums[i]-1] != nums[i]) {
                int t = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = t;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i+1) {
                return new int[]{nums[i], i+1};
            }
        }
        return new int[]{nums[nums.length-1], nums.length};
    }

    public static void main(String[] args) {

    }

}
