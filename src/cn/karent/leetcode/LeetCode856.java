package cn.karent.leetcode;

import java.util.*;

/**
 * 括号的分数
 */
public class LeetCode856 {

    public int scoreOfParentheses(String S) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if( ch == '(') {
                st.push(0);
            } else {
                int v = st.pop();
                int w = st.pop();
                st.push(w + Math.max(2 * v, 1));
            }
        }
        return st.pop();
    }

}
