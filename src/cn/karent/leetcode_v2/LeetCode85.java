package cn.karent.leetcode_v2;

import java.util.*;

/**
 * 最大矩形
 */
public class LeetCode85 {

    private int largestHeights(int[] heights) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);  // 哨兵节点, dummy, 雷打不动
        int i = 0;
        int ret = 0;
        for (; i < heights.length; i++) {
            while ( st.peek() >= 0 && heights[i] < heights[st.peek()]) {
                int h = heights[st.pop()];
                int w = i - st.peek() - 1;
                ret = Math.max(ret, h * w);
            }
            st.push(i);
        }
        while ( st.peek() >= 0) {
            int h = heights[st.pop()];
            int w = i - st.peek() - 1;
            ret = Math.max(ret, h * w);
        }
        return ret;
    }

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if( m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[] heights = new int[n];
        int ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                heights[j] = matrix[i][j] == '1' ? heights[j]+1 : 0;
            }
            ret = Math.max(ret, largestHeights(heights));
        }
        return ret;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        LeetCode85 lc = new LeetCode85();
        int ret = lc.maximalRectangle(matrix);
        System.out.println(ret);
    }

}
