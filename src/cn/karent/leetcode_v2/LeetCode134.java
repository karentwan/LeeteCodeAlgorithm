package cn.karent.leetcode_v2;

import java.util.*;
import cn.karent.util.*;


/**
 * 加油站
 * @author wan
 * @date 2021.04.04
 */
public class LeetCode134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0, total = 0;
        int idx = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if( sum < 0) {
                sum = 0;
                idx = i + 1;
            }
        }
        return total >= 0 ? idx : -1;
    }

    public static void main(String[] args) {

    }

}
