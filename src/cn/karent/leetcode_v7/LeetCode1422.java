package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 分割字符串的最大部分
 * @author wan
 * @date 2022.08.14 09:02
 ******************************************/
public class LeetCode1422 {

    public int maxScore(String s) {
        char[] chs = s.toCharArray();
        int ret = 0, one = 0, wnd = 0;
        for (char c : chs) {
            if (c == '1') one++;
        }
        for (int i = 0; i < chs.length-1; i++) {
            if (chs[i] == '0') wnd++;
            ret = Math.max(ret, wnd + one - i - 1 + wnd);
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1422 lc = new LeetCode1422();
//        String s = "011101";
        String s = "00";
        System.out.println(lc.maxScore(s));
    }

}
