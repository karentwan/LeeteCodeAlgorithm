package cn.karent.leetcode_v3;

import java.util.*;

/********************************************
 * description: 尽可能使字符串相等
 * @author wan
 * @date 2021.04.25
 ********************************************/
public class LeetCode1208 {

    public int equalSubstring(String s, String t, int maxCost) {
        int j = 0;
        int[] distance = new int[s.length()];
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            distance[i] = Math.abs(ss[i] - ts[i]);
        }
        int ret = 0;
        int cost = 0;
        for (int i = 0; i < s.length(); i++) {
            cost += distance[i];
            if( cost <= maxCost) ret = Math.max(ret, i - j + 1);
            else cost -= distance[j++];
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1208 lc = new LeetCode1208();
        String s = "abcd";
        String t = "bcdf";
        int maxCost = 3;
        int ret = lc.equalSubstring(s, t, maxCost);
        System.out.println(ret);
    }

}
