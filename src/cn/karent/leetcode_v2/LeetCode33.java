package cn.karent.leetcode_v2;

import java.util.*;

/**
 * 搜索旋转排序数组
 * @author wan
 * @date 2021.04.07
 */
public class LeetCode33 {

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if( nums[mid] == target) {
                return mid;
            } else if( nums[mid] > nums[r]) {
                if( nums[l] <= target && nums[mid] > target) {
                    r = mid-1;
                } else {
                    l = mid+1;
                }
            } else {
                if( nums[mid] < target && nums[r] >= target) {
                    l = mid+1;
                } else {
                    r = mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }

}
