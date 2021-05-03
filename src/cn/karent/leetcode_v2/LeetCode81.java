package cn.karent.leetcode_v2;

import java.util.*;

/**
 * 搜索旋转排序数组 二
 * @author wan
 * @date 2021.04.07
 */
public class LeetCode81 {

    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if( nums[mid] == target) {
                return true;
            } else if( nums[mid] > nums[r]) {  // 左边有序
                if( nums[mid] > target && nums[l] <= target) {
                    r = mid-1;
                } else {
                   l = mid+1;
                }
            } else if( nums[mid] == nums[r]){  // 只能排除右边不是要找的元素
                r--;
            } else { // 右边有序
                if( nums[mid] < target && nums[r] >= target) {
                    l = mid+1;
                } else {
                    r = mid-1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[] nums = {2,5,6,0,0,1,2};
//        int target = 3;
//        int[] nums = {0,2,2};
//        int target = 3;
//        int[] nums = {1,0,1,1,1};
//        int target = 0;
        int[] nums = {1,1,1,1, 1,1,1,1, 1,1,1,1, 1,2,1,1, 1,1,1};
        int target = 2;
        LeetCode81 lc = new LeetCode81();
        boolean ret = lc.search(nums, target);
        System.out.println(ret);
    }

}
