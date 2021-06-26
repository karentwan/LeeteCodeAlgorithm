package cn.karent.leetcode_v5;

import java.util.*;

/***********************************************
 * description: 有效的括号字符串
 * @author wan
 * @date 2021.06.26
 ***********************************************/
public class LeetCode678 {

    public boolean checkValidString(String s) {
        char[] chs = s.toCharArray();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < chs.length; i++) {
            if( chs[i] == '(') {
                st.push('(');
            } else if( chs[i] == '*') {
                st.push('*');
            } else {
                int cnt = 0;
                while (!st.isEmpty() && st.peek() == '*') {
                    st.pop();
                    cnt++;
                }
                if( st.isEmpty() && cnt == 0) return false;
                if( !st.isEmpty()) st.pop();
                else cnt--;
                while ( cnt > 0) {
                    cnt--;
                    st.push('*');
                }
            }
        }
        int cnt = 0;
        while (!st.isEmpty() ) {
            char ch = st.pop();
            if( ch == '*') cnt++;
            else {
                if( cnt == 0)
                    return false;
                cnt--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode678 lc = new LeetCode678();
//        String s = "()";
//        String s = "(*)";
//        String s = "((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()";
        String s = "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())";
        boolean ret = lc.checkValidString(s);
        System.out.println(ret);
    }

}
