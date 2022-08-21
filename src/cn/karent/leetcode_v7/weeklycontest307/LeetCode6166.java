package cn.karent.leetcode_v7.weeklycontest307;

import java.util.*;

/******************************************
 * 最大回文数字
 * @author wan
 * @date 2022.08.21 10:45
 ******************************************/
public class LeetCode6166 {

    private void append(StringBuilder sb, int number, int size) {
        for (int i = 0; i < size; i++) {
            sb.append(number);
        }
    }

    public String largestPalindromic(String s) {
        char[] chs = s.toCharArray();
        int[] cache = new int[10];
        int noZero = 0;  // 非零个数
        for (int i = 0; i < chs.length; i++) {
            cache[chs[i] - '0']++;
            if (chs[i] > '0' && cache[chs[i] - '0'] == 2) {
                noZero++;
            }
        }
        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();
        // 对零进行处理
        if (cache[0] > 1 && noZero > 0) {
            append(left, 0, cache[0] / 2);
            append(right, 0, cache[0] / 2);
        }
        for (int i = 1; i < 10; i++) {
            if (cache[i] > 1) {
                append(left, i, cache[i] / 2);
                append(right, i, cache[i] / 2);
            }
        }
        // 加入单个元素
        for (int i = 9; i >= 0; i--) {
            if (cache[i] % 2 != 0) {
                append(left.reverse(), i, 1);
                break;
            }
        }
        if (left.length() == 0 && cache[0] > 0) return "0";
        return left.append(right).toString();
    }

    public static void main(String[] args) {
        LeetCode6166 lc = new LeetCode6166();
        String s = "444947137";
//        String s = "000009";
        System.out.println(lc.largestPalindromic(s));
    }

}
