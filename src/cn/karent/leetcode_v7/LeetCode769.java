package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 最多能完成排序的块
 * @author wan
 * @date 2022.09.05 20:16
 ******************************************/
public class LeetCode769 {

    public int maxChunksToSorted(int[] arr) {
        int max = Integer.MIN_VALUE, ret = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if ( max == arr[i]) {
                ret++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode769 lc = new LeetCode769();
//        int[] arr = {4,3,2,1,0};
        int[] arr = {1,0,2,3,4};
//        int[] arr = {1,0,4,3,2};
//        int[] arr = {2,0,1};
//        int[] arr = {1,0,2,3,5,4};
        System.out.println(lc.maxChunksToSorted(arr));
    }

}
