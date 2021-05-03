package cn.karent.leetcode;

import java.util.*;

/**
 * 三角形的最大周长
 */
public class LeetCode976 {

    public int largestPerimeter(int[] A) {
        if( A.length < 3) {
            return 0;
        }
        Arrays.sort(A);
        int a = A.length-1;
        while( a >= 2) {
            int b = a-1;
            int c = a-2;
            if( A[b] + A[c] > A[a]) {
                return A[b] + A[c] + A[a];
            }
            a--;
        }
        return 0;
    }

    public static void main(String[] args) {
        LeetCode976 lc = new LeetCode976();
//        int[] nums = {2,1,2};
//        int[] nums = {1,2,1};
        int[] nums = {3,2,3,4};
        int ret = lc.largestPerimeter(nums);
        System.out.println(ret);
    }

}
