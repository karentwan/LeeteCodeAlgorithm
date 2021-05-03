package cn.karent.leetcode_v2;

import java.util.*;

/**
 * 销售价值减少的颜色球
 * 模拟解法
 */
public class LeetCode1640 {

    public int maxProfit(int[] inventory, int orders) {
        long ret = 0;
        int i = 0;
        Integer[] tmps = new Integer[inventory.length];
        for (int j = 0; j < tmps.length; j++) {
            tmps[j] = inventory[j];
        }
        Arrays.sort(tmps, (k1, k2) -> {
            return k2 - k1;
        });
        int MOD = ((int) (1e9 + 7));
        while ( orders > 0) {
            while ( i < tmps.length && Integer.compare(tmps[0], tmps[i]) == 0 ) {
                i++;
            }
            int next = 0;
            if( i < tmps.length ) {
                next = tmps[i];
            }
            long desc = tmps[0] - next;
            if( desc * i <= orders) {
                long a = next+1;
                long b = tmps[0];
                ret += ( a + b) * desc * i / 2;
                orders -= desc * i;
                tmps[0] = next;
            } else {
                long t = orders / i;
                long t1 = orders % i;
                long a = tmps[0] - t + 1;
                long b = tmps[0];
                ret += (a + b) * t * i / 2;
                ret += (tmps[0] - t) * t1;
                orders = 0;
            }
        }
        return ((int) (ret % MOD));
    }

    public static void main(String[] args) {
        LeetCode1640 lc = new LeetCode1640();
//        int[] inventory = {3,5};
//        int orders = 6;
//        int[] inventory = {2,8,4,10,6};
//        int orders = 20;
//        int[] inventory = {1000000000};
//        int orders = 1000000000;
        int[] inventory = {1000, 1000};
        int orders = 2;
        int ret = lc.maxProfit(inventory, orders);
        System.out.println(ret);
    }

}
