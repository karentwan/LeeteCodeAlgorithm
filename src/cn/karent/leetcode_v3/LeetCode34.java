package cn.karent.leetcode_v3;

import java.util.*;

/*****************************************
 * 在排序数组中查找元素的第一个和最后一个位置
 * @author wan
 * @date 2021.04.22
 *****************************************/
public class LeetCode34 {

    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if( n == 0) return new int[]{-1,-1};
        int l = 0, r = n-1;
        int left = -1, right = -1;
        while (l < r) {
            int m = l + (r - l)/2;
            if(nums[m] >= target) r = m;
            else l = m+1;
        }
        if( nums[l] == target) left = l;
        l = 0;
        r = n-1;
        while (l < r) {
            int m = l + (r-l)/2;
            if( nums[m] > target) r = m;
            else l = m+1;
        }
        if( nums[l] != target) l--;
        if( l >= 0 && nums[l] == target) right = l;
        if( left != -1 && right == -1) right = left;
        return new int[]{left, right};
    }

    public static void main(String[] args) {
        LeetCode34 lc = new LeetCode34();
//        int[] nums = {5, 7, 7, 8, 8, 10};
//        int target = 6;
//        int[] nums = {};
//        int target = 0;
        int[] nums = {2,2};
        int target = 2;
        int[] rets = lc.searchRange(nums, target);
        System.out.println("[" + rets[0] + "," + rets[1] + "]");
    }

}
