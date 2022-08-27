package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 买卖股票的最佳时机 二
 * @author wan
 * @date 2022.08.27 09:44
 ******************************************/
public class LeetCode122 {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int hold = -prices[0], sale = 0;
        for (int price : prices) {
            hold = Math.max(sale - price, hold);
            sale = Math.max(price + hold, sale);
        }
        return sale;
    }

    public static void main(String[] args) {
        LeetCode122 lc = new LeetCode122();
    }

}
