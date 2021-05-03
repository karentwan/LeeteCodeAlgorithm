package cn.karent.leetcode_v3;

import java.util.*;

/********************************************
 * description: 表示数值的字符串
 * @author wan
 * @date 2021.04.23
 ********************************************/
public class Offer20 {

    private int[][] transferTable = {
            {0,1,6,8,8},
            {4,8,8,5,8},
            {0,8,3,8,8},
            {7,8,8,8,8},
            {4,8,8,8,8},
            {4,8,8,8,8},
            {7,1,8,8,8},
            {7,1,8,8,8},
            {8,8,8,8,8},
            {0,1,3,2,8}
    };

    private int get(char ch) {
        if( ch >= '0' && ch <= '9') return 0;
        if( ch == 'e' || ch == 'E') return 1;
        if( ch == '.') return 2;
        if( ch == '-' || ch == '+') return 3;
        return 4;
    }

    public boolean isNumber(String s) {
        s = s.trim();
        if(s.length() == 0) return false;
        char[] chs = s.toCharArray();
        int state = transferTable[9][get(chs[0])];
        if( state != 0 && state != 2 && state != 3) return false;
        for (int i = 1; i < chs.length && state != 8; i++) {
            state = transferTable[state][get(chs[i])];
        }
        return state == 0 || state == 6 || state == 4 || state == 7;
    }


    public static void main(String[] args) {

    }

}
