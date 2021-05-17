package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 和可被k整除的子数组
 * @author wan
 * @date 2021.05.17
 ********************************************/
public class LeetCode974 {

    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, ret = 0;
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            int m = (sum % k + k) % k;
            int same = map.getOrDefault(m, 0);
            ret += same;
            map.put(m, same+1);
        }
        return ret;
    }

    public static void main(String[] args) {

    }

}
