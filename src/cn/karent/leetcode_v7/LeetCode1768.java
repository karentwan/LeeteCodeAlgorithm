package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 交替合并字符串
 * @author wan
 * @date 2022.10.23 11:13
 ******************************************/
public class LeetCode1768 {

    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        for (; i < word1.length() && j < word2.length(); i++, j++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(j));
        }
        for (; i < word1.length(); i++) {
            sb.append(word1.charAt(i));
        }
        for (; j < word2.length(); j++) {
            sb.append(word2.charAt(j));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode1768 lc = new LeetCode1768();
        String word1 = "abc";
        String word2 = "pqr";
    }

}
