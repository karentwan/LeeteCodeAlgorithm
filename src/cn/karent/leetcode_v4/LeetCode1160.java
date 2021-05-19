package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 拼写单词
 * @author wan
 * @date 2021.05.19
 ********************************************/
public class LeetCode1160 {

    public int countCharacters(String[] words, String chars) {
        int[] cache = new int[128];
        for (int i = 0; i < chars.length(); i++) {
            cache[chars.charAt(i)]++;
        }
        int ret = 0;
        for (String word : words) {
            int[] tmps = new int[128];
            for (int i = 0; i < word.length(); i++) {
                tmps[word.charAt(i)]++;
            }
            boolean flag = true;
            for (int i = 0; i < 128 && flag; i++) {
                if( tmps[i] > cache[i]) flag = false;
            }
            if( flag ) ret += word.length();
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1160 lc = new LeetCode1160();
        String[] words = {"cat", "bt", "hat", "tree"};
        String chars = "atach";
        int ret = lc.countCharacters(words, chars);
        System.out.println(ret);
    }

}
