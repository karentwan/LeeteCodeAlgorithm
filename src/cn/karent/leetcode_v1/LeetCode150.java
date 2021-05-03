package cn.karent.leetcode_v1;

import java.util.*;

/**
 * 逆波兰表达式求值
 */
public class LeetCode150 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int n1, n2, n3;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    n2 = st.pop();
                    n1 = st.pop();
                    n3 = n1 + n2;
                    st.push(n3);
                    break;
                case "-":
                    n2 = st.pop();
                    n1 = st.pop();
                    n3 = n1 - n2;
                    st.push(n3);
                    break;
                case "*":
                    n2 = st.pop();
                    n1 = st.pop();
                    n3 = n1 * n2;
                    st.push(n3);
                    break;
                case "/":
                    n2 = st.pop();
                    n1 = st.pop();
                    n3 = n1 / n2;
                    st.push(n3);
                    break;
                default:
                    st.push(Integer.valueOf(token));
                    break;
            }
        }
        return st.pop();
    }

}
