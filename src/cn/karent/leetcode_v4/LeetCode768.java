package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 最多能完成排序的块 二
 * @author wan
 * @date 2021.05.13
 ********************************************/
public class LeetCode768 {

    public int maxChunksToSorted(int[] arr) {
        int[] tmps = arr.clone();
        Arrays.sort(tmps);
        int s1 = 0, s2 = 0, ret = 0;
        for (int i = 0; i < arr.length; i++) {
            s1 += arr[i];
            s2 += tmps[i];
            if( s1 == s2) {
                ret++;
                s1 = s2 = 0;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode768 lc = new LeetCode768();
        int[] arr = {5, 4, 3, 2, 1};
        int ret = lc.maxChunksToSorted(arr);
        System.out.println(ret);
    }

}
