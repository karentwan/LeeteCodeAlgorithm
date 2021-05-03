package cn.karent.leetcode_v2;

import java.util.*;

/**
 * 非递增顺序的最小子序列
 */
public class LeetCode1403 {

    public List<Integer> minSubsequence(int[] nums) {
        Integer[] tmps = new Integer[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            tmps[i] = nums[i];
            sum += nums[i];
        }
        Arrays.sort(tmps, (k1, k2) -> {
            return k2 - k1;
        });
        int ret = 0;
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while (ret <= sum - ret) {
            list.add(tmps[i]);
            ret+= tmps[i];
            i++;
        }
        return list;
    }

    public static void main(String[] args) {
        LeetCode1403 lc = new LeetCode1403();
//        int[] nums = {4,3,10,9,8};
        int[] nums = {4,4,7,6,7};
        List<Integer> ret = lc.minSubsequence(nums);
        System.out.println(ret);
    }

}
