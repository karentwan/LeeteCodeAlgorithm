package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 按照频率将数组升序排序
 * @author wan
 * @date 2021.04.09
 */
public class LeetCode1636 {

    private void quickSort(int[] nums, int l, int r, Comparator<Integer> cmp) {
        if( l >= r) {
            return;
        }
        int m = partition(nums, l, r, cmp);
        quickSort(nums, l, m-1, cmp);
        quickSort(nums, m+1, r, cmp);
    }

    private int partition(int[] nums, int l, int r, Comparator<Integer> cmp) {
        int t = nums[l];
        while (l < r ) {
            while (l < r && cmp.compare(nums[r], t) >= 0) {
                r--;
            }
            nums[l] = nums[r];
            while (l < r && cmp.compare(nums[l], t) < 0) {
                l++;
            }
            nums[r] = nums[l];
        }
        nums[l] = t;
        return l;
    }

    private void sort(int[] nums, Comparator<Integer> cmp) {
        quickSort(nums, 0, nums.length-1, cmp);
    }

    public int[] frequencySort(int[] nums) {
        int[] cache = new int[201];
        for (int num : nums) {
            cache[num + 100]++;
        }
        sort(nums, (k1, k2) -> {
           int key1 = cache[k1 + 100];
           int key2 = cache[k2 + 100];
           return key1 == key2 ? k2 - k1 : key1 - key2;
        });
        return nums;
    }

    public static void main(String[] args) {
        LeetCode1636 lc = new LeetCode1636();
        int[] nums = {1,1,2,2,2,3};
        lc.frequencySort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}
