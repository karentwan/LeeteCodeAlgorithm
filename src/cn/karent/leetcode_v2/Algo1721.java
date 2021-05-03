package cn.karent.leetcode_v2;

import java.util.*;

/**
 * 接雨水
 */
public class Algo1721 {

    public int trap(int[] height) {
        Stack<Integer> st = new Stack<>();
        int ret = 0;
        for (int i = 0; i < height.length; i++) {
            while ( !st.isEmpty() && height[i] > height[st.peek()]) {
                int top = st.pop();
                if( st.isEmpty() ) {
                    break;
                }
                int left = st.pop();
                int width = i - left - 1;
                int h = Math.min(height[left], height[i]) - height[top];
                ret += width * h;
                st.push(left);
            }
            st.push(i);
        }
        return ret;
    }

}
