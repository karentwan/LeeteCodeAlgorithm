package cn.karent.leetcode_v2;

import java.util.*;

/**
 * 数组中的k个最强值
 */
public class LeetCode1471 {

/*
    *//**
     * 希尔排序
     * @param arr
     * @param cmp
     *//*
    private void sort(int[] arr, Comparator<Integer> cmp) {
        int n = arr.length;
        for (int d = n / 2; d >= 1; d /= 2) {
            for (int i = 1; i < n; i++) {
                int j = i-d;
                int t = arr[i];
                while ( j >= 0 && cmp.compare(t, arr[j]) < 0) {
                    arr[j+d] = arr[j];
                    j -= d;
                }
                arr[j+d] = t;
            }
        }
    }

    private void _sort(int[] arr, int left, int right, Comparator<Integer> cmp) {
        if( left >= right) {
            return;
        }
        int mid = partition(arr, left, right, cmp);
        _sort(arr, left, mid-1, cmp);
        _sort(arr, mid+1, right, cmp);
    }

    private int partition(int[] arr, int left, int right, Comparator<Integer> cmp) {
        int tmp = arr[left];
        while (left < right) {
            while (left < right && cmp.compare(arr[right], tmp) > 0) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && cmp.compare(arr[left], tmp) <= 0) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = tmp;
        return left;
    }

    private void quickSort(int[] arr, Comparator<Integer> cmp) {
        _sort(arr, 0, arr.length-1, cmp);
    }

    public int[] getStrongest(int[] arr, int k) {
        quickSort(arr, (k1, k2) -> {
           return k1 - k2;
        });
        int n = arr.length;
        if( n == 0) {
            return arr;
        }
        int mid = arr[(n-1)/2];
        int[] tmp = new int[n];
        int[] indices = new int[n];
        for (int i = 0; i < n; i++) {
            tmp[i] = Math.abs(arr[i] - mid);
            indices[i] = i;
        }
        quickSort(indices, (k1, k2) -> {
           return tmp[k1] == tmp[k2] ? arr[k2] - arr[k1] : tmp[k2] - tmp[k1];
        });
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = arr[indices[i]];
        }
        return ret;
    }

    */

    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        if( n == 0) {
            return arr;
        }
        int mid = arr[(n-1)/2];
        Integer[] tmp = new Integer[n];
        for (int i = 0; i < n; i++) {
            tmp[i] = arr[i];
        }
        Arrays.sort(tmp, (k1, k2) -> {
            int t1 = Math.abs(k1 - mid);
            int t2 = Math.abs(k2 - mid);
            return t1 == t2 ? k2 - k1 : t2 - t1;
        });
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = tmp[i];
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1471 lc = new LeetCode1471();
//        int[] arr = {1,2,3,4,5};
//        int k = 2;
        int[] arr = {6,7,11,7,6,8};
        int k = 5;
        print(arr);
        int[] ret = lc.getStrongest(arr, k);
        print(ret);
    }

    private static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
