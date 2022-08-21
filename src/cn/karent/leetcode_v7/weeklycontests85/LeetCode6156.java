package cn.karent.leetcode_v7.weeklycontests85;

import java.util.*;

/******************************************
 * 得到k个黑块的最少涂色次数
 * @author wan
 * @date 2022.08.21 14:56
 ******************************************/
public class LeetCode6156 {

    public int minimumRecolors(String blocks, int k) {
        char[] chs = blocks.toCharArray();
        int w = 0, b = 0, ret = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < chs.length; i++) {
            if (chs[i] == 'W') w++;
            else b++;
            if (i - j >= k) {
                if (chs[j] == 'W') w--;
                else b--;
                j++;
                ret = Math.min(ret, k - b);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode6156 lc = new LeetCode6156();
//        String blocks = "WBBWWBBWBW";
//        int k = 7;
        String blocks = "WBWBBBW";
        int k = 2;
        System.out.println(lc.minimumRecolors(blocks, k));
    }

}
