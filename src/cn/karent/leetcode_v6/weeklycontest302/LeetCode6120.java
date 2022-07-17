package cn.karent.leetcode_v6.weeklycontest302;

import java.util.*;

/******************************************
 * 数组中能形成多少数对
 * @author wan
 * @date 2022.07.17 10:31
 ******************************************/
public class LeetCode6120 {

    public int[] numberOfPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] rets = new int[2];
        for (Map.Entry<Integer, Integer> kv : map.entrySet()) {
            Integer value = kv.getValue();
            rets[0] += value / 2;
            rets[1] += value % 2;
        }
        return rets;
    }

    public static void main(String[] args) {

    }

}
