package cn.karent.leetcode_v3.weeklycontest237;

import java.util.*;

/**
 * 所有数对按位与结果的异或和
 * @author wan
 * @date 2021.04.18
 */
public class Algo5737 {

    public int getXORSum(int[] arr1, int[] arr2) {
        int s1 = 0;
        for (int item : arr1) {
            s1 ^= item;
        }
        int s2 = 0;
        for (int item : arr2) {
            s2 ^= item;
        }
        return s1 & s2;
    }

    public static void main(String[] args) {

    }

}
