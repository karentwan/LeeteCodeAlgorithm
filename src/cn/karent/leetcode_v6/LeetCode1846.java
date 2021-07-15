package cn.karent.leetcode_v6;

import java.util.*;

/***********************************************
 * description: 减小和重新排列数组后的最大元素
 * @author wan
 * @date 2021.07.15
 ***********************************************/
public class LeetCode1846 {

    // 为啥满足条件的不能变
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            if( arr[i] - arr[i-1] > 1)
                arr[i] = arr[i-1]+1;
        }
        return arr[arr.length-1];
    }

    public static void main(String[] args) {

    }

}
