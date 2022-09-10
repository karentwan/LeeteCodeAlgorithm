package cn.karent.leetcode_v7;

import cn.karent.util.LeetCodeUtil;

import java.util.*;

/******************************************
 * 数组中的逆序对
 * @author wan
 * @date 2022.09.10 12:55
 ******************************************/
public class Offer51 {

    private int ret = 0;

    private void count(int[] nums, int l, int r) {
        int m = l + (r - l) / 2;
        int i = l, j = m+1;
        while (i <= m ) {
            while (j <= r && nums[j] < nums[i]) {
                j++;
            }
            ret += j - m - 1;
            i++;
        }
    }

    private void mergeSort(int[] nums, int l, int r, int[] tmps) {
        if (l == r) return;
        int m = l + (r - l)/2;
        mergeSort(nums, l, m, tmps);
        mergeSort(nums, m+1, r, tmps);
        count(nums, l, r);  // 计算逆序对
        int i = l, j = m+1, k = l;
        while (i <= m && j <= r) {
            if (nums[i] < nums[j]) {
                tmps[k] = nums[i++];
            } else {
                tmps[k] = nums[j++];
            }
            k++;
        }
        while (i <= m) {
            tmps[k++] = nums[i++];
        }
        while (j <= r) {
            tmps[k++] = nums[j++];
        }
        for (i = l; i <= r; i++) {
            nums[i] = tmps[i];
        }
    }

    public int reversePairs(int[] nums) {
        if (nums.length == 0) return 0;
        mergeSort(nums, 0, nums.length-1, new int[nums.length]);
        return ret;
    }

    public static void main(String[] args) {
        Offer51 lc = new Offer51();
//        int[] arr = {7,5,6,4};
        int[] arr = {1,3,2,3,1};
        System.out.println(lc.reversePairs(arr));
        LeetCodeUtil.print(arr);
    }

}
