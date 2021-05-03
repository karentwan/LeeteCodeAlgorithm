package cn.karent.leetcode_v3;

import java.util.*;

/********************************************
 * description: 加油站
 * @author wan
 * @date 2021.04.25
 ********************************************/
public class LeetCode134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int sum = 0;
        int idx = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if( sum < 0) {
                idx = (i + 1 + gas.length) % gas.length;
                sum = 0;
            }
        }
        return total >= 0 ? idx : -1;
    }

    public static void main(String[] args) {
        LeetCode134 lc = new LeetCode134();
//        int[] gas = {1, 2, 3, 4, 5};
//        int[] cost = {3, 4, 5, 1, 2};
        int[] gas = {2,3,4};
        int[] cost = {3,4,3};
        int ret = lc.canCompleteCircuit(gas, cost);
        System.out.println(ret);
    }

}
