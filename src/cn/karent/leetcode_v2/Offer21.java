package cn.karent.leetcode_v2;

import java.util.*;

/**
 * 调整数组顺序使奇数位于偶数前面
 * @author wan
 * @date 2021.04.06
 */
public class Offer21 {

    public int[] exchange(int[] nums) {
        int i = 0, j = nums.length-1;
        while (i < j) {
            while (i < j && nums[i] % 2 != 0) {
                i++;
            }
            while (i < j && nums[j] % 2 == 0) {
                j--;
            }
            swap(nums, i, j);
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        Offer21 offer = new Offer21();
        offer.exchange(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}
