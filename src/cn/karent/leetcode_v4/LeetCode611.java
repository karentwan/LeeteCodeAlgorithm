package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 有效三角形的个数
 * @author wan
 * @date 2021.05.04
 ********************************************/
public class LeetCode611 {
/*
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        int ret = 0;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int k = n-1;
                while (k > j && nums[i] + nums[j] <= nums[k]) {
                    k--;
                }
                ret += k - j;
            }
        }
        return ret;
    }
  */
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        int ret = 0;
        Arrays.sort(nums);
        for(int i = n-1; i >= 0; i--) {
            int j = 0, k = i-1;
            while (j < k) {
                if( nums[j] + nums[k] > nums[i]) {
                    ret += k - j;
                    k--;
                } else {
                    j++;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode611 lc = new LeetCode611();
        int[] nums = {2,2,3,4};
        int ret = lc.triangleNumber(nums);
        System.out.println(ret);
    }

}
