package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 计算右侧小于当前元素的个数
 * @author wan
 * @date 2021.06.01
 ********************************************/
public class LeetCode315 {
/*

    private int binarySearch(int[] nums, int l, int r, int t) {  // 找到小于
        while (l < r) {
            int m = l + (r-l)/2;
            if( nums[m] >= t) l = m+1;
            else r = m;
        }
        return l;
    }

    // 超时
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> rets = new ArrayList<>();
        int n = nums.length;
        for (int i = n-1; i >= 0; i--) {
            int t = nums[i];
            int ret = n - binarySearch(nums, i+1, n, t);
            rets.add(ret);
            int j = i+1;
            while ( j < n && t < nums[j]) {
                nums[j-1] = nums[j];
                j++;
            }
            nums[j-1] = t;
        }
        Collections.reverse(rets);
        return rets;
    }

*/


    private void merge(int[] nums, int[] indices, int[] rets, int[] tmps, int l, int r) {
        if( l >= r) return;
        int m = l + (r - l)/2;
        merge(nums, indices, rets, tmps, l, m);
        merge(nums, indices, rets, tmps, m+1, r);
        int i = l, j = m+1, k = l;
        while (i <= m) {
            while ( j <= r && nums[indices[j]] < nums[indices[i]]) {
                j++;
            }
            rets[indices[i]] += j - m - 1;
            i++;
        }
        i = l;
        j = m+1;
        while (i <= m && j <= r) {
            if( nums[indices[i]] <= nums[indices[j]]) {  // <= 是稳定算法
                tmps[k++] = indices[i++];
            } else tmps[k++] = indices[j++];
        }
        while (i <= m) {
            tmps[k++] = indices[i++];
        }
        while (j <= r) {
            tmps[k++] = indices[j++];
        }
        for (i = l; i <= r; i++) {
            indices[i] = tmps[i];
        }
    }

    private void mergeSort(int[] nums, int[] indices, int[] rets, int[] tmps) {
        merge(nums, indices, rets, tmps, 0, nums.length-1);
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] indices = new int[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        int[] rets = new int[n];
        int[] tmps = new int[n];
        mergeSort(nums, indices, rets, tmps);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(rets[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        LeetCode315 lc = new LeetCode315();
        int[] arr = {5, 2, 6, 1};
        List<Integer> rets = lc.countSmaller(arr);
        System.out.println(rets);
    }

}
