package cn.karent.leetcode_v4;

import cn.karent.util.LeetCodeUtil;

import java.util.*;

/********************************************
 * description: 缺失的第一个正数
 * @author wan
 * @date 2021.05.19
 ********************************************/
public class LeetCode41 {
/*
    public int firstMissingPositive(int[] nums) {
        int max = ((int) (Math.pow(2, 31) - 1));
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 1; i <= max; i++) {
            if( !set.contains(i)) return i;
        }
        return 1;
    }
    */

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        if( n == 0) return 1;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i]-1] != nums[i]) {
                int t = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = t;
            }
        }
        for (int i = 0; i < n; i++) {
            if( nums[i] != i+1) return i+1;
        }
        return n+1;
    }

    public static void main(String[] args) {
        LeetCode41 lc = new LeetCode41();
        int[] arr = {1,2,0};
        int[] arr1 = {3,4,-1,1};
        int[] arr2 = {7,8,9,11,12};
        LeetCodeUtil.run((a)->{
            int ret = lc.firstMissingPositive(a);
            System.out.println(ret);
        }, arr1, arr, arr2);
    }

}
