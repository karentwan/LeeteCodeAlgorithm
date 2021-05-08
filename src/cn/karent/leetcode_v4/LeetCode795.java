package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 区间子数组个数
 * @author wan
 * @date 2021.05.08
 ********************************************/
public class LeetCode795 {

    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        return count(A, R) - count(A, L-1);
    }

    private int count(int[] A, int bound) {
        int ret = 0, cur = 0;
        for (int item : A) {
            cur = item <= bound ? cur + 1 : 0;
            ret += cur;
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode795 lc = new LeetCode795();
        int[] A = {2, 1, 4, 3};
        int L = 2;
        int R = 3;
//        int[] A = {};
//        int L = 2;
//        int R = 3;
        int ret = lc.numSubarrayBoundedMax(A, L, R);
        System.out.println(ret);
    }

}
