package cn.karent.leetcode_v6;

import java.util.*;

/***********************************************
 * description: 得到子序列的最少操作次数
 * @author wan
 * @date 2021.07.26
 ***********************************************/
public class LeetCode1713 {

    // 找到大于等于target的元素
    private int binarySearch(int[] arr, int len, int target) {
        int l = 0, r = len-1;
        while (l <= r) {
            int m = l + (r - l)/2;
            if( arr[m] >= target)
                r = m-1;
            else l = m+1;
        }
        return l;
    }

    public int minOperations(int[] target, int[] arr) {
        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : target) {
            map.put(i, cnt++);
        }
        int[] d = new int[arr.length];
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            if( map.containsKey(arr[i])) {
                int t = map.get(arr[i]);
                int idx = binarySearch(d, len, t);
                d[idx] = t;
                len = idx == len ? len+1 : len;
            }
        }
        return target.length - len;
    }

    public static void main(String[] args) {
        LeetCode1713 lc = new LeetCode1713();
        int[] target = {5,1,3};
        int[] arr = {9,4,2,3,4};
//        int[] target = {6,4,8,1,3,2};
//        int[] arr = {4,7,6,2,3,8,6,1};
        int ret = lc.minOperations(target, arr);
        System.out.println(ret);
    }

}
