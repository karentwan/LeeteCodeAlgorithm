package cn.karent.leetcode_v3;

import java.util.*;

/**
 * k次取反后最大化的数组和
 * @author wan
 * @date 2021.04.15
 */
public class LeetCode1005 {

    public int largestSumAfterKNegations(int[] A, int K) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>((k1, k2) -> A[k1] - A[k2]);
        for (int i = 0; i < A.length; i++) {
            if( A[i] < 0) que.offer(i);
            else {
                sum += A[i];
                min = Math.min(min, A[i]);
            }
        }
        while (!que.isEmpty() && K > 0) {
            int idx = que.poll();
            sum -= A[idx];
            K--;
            min = Math.min(min, -A[idx]);
        }
        while (!que.isEmpty()) {
            sum += A[que.poll()];
        }
        if( K % 2 != 0) sum -= 2 * min;
        return sum;
    }

    public static void main(String[] args) {
        LeetCode1005 lc = new LeetCode1005();
//        int[] nums = {4,3,2};
//        int k = 1;
//        int[] nums = {3,-1,0,2};
//        int k = 3;
        int[] nums = {2,-3,-1,5,-4};
        int k = 2;
        int ret = lc.largestSumAfterKNegations(nums, k);
        System.out.println(ret);
    }

}
