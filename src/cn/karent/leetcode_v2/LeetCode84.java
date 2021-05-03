package cn.karent.leetcode_v2;

import java.util.*;

/**
 * 柱状图中最大的矩形
 */
public class LeetCode84 {

    public int largestRectangleArea(int[] heights) {
        int ret = 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int i = 0;
        for (i = 0; i < heights.length; i++) {
            while ( st.peek() >= 0 && heights[i] < heights[st.peek()]) {
                int h = heights[st.pop()];
                int w = i - st.peek() - 1;
                ret = Math.max(ret, h * w);
            }
            st.push(i);
        }
        while (st.peek() >= 0) {
            int h = heights[st.pop()];
            int w = i - st.peek() - 1;
            ret = Math.max(ret, h * w);
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode84 lc = new LeetCode84();
//        int[] nums = {2,1,5,6,2,3};
        int[] nums = {5,4,0,2};
        int ret = lc.largestRectangleArea(nums);
        System.out.println(ret);
    }

}
