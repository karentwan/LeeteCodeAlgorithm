package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 买股票的最佳时机含手续费
 * @author wan
 * @date 2022.08.27 09:04
 ******************************************/
public class LeetCode714 {

    public int maxProfit(int[] prices, int fee) {
        int hold = Integer.MIN_VALUE, sale = 0;
        for (int price : prices) {
            hold = Math.max(sale - price, hold);
            sale = Math.max(sale, price + hold - fee);
        }
        return sale;
    }

    public static void main(String[] args) {
        LeetCode714 lc = new LeetCode714();
        int[] prices = {1,3,2,8,4,9};
        int fee = 2;
        System.out.println(lc.maxProfit(prices, fee));
    }

}
