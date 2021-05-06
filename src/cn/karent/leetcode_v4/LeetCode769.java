package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 最多能完成排序的块
 * @author wan
 * @date 2021.05.06
 ********************************************/
public class LeetCode769 {

    public int maxChunksToSorted(int[] arr) {
        int ret = 0;
        int mx = 0;
        for (int i = 0; i < arr.length; i++) {
            mx = Math.max(mx, arr[i]);
            // 当mx等于i时, 表示前i个元素是一种全排列
            if( mx == i) ret++;
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode769 lc = new LeetCode769();
        int[] arr = {4, 3, 2, 1, 0};
        int ret = lc.maxChunksToSorted(arr);
        System.out.println(ret);
    }

}
