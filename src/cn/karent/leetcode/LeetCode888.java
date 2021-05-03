package cn.karent.leetcode;

import java.util.*;

/**
 * 公平的糖果棒交换
 * sumA - sumB = d
 * 定义A, B两个数组中要交换的两个元素为Xa和Xb(交换后两个数组和相等), 则Xa - Xb = d/2;
 */
public class LeetCode888 {

    public int[] fairCandySwap(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int a = 0, b = 0;
        for(int i = 0; i < A.length; i++) {
            a += A[i];
        }
        for(int i = 0; i < B.length; i++) {
            b += B[i];
        }
        int i = 0, j = 0;
        int[] ret = new int[2];
        int target = (a - b) / 2;
        while( i < A.length && j < B.length) {
            int tmp = A[i] - B[j];
            if( tmp == target) {
                ret[0] = A[i];
                ret[1] = B[j];
                break;
            } else if( tmp < target) {
                i++;
            } else {
                j++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode888 lc = new LeetCode888();
//        int[] A = {1,1};
//        int[] B = {2,2};
        int[] A = {1,2,5};
        int[] B = {2,4};
        int[] ret = lc.fairCandySwap(A, B);
        System.out.println("A:" + ret[0] + "\tB:" + ret[1]);
    }
}
