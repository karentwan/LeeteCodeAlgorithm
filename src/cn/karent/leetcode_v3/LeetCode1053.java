package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 交换一次的先前排列
 * @author wan
 * @date 2021.04.15
 */
public class LeetCode1053 {

    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;
        if(n == 0) return arr;
        for(int i = n-2; i >= 0; i--) {
            if( arr[i] > arr[i+1]) {
                int max = Integer.MIN_VALUE;
                int idx = -1;
                for (int j = i+1; j < n; j++) {
                    if( arr[j] < arr[i] && arr[j] > max) {
                        max = arr[j];
                        idx = j;
                    }
                }
                swap(arr, i, idx);
                break;
            }
        }
        return arr;
    }

    private void swap(int[] arr, int i, int idx) {
        int tmp = arr[i];
        arr[i] = arr[idx];
        arr[idx] = tmp;
    }

    public static void main(String[] args) {
        LeetCode1053 lc = new LeetCode1053();
//        int[] arr = {3,2,1};
//        int[] arr = {1,1,5};
        int[] arr = {1,9,4,6,7};
//        int[] arr = {3,1,1,3};
        lc.prevPermOpt1(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
