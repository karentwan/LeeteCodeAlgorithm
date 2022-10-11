package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 仅执行一次字符串交换能否使两个字符串相等
 * @author wan
 * @date 2022.10.11 08:24
 ******************************************/
public class LeetCode1790 {

    public boolean areAlmostEqual(String s1, String s2) {
        int size = s1.length();
        char[] a = new char[2];
        char[] b = new char[2];
        int idx = 0;
        for (int i = 0; i < size; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (idx >= 2) return false;
                a[idx] = s1.charAt(i);
                b[idx] = s2.charAt(i);
                idx++;
            }
        }
        if (idx == 1) return false;
        if (idx == 2) {
            return a[0] == b[1] && a[1] == b[0];
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode1790 lc = new LeetCode1790();
    }

}
