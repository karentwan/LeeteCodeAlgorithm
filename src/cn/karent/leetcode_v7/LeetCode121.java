package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 买卖股票的最佳时机
 * @author wan
 * @date 2022.08.27 10:02
 ******************************************/
public class LeetCode121 {

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int max = prices[prices.length-1], ret = 0;
        for (int i = prices.length-2; i >= 0; i--) {
            ret = Math.max(max - prices[i], ret);
            max = Math.max(max, prices[i]);
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode121 lc = new LeetCode121();
    }

}
