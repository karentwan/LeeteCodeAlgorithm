package cn.karent.leetcode;

import java.util.*;

/**
 * 最大数
 */
public class LeetCode179 {


    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (String s1, String s2) -> {
           String tmp1 = s1 + s2;
           String tmp2 = s2 + s1;
           return tmp2.compareTo(tmp1);
        });
        if( strs[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }
        return sb.toString();
    }

}
