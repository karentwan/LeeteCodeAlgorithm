package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 同积元组
 * @author wan
 * @date 2021.06.05
 ********************************************/
public class LeetCode1726 {

/*
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int k = nums[i] * nums[j];
                map.put(k, map.getOrDefault(k, 0) + 1);
            }
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int k = nums[i] * nums[j];
                int v = (map.get(k) - 1) * 4;
                ret += v;
            }
        }
        return ret;
    }
   */

    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int k = nums[i] * nums[j];
                map.put(k, map.getOrDefault(k, 0) + 1);
            }
        }
        int ret = 0;
        Iterator<Map.Entry<Integer, Integer>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            int v = iter.next().getValue();
            ret += v * (v - 1) / 2 * 8;
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1726 lc = new LeetCode1726();
        int[] arr = {2, 3, 4, 6};
        int ret = lc.tupleSameProduct(arr);
        System.out.println(ret);
    }

}
