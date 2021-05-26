package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 递减元素使数组呈锯齿状
 * @author wan
 * @date 2021.05.26
 ********************************************/
public class LeetCode1144 {
/*
    public int movesToMakeZigzag(int[] nums) {
        int n = nums.length;
        int[][] up = new int[n][2];
        int[][] down = new int[n][2];
        if( n == 0) return 0;
        down[0][0] = up[0][0] = nums[0];
        for (int i = 1; i < n; i++) {
            int u = up[i-1][0], ucnt = up[i-1][1];
            int d = down[i-1][0], dcnt = down[i-1][1];
            // 下降
            if( nums[i] < u) {
                down[i][0] = nums[i];
                down[i][1] = ucnt;
            } else {
                down[i][0] = u - 1;
                down[i][1] = ucnt + nums[i] - u + 1;
            }
            // 上升
            if( nums[i] > d) {
                up[i][0] = nums[i];
                up[i][1] = dcnt;
            } else {
                up[i][0] = d + 1;
                up[i][1] = dcnt + d - nums[i] + 1;
            }
        }
        return Math.min(down[n-1][1], up[n-1][1]);
    }
    */

    private int func(boolean up, int[] nums) {
        int n = nums.length;
        int ret = 0;
        int prev = nums[0];
        for (int i = 1; i < n; i++) {
            if( up ) {  // 是否上升
                if( nums[i] <= prev) ret += prev - nums[i] + 1;
                prev = nums[i];
            } else {
                if( nums[i] >= prev) {
                    ret += nums[i] - prev + 1;
                    prev = prev - 1;
                } else prev = nums[i];
            }
            up = !up;
        }
        return ret;
    }

    public int movesToMakeZigzag(int[] nums) {
        int n = nums.length;
        if( n == 0) return 0;
        return Math.min(func(false, nums), func(true, nums));
    }

    public static void main(String[] args) {
        LeetCode1144 lc = new LeetCode1144();
//        int[] arr = {1,2,3};
//        int[] arr = {1,2,4};
//        int[] arr = {9,6,1,6,2};
//        int[] arr = {10,4,4,10,10,6,2,3};
        int[] arr = {2,7,10,9,8,9};
        int ret = lc.movesToMakeZigzag(arr);
        System.out.println(ret);
    }

}
