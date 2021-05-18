package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 形成两个异或相等数组的三元组数目
 * @author wan
 * @date 2021.05.18
 ********************************************/
public class LeetCode1442 {

    public int countTriplets(int[] arr) {
        int n = arr.length;
        int[] prev = new int[n+1];
        for (int i = 1; i <= n; i++) {
            prev[i] = prev[i-1] ^ arr[i-1];
        }
        int ret = 0;
        for (int i = 0; i < n+1; i++) {
//            for (int j = i+1; j < n+1; j++) {
//                for (int k = j+1; k < n+1; k++) {
//                    if( (prev[k] ^ prev[j]) == (prev[j] ^ prev[i])) ret++;
//                }
//            }
            for (int j = i+1; j < n+1; j++) {
                if( prev[i] == prev[j]) ret += j-i-1;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1442 lc = new LeetCode1442();
//        int[] arr = {2, 3, 1, 6, 7};
//        int[] arr = {1,1,1,1,1};
//        int[] arr = {2,3};
        int[] arr = {7,11,12,9,5,2,7,17,22};
        int ret = lc.countTriplets(arr);
        System.out.println(ret);
    }

}
