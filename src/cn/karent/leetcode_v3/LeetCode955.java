package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 删列造序 二
 * @author wan
 * @date 2021.04.13
 */
public class LeetCode955 {

    private boolean isSorted(String[] strs) {
        for (int i = 1; i < strs.length; i++) {
            if( strs[i].compareTo(strs[i-1]) < 0) return false;
        }
        return true;
    }

    public int minDeletionSize(String[] strs) {
        int ret = 0;
        int m = strs.length;
        if( m == 0) return ret;
        int n = strs[0].length();
        String[] cur = new String[m];
        for (int i = 0; i < n; i++) {
            String[] cur1 = Arrays.copyOf(cur, m);
            for (int j = 0; j < m; j++) {
                cur1[j] += strs[j].charAt(i);
            }
            if( isSorted(cur1) ) cur = cur1;
            else ret++;
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode955 lc = new LeetCode955();
//        String[] strs = {"xc","yb","za"};
//        String[] strs = {"zyx","wvu","tsr"};
//        String[] strs = {"ca","bb","ac"};
        String[] strs = {"xga","xfb","yfa"};
        int ret = lc.minDeletionSize(strs);
        System.out.println(ret);
    }

}
