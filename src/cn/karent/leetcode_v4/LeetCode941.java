package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 有效的山脉数组
 * @author wan
 * @date 2021.05.15
 ********************************************/
public class LeetCode941 {

    public boolean validMountainArray(int[] arr) {
        if( arr.length < 3) return false;
        int i = 0, j = arr.length-1;
        while (i < j && i + 1 < arr.length && j-1 >= 0) {
            if(arr[i+1] > arr[i] || arr[j-1] > arr[j]) {
                if (arr[i + 1] > arr[i]) i++;
                if (arr[j - 1] > arr[j]) j--;
            } else break;
        }
        return i == j && i > 0 && j < arr.length-1;
    }

    public static void main(String[] args) {
        LeetCode941 lc = new LeetCode941();
//        int[] arr = {2,1};
//        int[] arr = {3,5,5};
//        int[] arr = {3,5,4};
//        int[] arr = {0,3,2,1};
        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        System.out.println(lc.validMountainArray(arr));
    }

}
