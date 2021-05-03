package cn.karent.leetcode_v2.weeklycontest49;

import java.util.*;

/**
 * 句子相似性 三
 * @author wan
 * @date 2021.04.06
 */
public class LeetCode1813 {

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] str1 = sentence1.split(" ");
        String[] str2 = sentence2.split(" ");
        if( str1.length < str2.length) {
            String[] t = str1;
            str1 = str2;
            str2 = t;
        }
        int i = 0, j = 0;
        // 第一张情况, 短的是长的前缀
        while (i < str1.length && j < str2.length && str1[i].compareTo(str2[j]) == 0) {
            i++;
            j++;
        }
        if( j >= str2.length) {
            return true;
        }
        int t = j;
        // 2. 后缀
        i = str1.length-1;
        j = str2.length-1;
        while (i >= 0 && j >= 0 && str1[i].compareTo(str2[j]) == 0) {
            i--;
            j--;
        }
        if( j < 0 || j == t-1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
//        String sentence1 = "My name is Haley";
//        String sentence2 = "My Haley";
//        String sentence1 = "of";
//        String sentence2 = "A lot of words";
        String sentence1 = "Eating right now";
        String sentence2 = "Eating";
        LeetCode1813 lc = new LeetCode1813();
        boolean ret = lc.areSentencesSimilar(sentence1, sentence2);
        System.out.println(ret);
    }

}
