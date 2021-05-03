package cn.karent.leetcode_v2;

import java.util.*;

/**
 * 将整数按权重排序
 */
public class LeetCode1387 {

    private Map<Integer, Integer> map = new HashMap<>();

    private int dfs(int x) {
        if( x == 1) {
            return 0;
        }
        int val = map.getOrDefault(x, 0);
        if( val > 0) {
            return val;
        }
        val = x % 2 == 0 ? dfs(x/2) : dfs(3 * x +1);
        val++;
        map.put(x, val);
        return val;
    }

    public int getKth(int lo, int hi, int k) {
        // battle
        Integer[] arr = new Integer[hi - lo + 1];
        for (int i = lo; i <= hi; i++) {
            arr[i-lo] = i;
        }
        Arrays.sort(arr, (k1, k2) -> {
            int t1 = dfs(k1);
            int t2 = dfs(k2);
            return t1 == t2 ? k1 - k2 : t1 - t2;
        });
        if( k <= arr.length) {
            return arr[k-1];
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode1387 lc = new LeetCode1387();
        int lo = 1;
        int hi = 1;
        int k = 1;
        int ret = lc.getKth(lo, hi, k);
        System.out.println(ret);
    }

}
