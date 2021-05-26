package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 反转每对括号间的子串
 * @author wan
 * @date 2021.05.26
 ********************************************/
public class LeetCode1190 {

    public String reverseParentheses(String s) {
        char[] chs = s.toCharArray();
        Stack<Character> st = new Stack<>();
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < chs.length; i++) {
            if( chs[i] == ')') {
                StringBuilder sb = new StringBuilder();
                while (!st.isEmpty() && st.peek() != '(') {
                    sb.append(st.pop());
                }
                if( !st.isEmpty() ) st.pop();
                for (int j = 0; j < sb.length(); j++) {
                    st.push(sb.charAt(j));
                }
            } else st.push(chs[i]);
        }
        while (!st.isEmpty()) {
            ret.append(st.pop());
        }
        return ret.reverse().toString();
    }

    public static void main(String[] args) {
        LeetCode1190 lc = new LeetCode1190();
//        String s = "(abcd)";
//        String s = "(u(love)i)";
        String s = "a(bcdefghijkl(mno)p)q";
        String ret = lc.reverseParentheses(s);
        System.out.println(ret);
    }

}
