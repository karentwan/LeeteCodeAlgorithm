package cn.karent.util;

import java.util.*;

/****************************************************
 * kmp 快速匹配算法
 * @author wan
 * @date 2021.04.07
 ***************************************************/
public class KMP {

    private char[] data;

    private int[] next;

    private int n = 0;

    private void generate() {
        int i = 0, j = 1;
        next[0] = -1;
        while (j < n-1) {
            if( i == -1 || data[i] == data[j]) {
                next[++j] = ++i;
            } else {
                i = next[i];
            }
        }
    }

    public KMP(String s) {
        data = s.toCharArray();
        n = data.length;
        next = new int[n];
        generate();
    }

    public int match(String s) {
        int i = 0, j = 0;
        while ( j < s.length() && i < n) {
            if( i == -1 || data[i] == s.charAt(j)) {
                i++;
                j++;
            } else {
                i = next[i];
            }
        }
        return i >= n ? j - n : -1;
    }

    public static void main(String[] args) {
        String s = "abaaabc";
        KMP kmp = new KMP("aaa");
        int ret = kmp.match(s);
        System.out.println(ret);
    }

}
