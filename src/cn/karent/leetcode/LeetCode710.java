package cn.karent.leetcode;

import java.util.*;

/**
 * 黑名单中的随机数
 */
public class LeetCode710 {

    private Map<Integer, Integer> map = new HashMap<>();
    private int n = 0;
    private Random rd = new Random();

    public LeetCode710(int N, int[] blacklist) {
        n = N - blacklist.length;
        Set<Integer> sets = new HashSet<>();  // 白名单
        for(int i = n; i < N; i++) {
            sets.add(i);
        }
        for(int x : blacklist) {
            sets.remove(x);
        }
        Iterator<Integer> iter = sets.iterator();
        for(int x : blacklist) {
            if( x < n) {
                map.put(x, iter.next());
            }
        }
    }

    public int pick() {
        int k = rd.nextInt(n);
        return map.getOrDefault(k, k);
    }

    public static void main(String[] args) {
        LeetCode710 lc = new LeetCode710(6, new int[]{0, 2, 3});
        int ret = lc.pick();
        System.out.println(ret);

    }
}
