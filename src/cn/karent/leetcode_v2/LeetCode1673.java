package cn.karent.leetcode_v2;

import java.util.*;

/**
 * 找出最具竞争力的子序列
 */
public class LeetCode1673 {

    public int[] mostCompetitive(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> que = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!que.isEmpty() && (n - i + que.size() > k && nums[i] < nums[que.peekLast()])) {
                que.pollLast();
            }
            if( que.size() < k) {
                que.offerLast(i);
            }
        }
        int[] rets = new int[k];
        for (int i = 0; i < k && !que.isEmpty(); i++) {
            rets[i] = nums[que.pollFirst()];
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode1673 lc = new LeetCode1673();
//        int[] nums = {3,5,2,6};
//        int k = 2;
//        int[] nums = {2,4,3,3,5,4,9,6};
//        int k = 4;
        int[] nums = {71,18,52,29,55,73,24,42,66,8,80,2};
        int k = 3;
        int[] rets = lc.mostCompetitive(nums, k);
        for (int ret : rets) {
            System.out.print(ret + " ");
        }
        System.out.println();
    }

}
