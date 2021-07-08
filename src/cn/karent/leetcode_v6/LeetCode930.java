package cn.karent.leetcode_v6;

import java.util.*;

/***********************************************
 * description: 和相同的二元子数组
 * @author wan
 * @date 2021.07.08
 ***********************************************/
public class LeetCode930 {

    public int numSubarraysWithSum(int[] nums, int goal) {
        int ret = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            ret += map.getOrDefault(sum - goal, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ret;
    }

    public static void main(String[] args) {

    }

}
