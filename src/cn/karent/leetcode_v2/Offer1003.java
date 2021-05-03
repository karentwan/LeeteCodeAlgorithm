package cn.karent.leetcode_v2;

import java.util.*;

/**
 * 搜索旋转数组, 如有多个相同则返回最小的那个
 * @author wan
 * @date 2021.04.07
 */
public class Offer1003 {

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[l] == target) {
                return l;
            } else if( nums[mid] == target) {
                r = mid;
            } else if( nums[mid] > nums[r]) {  // 左边有序
                if( target >= nums[l] && target < nums[mid]) {
                    r = mid-1;
                } else {
                    l = mid+1;
                }
            } else if( nums[mid] == nums[r]) {
                r--;
            } else {
                if( target > nums[mid] && target <= nums[r]) {
                    l = mid+1;
                } else {
                    r = mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {5,5,5,1,2,3,4,5};
        int target = 5;
        Offer1003 offer = new Offer1003();
        int ret = offer.search(nums, target);
        System.out.println(ret);
    }

}
