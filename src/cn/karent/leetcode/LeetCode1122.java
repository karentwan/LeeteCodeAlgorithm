package cn.karent.leetcode;

import java.util.*;

/**
 * 数组的相对排序
 */
public class LeetCode1122 {
    private int partition(int[] arr, int l, int r, Comparator<Integer> cmp) {
        int t = arr[l];
        while( l < r) {
//            while( l < r && arr[r] >= t) {
            while( l < r && cmp.compare(arr[r], t) >= 0) {
                r--;
            }
            arr[l] = arr[r];
//            while( l < r && arr[l] < t) {
            while( l < r && cmp.compare(arr[l], t) < 0) {
                l++;
            }
            arr[r] = arr[l];
        }
        arr[l] = t;
        return l;
    }

    private void sort(int[] arr, int l, int r, Comparator<Integer> cmp) {
        if( l >= r) {
            return;
        }
        int mid = partition(arr, l, r, cmp);
        sort(arr, l, mid-1, cmp);
        sort(arr, mid+1, r, cmp);
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }
        Comparator<Integer> cmp = (k1, k2) -> {
            int idx1 = map.getOrDefault(k1, -1);
            int idx2 = map.getOrDefault(k2, -1);
            if( idx1 >= 0 && idx2 >= 0) {
                return idx1 - idx2;
            }
            if( idx1 >= 0) {
                return -1;
            }
            if( idx2 >= 0) {
                return 1;
            }
            return k1 - k2;
        };
        sort(arr1, 0, arr1.length-1, cmp);
        return arr1;
    }

    public static void main(String[] args) {
        LeetCode1122 lc = new LeetCode1122();
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        int[] rets = lc.relativeSortArray(arr1, arr2);
        for (int ret : rets) {
            System.out.print(ret + " ");
        }
    }

}
