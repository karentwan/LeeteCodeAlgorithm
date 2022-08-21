package cn.karent.leetcode_v7.weeklycontests85;

import java.util.*;

/******************************************
 * 二进制字符串重新安排顺序需要的时间
 * @author wan
 * @date 2022.08.21 15:07
 ******************************************/
public class LeetCode6157 {

    public int secondsToRemoveOccurrences(String s) {
        char[] chs = s.toCharArray();
        boolean flag = false;
        int time = 0;
        while (!flag) {
            flag = true;
            for (int i = 1; i < chs.length; i++) {
                if (chs[i] == '1' && chs[i-1] == '0') {
                    chs[i] = '0';
                    chs[i-1] = '1';
                    flag = false;
                    i++;
                }
            }
            if (!flag)
                time++;
        }
        return time;
    }

    public static void main(String[] args) {
        LeetCode6157 lc = new LeetCode6157();
        String s = "0110101";
        System.out.println(lc.secondsToRemoveOccurrences(s));
    }

}
