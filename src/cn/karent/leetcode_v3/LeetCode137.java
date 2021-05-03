package cn.karent.leetcode_v3;

import java.util.*;

/********************************************
 * description: 只出现一次的数字 二
 * @author wan
 * @date 2021.04.30
 ********************************************/
public class LeetCode137 {

    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        // 异或, 不进位加法
        for (int num : nums) {
            b = (~a) & (num ^ b);
            a = (~b) & (num ^ a);
        }
        return b;
    }

    public static void main(String[] args) {
        LeetCode137 lc = new LeetCode137();
//        int[] nums = {2, 2, 3, 2};
        int[] nums = {0,1,0,1,0,1,99};
        int ret = lc.singleNumber(nums);
        System.out.println(ret);
    }

}
