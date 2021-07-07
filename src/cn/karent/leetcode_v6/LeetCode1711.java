package cn.karent.leetcode_v6;

import java.util.*;

/***********************************************
 * description: 大餐计数
 * @author wan
 * @date 2021.07.07
 ***********************************************/
public class LeetCode1711 {

    public int countPairs(int[] deliciousness) {
        int mod = 1000_000_007;
        int ret = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int maxVal = 0;
        for (int d : deliciousness) {
            maxVal = Math.max(maxVal, d);
        }
        maxVal *= 2;
        for (int d : deliciousness) {
            for (int i = 1; i <= maxVal; i <<= 1) {
                int v = map.getOrDefault(i - d, 0);
                ret = (ret + v) % mod;
            }
            map.put(d, map.getOrDefault(d, 0) + 1);
        }
        return ret;
    }

    public static void main(String[] args) {

    }

}
