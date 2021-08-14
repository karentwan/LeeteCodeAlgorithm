package cn.karent.leetcode_v6;

import java.util.*;

public class LeetCode1583 {

    private int getIndex(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if( arr[i] == target)
                return i;
        }
        return -1;
    }

    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] pair : pairs) {
            map.put(pair[0], pair[1]);
            map.put(pair[1], pair[0]);
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            int[] pref = preferences[i];
            int b = map.get(i);
            for (int j = 0; j < pref.length && pref[j] != b; j++) {
                int pb = map.get(pref[j]);
                int aIndex = getIndex(preferences[pref[j]], i);
                int bIndex = getIndex(preferences[pref[j]], pb);
                if( aIndex < bIndex) {
                    ret++;
                    break;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1583 lc = new LeetCode1583();
//        int n = 4;
//        int[][] preferences = {{1, 2, 3}, {3, 2, 0}, {3, 1, 0}, {1, 2, 0}};
//        int[][] pairs = {{0, 1}, {2, 3}};
        int n = 4;
        int[][] preferences = {{1, 3, 2}, {2, 3, 0}, {1, 3, 0}, {0, 2, 1}};
        int[][] pairs = {{1, 3}, {0, 2}};
        int ret = lc.unhappyFriends(n, preferences, pairs);
        System.out.println(ret);
    }

}
