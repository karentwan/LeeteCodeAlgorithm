package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 区间子数组个数
 * @author wan
 * @date 2022.11.24 15:59
 ******************************************/
public class LeetCode795 {

    public int numSubarrayBoundedMax1(int[] nums, int left, int right) {
        int size = nums.length;
        int[] lm = new int[size];
        int[] rm = new int[size];
        Deque<Integer> st = new ArrayDeque<>();
        Arrays.fill(lm, -1);
        Arrays.fill(rm, size);
        for (int i = 0; i < size; i++) {
            while (!st.isEmpty() && nums[i] > nums[st.peekLast()]) {
                rm[st.pollLast()] = i;
            }
            st.offerLast(i);
        }
        st.clear();
        for (int i = size-1; i >= 0; i--) {
            while (!st.isEmpty() && nums[i] >= nums[st.peekLast()]) {
                lm[st.pollLast()] = i;
            }
            st.offerLast(i);
        }
        int ret = 0;
        for (int i = 0; i < size; i++) {
            if (nums[i] >= left && nums[i] <= right) {
                ret += (rm[i] - i) * (i - lm[i]);
            }
        }
        return ret;
    }

    private int count(int[] nums, int bound) {
        int ret = 0, cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if ( nums[i] <= bound) {
                cur++;
            } else cur = 0;
            ret += cur;
        }
        return ret;
    }

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return count(nums, right) - count(nums, left - 1);
    }

    public static void main(String[] args) {
        LeetCode795 lc = new LeetCode795();
//        int[] nums = {2,1,4,3};
//        int left = 2;
//        int right = 3;
        int[] nums = {2,9,2,5,6};
        int left = 2;
        int right = 8;
        System.out.println(lc.numSubarrayBoundedMax(nums, left, right));
    }

}
