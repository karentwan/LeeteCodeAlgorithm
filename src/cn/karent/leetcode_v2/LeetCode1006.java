package cn.karent.leetcode_v2;

import java.util.*;

/**
 * 笨阶乘
 */
public class LeetCode1006 {

    private int process(int a, int b, int op) {
        int ret = 0;
        switch ( op ) {
            case 0:
                ret = a * b;
                break;
            case 1:
                ret = a / b;
                break;
            case 2:
                ret = a + b;
                break;
            case 3:
                ret = a - b;
                break;
        }
        return ret;
    }

    private int[][] priors = {  {-1,-1, 1, 1},  // *
                                {-1,-1, 1, 1},  // /
                                {-1,-1,-1,-1},  // +
                                {-1,-1,-1,-1},  // -
                                {-1,-1,-1,-1}   // #
                              };

    public int clumsy(int N) {
        Stack<Integer> nSt = new Stack<>();
        Stack<Integer> opSt = new Stack<>();
        int idx = 0;
        while ( N > 1) {
            nSt.push(N--);
            while (!opSt.isEmpty() && priors[idx][opSt.peek()] < 0) {
                int b = nSt.pop();
                int a = nSt.pop();
                nSt.push(process(a, b, opSt.pop()));
            }
            opSt.push(idx);
            idx = (idx + 1) % 4;
        }
        nSt.push(1);
        while ( !opSt.isEmpty() && priors[4][opSt.peek()] < 0) {
            int b = nSt.pop();
            int a = nSt.pop();
            nSt.push(process(a, b, opSt.pop()));
        }
        return nSt.pop();
    }

    public static void main(String[] args) {
        LeetCode1006 lc = new LeetCode1006();
        int n = 1;
        int ret = lc.clumsy(n);
        System.out.println(ret);
    }

}
