package cn.karent.leetcode;

import java.util.*;

/**
 * 迷你语法分析器
 */
public class LeetCode385 {

    class NestedInteger {

        public NestedInteger() {}

        public NestedInteger(int value) {

        }

        public boolean isInteger() {
            return true;
        }

        public Integer getInteger() {
            return 0;
        }

        public void setInteger(int value) {

        }

        public void add(NestedInteger ni) {

        }

        public List<NestedInteger> getList() {
            return null;
        }
    }

    public NestedInteger deserialize(String s) {
        if(s.length() == 0) {
            return new NestedInteger();
        }
        if( s.charAt(0) != '[') {
            return new NestedInteger(Integer.valueOf(s));
        }
        Stack<NestedInteger> st = new Stack<>();
        NestedInteger ans = null;
        int number = 0;
        int sign = 1;   // true为正
        boolean isNumber = false;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if( ch >= '0' && ch <= '9') {
                number = number * 10 + (ch - '0');
                isNumber = true;
            } else if( ch == '-') {
                sign = -1;
            } else if( ch == '[') {
                NestedInteger ni = new NestedInteger();
                st.push(ni);
            } else if( ch == ',') {
                if( isNumber ) {
                    number *= sign;
                    NestedInteger ni = st.peek();
                    ni.add(new NestedInteger(number));
                }
                // 清零
                number = 0;
                isNumber = false;
                sign = 1;
            } else if( ch == ']') {
                if( isNumber ) {
                    number *= sign;
                    NestedInteger ni = st.peek();
                    ni.add(new NestedInteger(number));
                }
                // 清零
                number = 0;
                isNumber = false;
                sign = 1;
                NestedInteger pop = st.pop();
                if( !st.isEmpty()) {
                    NestedInteger p = st.peek();
                    p.add(pop);
                }
                ans = pop;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode385 lc = new LeetCode385();
        String s = "[123,[456,[789]]]";
        NestedInteger ans = lc.deserialize(s);
    }

}

