package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 山脉数组的峰顶索引
 * @author wan
 * @date 2021.06.15
 ********************************************/
public class LeetCode852 {

    public int peakIndexInMountainArray(int[] arr) {
        int l = 0, r = arr.length-2;
        while (l <= r) {
            int m = l + (r - l)/2;
            if( arr[m] < arr[m+1]) l = m+1;
            else r = m-1;
        }
        return l;
    }

    public static void main(String[] args) {
        LeetCode852 lc = new LeetCode852();
//        int[] arr = {0, 1, 0};
        int[] arr = {24,69,100,99,79,78,67,36,26,19};
        int ret = lc.peakIndexInMountainArray(arr);
        System.out.println(ret);
    }

}
