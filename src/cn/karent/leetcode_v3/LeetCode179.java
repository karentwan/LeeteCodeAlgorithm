package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 最大数
 * @author wan
 * @date 2021.04.12
 */
public class LeetCode179 {

    public String largestNumber(int[] nums) {
        Integer[] tmps = new Integer[nums.length];
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if( nums[i] != 0) {
                flag = true;
            }
            tmps[i] = nums[i];
        }
        if( !flag ) {
            return "0";
        }
        Arrays.sort(tmps, (k1, k2) -> {
            String s1 = String.valueOf(k1);
            String s2 = String.valueOf(k2);
            return (s2 + s1).compareTo(s1 + s2);
        });
        StringBuilder sb = new StringBuilder();
        for (Integer tmp : tmps) {
            sb.append(tmp);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode179 lc = new LeetCode179();
        int[] nums = {3,30,34,5,9};
        String s = lc.largestNumber(nums);
        System.out.println(s);
    }

}
