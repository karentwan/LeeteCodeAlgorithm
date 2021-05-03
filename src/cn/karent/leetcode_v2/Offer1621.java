package cn.karent.leetcode_v2;

import java.util.*;

import cn.karent.util.*;


/**
 * 交换和
 * @author wan
 * @date 2021.04.05
 */
public class Offer1621 {

    public int[] findSwapValues(int[] array1, int[] array2) {
        int sum1 = 0, sum2 = 0, sum = 0;
        for (int i : array1) {
            sum1 += i;
        }
        for (int i : array2) {
            sum2 += i;
        }
        sum = sum1 + sum2;
        if( sum % 2 != 0) {
            return new int[0];
        }
        sum /= 2;
        int mid = sum1 - sum;
        Arrays.sort(array1);
        Arrays.sort(array2);
        int i = 0, j = 0;
        while ( i < array1.length && j < array2.length ) {
            int t = array1[i] - array2[j];
            if( t == mid) {
                return new int[]{array1[i], array2[j]};
            } else if( t < mid) {
                i++;
            } else {
                j++;
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        Offer1621 offer = new Offer1621();
//        int[] array1 = {4, 1, 2, 1, 1, 2};
//        int[] array2 = {3, 6, 3, 3};
        int[] array1 = {1, 2, 3};
        int[] array2 = {4, 5, 6};
        int[] rets = offer.findSwapValues(array1, array2);
        for (int ret : rets) {
            System.out.print(ret + " ");
        }
        System.out.println();
    }

}
