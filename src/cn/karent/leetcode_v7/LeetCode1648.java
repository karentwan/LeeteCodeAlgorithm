package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 销售价值减少的颜色球
 * @author wan
 * @date 2022.10.07 11:40
 ******************************************/
public class LeetCode1648 {

    public int maxProfit(int[] inventory, int orders) {
        int mod = 1000_000_007;
        int size = inventory.length;
        Arrays.sort(inventory);
        int l = 0, r = inventory[size-1];
        while (l <= r) {
            int m = l + (r - l)/2;
            if (order(inventory, m) > orders) {
                l = m+1;
            } else {
                r = m-1;
            }
        }
        long ret = 0;
        for (int i : inventory) {
            if (i > l) {
                ret += ((i - l) * 1L * (i + l + 1)) / 2;
                ret %= mod;
                orders -= i - l;
            }
        }
        return (int) ((ret + orders * 1L * l) % mod);
    }

    private long order(int[] inventory, int target) {
        long ret = 0;
        for (int i : inventory) {
            if (i > target) {
                ret += i - target;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1648 lc = new LeetCode1648();
//        int[] inventory = {2,5};
//        int orders = 4;
//        int[] inventory = {3,5};
//        int orders = 6;
//        int[] inventory = {1000000000};
//        int orders = 1000000000;
//        int[] inventory = {497978859,167261111,483575207,591815159};
//        int orders = 836556809;
//        int[] inventory = {701695700,915736894,35093938,364836059,452183894,951826038,861556610,441929847,842650446,858413011,457896886,35119509,776620034,396643588,83585103,681609037};
//        int orders = 598226067;
        int[] inventory = {565259708,715164401,716563713,958255469,844600740,823949511,180479359,287829385,164248818,73361150,230686692,322986846,598720034,338241127,748922260,181241085,833659853,509571179,250093451,690995620,703292727,595636202};
        int orders = 650114768;
        System.out.println(lc.maxProfit(inventory, orders));
    }

}
