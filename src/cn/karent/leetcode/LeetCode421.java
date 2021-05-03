package cn.karent.leetcode;

import java.util.*;

/**
 * 数组中两个数的最大异或值
 * a ^ b = c ==> a ^ c = b ==> b ^ c = a
 * 异或就是不进位的加法
 */
public class LeetCode421 {

    public int findMaximumXOR(int[] nums) {
        int ret = 0;
        int mask = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 30; i >= 0; i--) {
            mask = mask | (1 << i);
            set.clear();
            for(int n : nums) {
                set.add( n & mask);
            }
            int tmp = ret | (1 << i);
            for(int k : set) {
                if( set.contains(tmp ^ k) ) {
                    ret = tmp;
                    break;
                }
            }
        }
        return ret;
    }
}
