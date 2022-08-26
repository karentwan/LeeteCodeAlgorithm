package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 数组中两元素的最大乘积
 * @author wan
 * @date 2022.08.26 08:12
 ******************************************/
public class LeetCode1464 {

    public int maxProduct(int[] nums) {
        int first = 0, second = 0;
        for (int num : nums) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second) {
                second = num;
            }
        }
        return (first - 1) * (second - 1);
    }

    public static void main(String[] args) {
        LeetCode1464 lc = new LeetCode1464();
        int[] nums = {3,4,5,2};
        System.out.println(lc.maxProduct(nums));
    }

}
