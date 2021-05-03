package cn.karent.leetcode_v1;

import java.util.Stack;

public class LeetCode227 {
    private int[][] priors = {
            //+   -   *   /
            {-1, -1, -1, -1},  // +
            {-1, -1, -1, -1},  // -
            { 1,  1, -1, -1},  // *
            { 1,  1, -1, -1},  // /
            {-1, -1, -1, -1}   // #
    };

    private int getIdx(String s) {
        int ret = -1;
        switch( s ) {
            case "+":
                ret = 0;
                break;
            case "-":
                ret = 1;
                break;
            case "*":
                ret = 2;
                break;
            case "/":
                ret = 3;
                break;
            case "#":
                ret = 4;
                break;
        }
        return ret;
    }

    private boolean isDigit(String str) {
        char ch = str.charAt(0);
        return ch >= '0' && ch <= '9';
    }

    private boolean homo(String s, int i, int j) {
        char c = s.charAt(i);
        char c1 = s.charAt(j);
        return c >= '0' && c <= '9' && c1 >= '0' && c1 <= '9';
    }

    private int process(String op, int n1, int n2) {
        int ret = 0;
        switch (op) {
            case "+":
                ret = n1 + n2;
                break;
            case "-":
                ret = n1 - n2;
                break;
            case "*":
                ret = n1 * n2;
                break;
            case "/":
                ret = n1 / n2;
                break;
        }
        return ret;
    }

    public int calculate(String s) {
        s = "0" + s + "#";
        int i = 0, j = 0;
        Stack<String> ops = new Stack<>();
        Stack<Integer> ns = new Stack<>();
        while( j < s.length() ) {
            // 去除空格
            while( j < s.length() && s.charAt(j) == ' ') {
                j++;
            }
            i = j++;
            while ( j < s.length() && homo(s, i, j)) {
                j++;
            }
            String str = s.substring(i, j);
            if( isDigit(str) ) {
                ns.push(Integer.valueOf(str));
            } else {
                int idx = getIdx(str);
                while( !ops.isEmpty() && ns.size() >= 2 && idx != -1 && priors[idx][getIdx(ops.peek())] == -1) {
                    int n2 = ns.pop();
                    int n1 = ns.pop();
                    String op = ops.pop();
                    int result = process(op, n1, n2);
                    ns.push(result);
                }
                if( !ops.isEmpty() && idx != -1 && priors[idx][getIdx(ops.peek())] == 0) {
                    ops.pop();
                } else {
                    if( idx >= 0) {
                        ops.push(str);
                    }
                }
            }
        }
        return ns.pop();
    }

    public static void main(String[] args) {
        LeetCode227 lc = new LeetCode227();
//        String s = "3 + 2 * 2";
//        String s = "3/    2";
        String s = "3 + 5 / 2";
        int ret = lc.calculate(s);
        System.out.println(ret);
    }
}
