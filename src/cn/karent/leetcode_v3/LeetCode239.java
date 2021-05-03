package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 滑动窗口最大值
 * @author wan
 * @date 2021.04.10
 */
public class LeetCode239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if( nums.length == 0) {
            return new int[0];
        }
        Deque<Integer> que = new LinkedList<>();  // 单调栈
        int[] rets = new int[nums.length-k+1];
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            while ( !que.isEmpty() && nums[i] > nums[que.peekLast()]) {
                que.pollLast();
            }
            que.offerLast(i);
            if( i - que.peekFirst() >= k) {
                que.pollFirst();
            }
            if( i >= k-1) {
                rets[idx++] = nums[que.peekFirst()];
            }
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode239 lc = new LeetCode239();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
//        int[] nums = {1};
//        int k = 1;
//        int[] nums = {1,-1};
//        int k = 1;
        int[] rets = lc.maxSlidingWindow(nums, k);
        for (int ret : rets) {
            System.out.print(ret + " ");
        }
        System.out.println();
    }

}
