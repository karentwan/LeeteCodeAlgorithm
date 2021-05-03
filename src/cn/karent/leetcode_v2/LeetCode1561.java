package cn.karent.leetcode_v2;

import java.util.*;

/**
 * 你可以获得的最大硬币数目
 */
public class LeetCode1561 {

    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int j = piles.length-1, i = 0;
        int ret = 0;
        while ( i < j) {
            j--;
            ret += piles[j];
            i++;
            j--;
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1561 lc = new LeetCode1561();
//        int[] piles = {2,4,1,2,7,8};
//        int[] piles = {2,4,5};
        int[] piles = {};
        int ret = lc.maxCoins(piles);
        System.out.println(ret);
    }

}
