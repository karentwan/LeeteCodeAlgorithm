package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 统计一个数组中好对子的数目
 * @author wan
 * @date 2021.06.05
 ********************************************/
public class LeetCode1814 {

    private int reverse(int n) {
        int ret = 0;
        while ( n > 0) {
            ret = ret * 10 + n % 10;
            n /= 10;
        }
        return ret;
    }

    public int countNicePairs(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        long ret = 0;
        int mod = ((int) (1e9 + 7));
        for (int num : nums) {
            int t = num - reverse(num);
            int v = map.getOrDefault(t, 0);
            ret = (ret + v) % mod;
            map.put(t, v + 1);
        }
        return ((int) ret);
    }

    public static void main(String[] args) {
        LeetCode1814 lc = new LeetCode1814();
        int[] arr = {42, 11, 1, 97};
        int ret = lc.countNicePairs(arr);
        System.out.println(ret);
    }

}
