package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 有效数字
 * @author wan
 * @date 2021.06.17
 ********************************************/
public class LeetCode65 {

    private int[][] transferTable = {
            {0,4,2,9,9},
            {1,4,9,9,9},
            {1,4,9,9,9},
            {0,9,7,9,9},
            {6,9,9,5,9},
            {6,9,9,9,9},
            {6,9,9,9,9},
            {1,9,9,9,9},
            {0,4,7,3,9}
    };

    private int get(char ch) {
        if( ch >= '0' && ch <= '9') return 0;
        else if( ch == 'e' || ch == 'E') return 1;
        else if( ch == '.') return 2;
        else if( ch == '-' || ch == '+') return 3;
        return 4;
    }

    public boolean isNumber(String s) {
        s = s.trim();
        int n = s.length();
        if( n == 0) return false;
        char[] chs = s.toCharArray();
        int state = transferTable[8][get(chs[0])];
        if( state != 0 && state != 2 && state != 7 && state != 3) return false;
        for (int i = 1; i < n && state != 9; i++) {
            state = transferTable[state][get(chs[i])];
        }
        return state == 0 || state == 1 || state == 6 || state == 2;
    }

    public static void main(String[] args) {
        LeetCode65 lc = new LeetCode65();
        String s = "-0.1";
        boolean ret = lc.isNumber(s);
        System.out.println(ret);
    }

}
