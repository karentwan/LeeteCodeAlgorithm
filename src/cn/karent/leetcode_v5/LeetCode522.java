package cn.karent.leetcode_v5;

import java.util.*;

/***********************************************
 * description: 最长特殊序列 二
 * @author wan
 * @date 2021.06.23
 ***********************************************/
public class LeetCode522 {


    public int findLUSlength(String[] strs) {
        int ret = 0;
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            boolean flag = false;
            int val = 0;
            for (int j = 0; j < strs.length && !flag; j++) {
                if( j == i) continue;
                String s1 = strs[j];
                // 判断s是否是s1的子序列
                if(!isSubsequence(s, s1)) {
                    val = Math.max(val, s.length());
                } else flag = true;
            }
            if( !flag ) ret = Math.max(ret, val);
        }
        return ret == 0 ? -1 : ret;
    }

    private boolean isSubsequence(String s, String s1) {
        int j = 0;
        for (int i = 0; i < s1.length() && j < s.length(); i++) {
            if( s.charAt(j) == s1.charAt(i)) j++;
        }
        return j == s.length();
    }

    public static void main(String[] args) {
        LeetCode522 lc = new LeetCode522();
//        String[] strs = {"aba", "cdc", "eae"};
//        String[] strs = {"aaa","aaa","aa"};
        String[] strs = {"aabbcc", "aabbcc","cb"};
        int ret = lc.findLUSlength(strs);
        System.out.println(ret);
    }

}
