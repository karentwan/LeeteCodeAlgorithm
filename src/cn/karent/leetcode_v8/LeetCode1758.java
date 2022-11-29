package cn.karent.leetcode_v8;

import java.util.*;

/******************************************
 * 生成交替二进制字符串的最少操作数
 * @author wan
 * @date 2022.11.29 10:46
 ******************************************/
public class LeetCode1758 {

    private int alter(char[] chs, boolean one) {
        int ret = 0;
        for (char c : chs) {
            if ((one && c != '0') || (!one && c != '1')) {
                ret++;
            }
            one = !one;
        }
        return ret;
    }

    public int minOperations(String s) {
        char[] chs = s.toCharArray();
        return Math.min(alter(chs, true), alter(chs, false));
    }

    public static void main(String[] args) {
        LeetCode1758 lc = new LeetCode1758();
        String s = "0100";
        System.out.println(lc.minOperations(s));
    }

}
