package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 堆排序
 * @author wan
 * @date 2021.04.10
 */
public class HeapSort {

    private void down(int[] nums, int s, int e, Comparator<Integer> cmp) {
        int t = nums[s];
        int p = s * 2 + 1;
        while (p <= e) {
            if( p+1 <= e && cmp.compare(nums[p+1], nums[p]) < 0) {
                p++;
            }
            if( cmp.compare(nums[p], t) < 0) {
                nums[s] = nums[p];
            } else {
                break;
            }
            s = p;
            p = s * 2 + 1;
        }
        nums[s] = t;
    }

    private void swap(int[] nums, int x1, int x2) {
        int t = nums[x1];
        nums[x1] = nums[x2];
        nums[x2] = t;
    }

    public void sort(int[] nums, Comparator<Integer> cmp) {
        if( nums.length == 0) {
            return;
        }
        int n = nums.length-1;
        // 构建堆
        for (int i = n/2; i >= 0; i--) {
            down(nums, i, n, cmp);
        }
        for (int i = n; i >= 0; i--) {
            swap(nums, 0, i);
            down(nums, 0, i-1, cmp);
        }
    }

    public static void main(String[] args) {
        int[] nums = {7,1,2,3,6,5,7,4,8,9};
        HeapSort obj = new HeapSort();
        obj.sort(nums, (k1, k2) -> {
            return k1 - k2;
        });
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}
