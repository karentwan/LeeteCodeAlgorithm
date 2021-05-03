package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 受标签影响的最大值
 * @author wan
 * @date 2021.04.15
 */
public class LeetCode1090 {

    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        PriorityQueue<Integer> que = new PriorityQueue<>((k1, k2) -> values[k2] - values[k1]);
        for (int i = 0; i < values.length; i++) {
            que.offer(i);
        }
        int[] cache = new int[20001];
        int sum = 0;
        while (!que.isEmpty() && num_wanted > 0) {
            int idx = que.poll();
            if( cache[labels[idx]] < use_limit) {
                sum += values[idx];
                cache[labels[idx]]++;
                num_wanted--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        LeetCode1090 lc = new LeetCode1090();
//        int[] values = {5,4,3,2,1};
//        int[] labels = {1,3,3,3,2};
//        int num_wanted = 3;
//        int use_limit = 2;
//        int[] values = {5,4,3,2,1};
//        int[] labels = {1,1,2,2,3};
//        int num_wanted = 3;
//        int use_limit = 1;
        int[] values = {9,8,8,7,6};
        int[] labels = {0,0,0,1,1};
        int num_wanted = 3;
        int use_limit = 1;
        int ret = lc.largestValsFromLabels(values, labels, num_wanted, use_limit);
        System.out.println(ret);
    }

}
