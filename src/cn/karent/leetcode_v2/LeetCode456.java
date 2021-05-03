package cn.karent.leetcode_v2;

import java.util.*;

/**
 * 132模式
 */
public class LeetCode456 {

    public boolean find132pattern(int[] nums) {
        if( nums.length < 3) {
            return false;
        }
        Stack<Integer> st = new Stack<>();
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min[i] = Math.min(min[i-1], nums[i]);
        }
        for (int i = nums.length-1; i >= 0; i--) {
            if( nums[i] > min[i]) {  // 首先保证nums[i]之前的最小值不可能是nums[i]本身
                // 为什么这个能保证栈里面的元素都是大于min[i]的？, 这个栈从栈底到栈顶是单调递减的
                while( !st.isEmpty() && st.peek() <= min[i]) {
                    st.pop();
                }
                if( !st.isEmpty() && st.peek() < nums[i]) {
                    return true;
                }
                // 只有nums[i]小于栈顶元素才会入栈, 否则就直接return
                st.push(nums[i]);
            }
        }
        return false;
    }

}
