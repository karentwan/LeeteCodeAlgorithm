package cn.karent.leetcode_v1;

import java.util.*;

/**
 * 下一个更大的元素 二
 */
public class LeetCode503 {

    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] rets = new int[n];
        Arrays.fill(rets, -1);
        for (int i = 0; i < n; i++) {
            while( !st.isEmpty() && nums[i] > nums[st.peek()]) {
                rets[st.pop()] = nums[i];
            }
            st.push(i);
        }
        for (int i = 0; i < n && !st.isEmpty(); i++) {
            while ( !st.isEmpty() && nums[i] > nums[st.peek()]) {
                rets[st.pop()] = nums[i];
            }
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode503 lc = new LeetCode503();
        int[] nums = {1,2,1};
        int[] rets = lc.nextGreaterElements(nums);
        for (int ret : rets) {
            System.out.print(ret + " ");
        }
        System.out.println();
    }

}
