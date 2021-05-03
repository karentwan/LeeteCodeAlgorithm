package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 判断能否形成等差数列
 * @author wan
 * @date 2021.04.09
 */
public class LeetCode1502 {

    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int i = 2;
        for (; i < arr.length; i++) {
            if( arr[i] - arr[i-1] != arr[i-1] - arr[i-2]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }

}
