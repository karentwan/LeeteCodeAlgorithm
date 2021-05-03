package cn.karent.leetcode;

import java.util.*;

/**
 * 基本计算器
 */
public class LeetCode224 {

    private Stack<String> opStack = new Stack<>();

    private Stack<Integer> numStack = new Stack<>();

    // 0:+ 1:- 2:( 3:) 4:#
    private int[][] priorities = {
                                    {-1, -1, 1, -2},
                                    {-1, -1, 1, -2},
                                    { 1,  1, 1, -2},
                                    {-1, -1, 0, -2},
                                    {-1, -1,-1, -1}  // #
                                  };

    private int getIdx(String str) {
        int idx = -1;
        switch( str ) {
            case "+":
                idx = 0;
                break;
            case "-":
                idx = 1;
                break;
            case "(":
                idx = 2;
                break;
            case ")":
                idx = 3;
                break;
            case "#":
                idx = 4;
                break;
        }
        return idx;
    }

    private boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    private boolean homogeny(char ch1, char ch2) {
        if( ch1 >= '0' && ch1 <= '9') {  // 都是数字
            return ch2 >= '0' && ch2 <= '9';
        }
        return false;
    }

    private int process(int n1, int n2, String op) {
        int ret = 0;
        switch( op ) {
            case "+":
                ret = n1 + n2;
                break;
            case "-":
                ret = n1 - n2;
                break;
        }
        return ret;
    }

    public int calculate(String s) {
        s = "0" + s + "#";
        int i = 0, j = 0;
        String str = null;
        int n = 0;
        while( j < s.length()) {
            // 去除空格
            while( j < s.length() && s.charAt(j) == ' ') {
                j++;
            }
            i = j++;
            while(j < s.length() && homogeny(s.charAt(i), s.charAt(j))) {
                j++;
            }
            str = s.substring(i, j);
            if( isDigit(s.charAt(i))) {  // 如果是数字
                n = Integer.valueOf(str);
                numStack.push(n);
            } else {
                int idx1 = getIdx(str);
                while( !opStack.isEmpty() && priorities[idx1][getIdx(opStack.peek())] < 0) {
                    String op = opStack.pop();
                    int n2 = numStack.pop();
                    int n1 = numStack.pop();
                    numStack.push(process(n1, n2, op));
                }
                if( !opStack.isEmpty() && priorities[idx1][getIdx(opStack.peek())] == 0) {
                    opStack.pop();
                } else {
                    opStack.push(str);
                }
            }
        }
        return numStack.pop();
    }

    public static void main(String[] args) {
        LeetCode224 lc = new LeetCode224();
//        String s = "1 + 1 ";
//        String s = " 2-1 + 2 ";
//        String s = "(1+(4+5+2)-3)+(6+8)";
//        String s = "-2+1";
        String s = "1000+200-     199";
        int ret = lc.calculate(s);
        System.out.println(ret);
    }

}
