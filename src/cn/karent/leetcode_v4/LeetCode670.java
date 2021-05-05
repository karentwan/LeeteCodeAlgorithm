package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 最大交换
 * @author wan
 * @date 2021.05.05
 ********************************************/
public class LeetCode670 {

    public int maximumSwap(int num) {
        String s = String.valueOf(num);
        char[] chs = s.toCharArray();
        int i = 1;
        while (i < chs.length && chs[i] <= chs[i-1]) {
            i++;
        }
        if( i >= chs.length) return Integer.parseInt(new String(chs));
        int idx = i;
        int max = chs[i];
        for (int j = i; j < chs.length; j++) {
            if( chs[j] >= max) {
                max = chs[j];
                idx = j;
            }
        }
        int j = 0;
        while ( chs[j] >= chs[idx]) j++;
        swap(chs, idx, j);
        return Integer.parseInt(new String(chs));
    }

    private void swap(char[] chs, int minIdx, int idx) {
        char ch = chs[minIdx];
        chs[minIdx] = chs[idx];
        chs[idx] = ch;
    }

    public static void main(String[] args) {
        LeetCode670 lc = new LeetCode670();
//        int n = 2736;
//        int n = 9973;
//        int n = 21;
//        int n = 2636;
        int n = 115;
//        int n = 98368;
        int ret = lc.maximumSwap(n);
        System.out.println(ret);
    }

}
