package cn.karent.leetcode_v3.weeklycontest237;

import java.util.*;

/**
 * 雪糕的最大数量
 * @author wan
 * @date 2021.04.18
 */
public class Algo5735 {

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int ret = 0;
        for (int i = 0; i < costs.length && coins >= costs[i]; i++) {
            ret++;
            coins -= costs[i];
        }
        return ret;
    }

    public static void main(String[] args) {
        Algo5735 lc = new Algo5735();
        int[] costs = {1,3,2,4,1};
        int coins = 7;
        int ret = lc.maxIceCream(costs, coins);
        System.out.println(ret);
    }

}
