package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 使数组唯一的最小增量
 * @author wan
 * @date 2021.05.15
 ********************************************/
public class LeetCode945 {

    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        if( A.length == 0) return 0;
        int last = A[0];
        int ret = 0;
        for (int i = 1; i < A.length; i++) {
            if( A[i] <= last) {
                last++;
                ret += last - A[i];
            } else {
                last = A[i];
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode945 lc = new LeetCode945();
//        int[] arr = {1, 2, 2};
        int[] arr = {3,2,1,2,1,7};
        System.out.println(lc.minIncrementForUnique(arr));
    }

}
