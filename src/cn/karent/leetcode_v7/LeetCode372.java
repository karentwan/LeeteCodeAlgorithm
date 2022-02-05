package cn.karent.leetcode_v7;

import java.util.*;

/***********************************************
 * description: 超级次方
 * @author wan
 * @date 2021.12.05
 ***********************************************/
public class LeetCode372 {

    public int quickPow(int a, int b) {
        int ret = 1, mod = 1337;
        for (a = a % mod; b > 0; b >>= 1, a = a*a % mod) {
            if ((b&1) != 0) {
                ret = ret * a % mod;
            }
        }
        return ret;
    }

    private int dfs(int a, int[] b, int idx) {
        if (idx < 0) return 1;
        int mod = 1337;
        return (quickPow(dfs(a, b, idx-1), 10) * quickPow(a, b[idx])) % mod;
    }

    public int superPow(int a, int[] b) {
        return dfs(a, b, b.length-1);
    }

    public static void main(String[] args) {
        LeetCode372 lc = new LeetCode372();
//        System.out.println(lc.quickPow(2, 10));
        int a = 2;
        int[] b = {1,0};
        System.out.println(lc.superPow(a, b));
    }

}
