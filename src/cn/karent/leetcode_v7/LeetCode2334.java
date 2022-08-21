package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 元素值大于变化阈值的子数组
 * @author wan
 * @date 2022.08.21 17:51
 ******************************************/
public class LeetCode2334 {

    public int validSubarraySize(int[] nums, int threshold) {
        // 单调栈
        Deque<Integer> st = new ArrayDeque<>();
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            while (!st.isEmpty() && nums[i] <= nums[st.peekLast()]) {
                st.pollLast();
            }
            left[i] = st.isEmpty() ? -1 : st.peekLast();
            st.offerLast(i);
        }
        st.clear();
        for (int i = nums.length-1; i >= 0; i--) {
            while (!st.isEmpty() && nums[i] <= nums[st.peekLast()]) {
                st.pollLast();
            }
            right[i] = st.isEmpty() ? nums.length:st.peekLast();
            st.offerLast(i);
        }
        for (int i = 0; i < nums.length; i++) {
            int k = right[i] - left[i] - 1;
            if (nums[i] > threshold / k) return k;
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode2334 lc = new LeetCode2334();
        int[] arr = {1,3,4,3,1};
        int th = 6;
        System.out.println(lc.validSubarraySize(arr, th));
    }

}
