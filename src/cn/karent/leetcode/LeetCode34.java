package cn.karent.leetcode;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 */
public class LeetCode34 {

    private int getLeft(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while( left <= right) {
            int mid = left + (right - left)/2;
            if( nums[mid] >= target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return left;
    }

    private int getRight(int[] nums, int left, int target) {
        int right = nums.length-1;
        while( left <= right) {
            int mid = left + (right - left)/2;
            if( nums[mid] > target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return right;
    }

    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        if( nums.length == 0 ||
                (left = getLeft(nums, target)) >= nums.length
                || nums[left] != target) {
            return new int[]{-1, -1};
        }
        int right = getRight(nums, left, target);
        return new int[]{left, right};
    }

    public static void main(String[] args) {
        LeetCode34 lc = new LeetCode34();
//        int[] nums = {5,7,7,8,8,10};
//        int target = 8;
//        int[] nums = {5,7,7,8,8,10};
//        int target = 6;
        int[] nums = {2,2};
        int target = 3;
        int[] rets = lc.searchRange(nums, target);
        System.out.println("(" + rets[0] + ", " + rets[1] + ")");
    }

}
