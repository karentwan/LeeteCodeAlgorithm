package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 分割数组
 * @author wan
 * @date 2021.05.14
 ********************************************/
public class LeetCode915 {

    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        if( n == 0) return 0;
        int[] left = new int[n];
        left[0] = nums[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i-1], nums[i]);
        }
        int ret = 0;
        int min = nums[n-1];
        for (int i = n-1; i > 0; i--) {
            min = Math.min(min, nums[i]);
            if( left[i-1] <= min) {
                ret = i;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode915 lc = new LeetCode915();
//        int[] arr = {5, 0, 3, 8, 6};
//        int[] arr = {1,1,1,0,6,12};
        int[] arr = {1,1};
        int ret = lc.partitionDisjoint(arr);
        System.out.println(ret);
    }

}
