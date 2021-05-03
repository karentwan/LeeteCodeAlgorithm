package cn.karent.leetcode_v3;

import java.util.*;

/**
 * @author wan
 * @date 2021.04.13
 */
public class LeetCode921 {

    public int minAddToMakeValid(String S) {
        int ret = 0;
        int cnt = 0;
        for (int i = 0; i < S.length(); i++) {
            if( S.charAt(i) == '(') {
                cnt++;
            } else {
                cnt--;
            }
            if( cnt < 0) {
                ret++;
                cnt++;
            }
        }
        ret += cnt;
        return ret;
    }

    public static void main(String[] args) {
//        String s = "())";
//        String s = "(((";
//        String s = "()";
        String s = "()))((";
        LeetCode921 lc = new LeetCode921();
        int ret = lc.minAddToMakeValid(s);
        System.out.println(ret);
    }

}
