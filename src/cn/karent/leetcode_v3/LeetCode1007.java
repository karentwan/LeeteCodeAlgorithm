package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 行相等的最少多米诺旋转
 * @author wan
 * @date 2021.04.15
 */
public class LeetCode1007 {

    private int check(int x, int[] A, int[] B) {
        int n = A.length;
        int a = 0, b = 0;  // 翻转多少次让A全部为x, 翻转多少次让B全部为y
        for (int i = 0; i < n; i++) {
            if(A[i] != x && B[i] != x) return -1;
            else if( A[i] != x) a++;
            else if( B[i] != x) b++;  // 之所以不用else, 因为可能A[i] = B[i] = x
        }
        return Math.min(a, b);
    }

    public int minDominoRotations(int[] A, int[] B) {
        int ret = 0;
        if( A.length == 0) return ret;
        if((ret = check(A[0], A, B)) == -1) return check(B[0], A, B);
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1007 lc = new LeetCode1007();
        int[] A = {2,1,2,4,2,2};
        int[] B = {5,2,6,2,3,2};
        int ret = lc.minDominoRotations(A,B);
        System.out.println(ret);
    }

}
