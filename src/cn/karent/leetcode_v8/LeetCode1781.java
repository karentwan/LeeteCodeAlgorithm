package cn.karent.leetcode_v8;

import java.util.*;

/******************************************
 * 所有子字符串美丽值之和
 * @author wan
 * @date 2022.12.12 19:54
 ******************************************/
public class LeetCode1781 {

    public int beautySum(String s) {
        char[] chs = s.toCharArray();
        int[][] map = new int[s.length()+1][26];
        for (int i = 0; i < chs.length; i++) {
            int idx = chs[i] - 'a';
            for (int j = i+1; j <= chs.length; j++) {
                map[j][idx]++;
            }
        }
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                ret += countBeauty(map, i, j);
            }
        }
        return ret;
    }

    private int countBeauty(int[][] map, int i, int j) {
        int[] cnts = new int[26];
        for (int k = 0; k < 26; k++) {
            cnts[k] = map[j][k] - map[i][k];
        }
        int max = 0, min = Integer.MAX_VALUE;
        for (int k = 0; k < 26; k++) {
            if (cnts[k] > 0) {
                max = Math.max(cnts[k], max);
                min = Math.min(cnts[k], min);
            }
        }
        return max - min;
    }

    public static void main(String[] args) {
        LeetCode1781 lc = new LeetCode1781();
        String s = "aabcb";
        System.out.println(lc.beautySum(s));
    }

}
