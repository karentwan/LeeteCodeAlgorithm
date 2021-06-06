package cn.karent.leetcode_v5.weeklycontest244;

import java.util.*;

/********************************************
 * description: 使二进制字符串字符交替的最少翻转次数
 * @author wan
 * @date 2021.06.06
 ********************************************/
public class Algo5778 {

    public int minFlips(String s) {
        char[] zo = {'0', '1'};
        int cnt = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            cnt += s.charAt(i) == zo[i % 2] ? 0 : 1;
        }
        int ret = Math.min(cnt, n - cnt);
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            cnt -= ch == zo[i % 2] ? 0 : 1;
            cnt += ch == zo[(i + n) % 2] ? 0 : 1;
            ret = Math.min(ret, Math.min(cnt, n - cnt));
        }
        return ret;
    }

    public static void main(String[] args) {

    }

}
