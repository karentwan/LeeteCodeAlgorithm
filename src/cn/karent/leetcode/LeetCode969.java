package cn.karent.leetcode;

import java.util.*;

/**
 * 煎饼排序
 */
public class LeetCode969 {

    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> rets = new ArrayList<>();
        for (int i = arr.length-1; i >= 0 ; i--) {
            int idx = find(arr, i+1);
            if( idx == i) {
                continue;
            }
            if( idx != 0) {
                rets.add(idx+1);
                // 翻转到首元素
                reverse(arr, 0, idx);
            }
            if( 0 != i) {
                // 翻转到尾元素
                rets.add(i+1);
                reverse(arr, 0, i);
            }
        }
        return rets;
    }

    private void reverse(int[] arr, int start, int end) {
        while( start < end) {
            int t = arr[start];
            arr[start] = arr[end];
            arr[end] = t;
            start++;
            end--;
        }
    }

    private int find(int[] arr, int length) {
        int idx = 0;
        for (int i = 0; i < length; i++) {
            if( arr[i] > arr[idx]) {
                idx = i;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        LeetCode969 lc = new LeetCode969();
        int[] nums = {3,2,4,1};
        List<Integer> rets = lc.pancakeSort(nums);
        for(int ret : rets) {
            System.out.print(ret + " ");
        }
    }

}
