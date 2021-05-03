package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 数组大小减半
 * @author wan
 * @date 2021.04.16
 */
public class LeetCode1338 {

    public int minSetSize(int[] arr) {
        if( arr.length == 0 ) return 0;
        Integer[] tmps = new Integer[arr.length];
        int[] cache = new int[100001];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            tmps[i] = arr[i];
//            map.put(tmps[i], map.getOrDefault(tmps[i], 0)+1);
            cache[tmps[i]]++;
        }
//        Arrays.sort(tmps, (k1, k2) -> map.get(k2) == map.get(k1) ? k1.compareTo(k2) : map.get(k2) - map.get(k1));
        Arrays.sort(tmps, (k1, k2) -> cache[k2] == cache[k1] ? k1.compareTo(k2) : cache[k2] - cache[k1]);
        int i = 0, ret = 0;
        while ( i < arr.length) {
            ret++;
            int j = i+1;
            while ( j < arr.length && tmps[j].compareTo(tmps[i]) == 0) {
                j++;
            }
            i = j;
            if( i >= arr.length/2) return ret;
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1338 lc = new LeetCode1338();
//        int[] arr = {3,3,3,3,5,5,5,2,2,7};
//        int[] arr = {7,7,7,7,7,7};
//        int[] arr = {1000,1000,3,7};
//        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int[] arr = {9,77,63,22,92, 9,14,54,8, 38,18,19,38, 68,58,19};
        int ret = lc.minSetSize(arr);
        System.out.println(ret);
    }

}
