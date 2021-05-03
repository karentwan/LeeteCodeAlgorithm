package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 不含AAA和BBB的字符串
 * @author wan
 * @date 2021.04.13
 */
public class LeetCode984 {

    public String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();
        while ( a > 0 || b > 0) {
            if( a > b) {
                if( b > 0) {
                    sb.append("aab");
                    a -= 2;
                    b -= 1;
                } else {
                    sb.append('a');
                    a -= 1;
                }
            } else if( a < b) {
                if( a > 0) {
                    sb.append("bba");
                    a--;
                    b -= 2;
                } else {
                    sb.append('b');
                    b--;
                }
            } else {
                if( sb.length() == 0 || sb.charAt(sb.length()-1) == 'b') {
                    sb.append("ab");
                } else {
                    sb.append("ba");
                }
                a--;
                b--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode984 lc = new LeetCode984();
        int a = 1;
        int b = 4;
        String ret = lc.strWithout3a3b(a, b);
        System.out.println(ret);
    }

}
