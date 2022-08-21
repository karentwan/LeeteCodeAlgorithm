package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 检查单词是否为其他单词的前缀
 * @author wan
 * @date 2022.08.21 09:25
 ******************************************/
public class LeetCode1455 {

    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] strs = sentence.split(" ");
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].startsWith(searchWord)) return i + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode1455 lc = new LeetCode1455();
    }

}
