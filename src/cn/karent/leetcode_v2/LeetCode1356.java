package cn.karent.leetcode_v2;

import java.util.*;

/**
 * 根据数字二进制下1的数目排序
 */
public class LeetCode1356 {

    private int getBit(int n) {
        int cnt = 0;
        while ( n != 0 ) {
            if( (n & 1) == 1) {
                cnt++;
            }
            n >>>= 1;
        }
        return cnt;
    }

    private void _sort(int[] nums, int left, int right, Comparator<Integer> cmp) {
        if( left >= right) {
            return;
        }
        int mid = partition(nums, left, right, cmp);
        _sort(nums, left, mid-1, cmp);
        _sort(nums, mid+1, right, cmp);
    }

    private int partition(int[] nums, int left, int right, Comparator<Integer> cmp) {
        int t = nums[left];
        while (left < right) {
            while (left < right && cmp.compare(t, nums[right]) < 0) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && cmp.compare(nums[left], t) <= 0) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = t;
        return left;
    }

    private void sort(int[] nums, Comparator<Integer> cmp) {
        _sort(nums, 0, nums.length-1, cmp);
    }

    public int[] sortByBits(int[] arr) {
        Comparator<Integer> cmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int t1 = getBit(o1);
                int t2 = getBit(o2);
                return t1 == t2 ? o1 - o2 : t1 - t2;
            }
        };
        sort(arr, cmp);
        return arr;
    }

    public static void main(String[] args) {
        LeetCode1356 lc = new LeetCode1356();
//        int[] arr = {0,1,2,3,4,5,6,7,8};
        int[] arr = {8,1,2,3,6,5,4,9,7};
        print(arr);
        lc.sortByBits(arr);
        print(arr);
    }

    private static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
