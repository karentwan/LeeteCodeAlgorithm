package cn.karent.leetcode_v1;

import java.util.*;

/**
 * 删除字符中的所有相邻重复项
 */
public class LeetCode1047 {

/*
    public String removeDuplicates(String S) {
        if( S.length() == 0) {
            return "";
        }
        Stack<Character> st = new Stack<>();
        char[] chs = S.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if( !st.isEmpty() && chs[i] == st.peek()) {
                st.pop();
            } else {
                st.push(chs[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while( !st.isEmpty() ) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
*/

    public String removeDuplicates(String S) {
        if( S.length() == 0) {
            return "";
        }
        char[] chs = S.toCharArray();
        int top = 0;
        for (char ch : chs) {
            if( top == 0 || chs[top-1] != ch) {
                chs[top++] = ch;
            } else {
                top--;
            }
        }
        return new String(chs, 0, top);
    }

    public static void main(String[] args) {
        LeetCode1047 lc = new LeetCode1047();
        String s = "abbaca";
        String ret = lc.removeDuplicates(s);
        System.out.println(ret);
    }

}
