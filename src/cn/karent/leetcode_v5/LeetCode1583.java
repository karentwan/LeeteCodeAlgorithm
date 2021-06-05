package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 统计不开心的朋友
 * @author wan
 * @date 2021.06.05
 ********************************************/
public class LeetCode1583 {

    private int process(Map<Integer, Integer> map, int[][] preferences, int[][] pairs, int n, int a, int b) {
        for (int i = 0; i < n-1 && preferences[a][i] != b; i++) {
            int idx = map.get(preferences[a][i]);
            int p1 = preferences[a][i];
            int p2 = p1 == pairs[idx][0] ? pairs[idx][1] : pairs[idx][0];
            int t1 = -1;   // 找到 a 所在的索引
            for (int j = 0; j < n - 1; j++) {
                if( preferences[p1][j] == a) {
                    t1 = j;
                    break;
                }
            }
            int t2 = -1;  // p2所在的索引
            for (int j = 0; j < n - 1; j++) {
                if( preferences[p1][j] == p2) {
                    t2 = j;
                    break;
                }
            }
            if( t1 < t2) {
                return 1;
            }
        }
        return 0;
    }

    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int ret = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < pairs.length; i++) {
            map.put(pairs[i][0], i);
            map.put(pairs[i][1], i);
        }
        for (int[] pair : pairs) {
            int a = pair[0];
            int b = pair[1];
            if( b != preferences[a][0] ) {
                ret += process(map, preferences, pairs, n, a, b);
            }
            if( a != preferences[b][0]) {
                ret += process(map, preferences, pairs, n, b, a);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1583 lc = new LeetCode1583();
        int[][] p = {{1, 2, 3}, {3, 2, 0}, {3, 1, 0}, {1, 2, 0}};
        int[][] pairs = {{0, 1}, {2, 3}};
        int n = 4;
        int ret = lc.unhappyFriends(n, p, pairs);
        System.out.println(ret);
    }

}
