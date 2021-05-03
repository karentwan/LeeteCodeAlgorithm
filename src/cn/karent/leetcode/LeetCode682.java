package cn.karent.leetcode;

import java.util.*;

/**
 * 棒球比赛
 */
public class LeetCode682 {

    public int calPoints(String[] ops) {
        Stack<String> st = new Stack<>();
        for(String s : ops) {
            if( s.equals("C")) {
                st.pop();
            } else if( s.equals("D")) {
                int t = Integer.parseInt(st.peek()) * 2;
                st.push(String.valueOf(t));
            } else if( s.equals("+")) {
                String s1 = st.pop();
                String s2 = st.pop();
                String s3 = String.valueOf(Integer.parseInt(s1) + Integer.parseInt(s2));
                st.push(s2);
                st.push(s1);
                st.push(s3);
            } else {
                st.push(s);
            }
        }
        int ret = 0;
        while( !st.isEmpty()) {
            ret += Integer.parseInt(st.pop());
        }
        return ret;
    }
}
