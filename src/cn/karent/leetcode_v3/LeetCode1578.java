package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 避免重复字母的最小删除成本
 * @author wan
 * @date 2021.04.13
 */
public class LeetCode1578 {

    public int minCost(String s, int[] cost) {
        int i = 0, j = 0;
        int ret = 0;
        while (i < s.length()) {
            j = i+1;
            int sum = cost[i];
            int max = cost[i];
            while (j < s.length() && s.charAt(j) == s.charAt(i)) {
                sum += cost[j];
                max = Math.max(max, cost[j]);
                j++;
            }
            sum -= max;
            ret += sum;
            i = j;
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1578 lc = new LeetCode1578();
//        String s = "abaac";
//        int[] cost = {1,2,3,4,5};
//        String s = "abc";
//        int[] cost = {1,2,3};
        String s = "bbbaaa";
        int[] cost = {4,9,3,8,8,9};
        int ret = lc.minCost(s, cost);
        System.out.println(ret);
    }

}
