package cn.karent.leetcode_v3;

import java.util.*;

/********************************************
 * description: 键盘行
 * @author wan
 * @date 2021.04.26
 ********************************************/
public class LeetCode500 {

    public String[] findWords(String[] words) {
        int[] cache = new int[128];
        String s1 = "qwertyuiop";
        for (int i = 0; i < s1.length(); i++) {
            cache[s1.charAt(i)] = 0;
            cache[s1.charAt(i) - 'a' + 'A'] = 0;
        }
        s1 = "asdfghjkl";
        for (int i = 0; i < s1.length(); i++) {
            cache[s1.charAt(i)] = 1;
            cache[s1.charAt(i) - 'a' + 'A'] = 1;
        }
        s1 = "zxcvbnm";
        for (int i = 0; i < s1.length(); i++) {
            cache[s1.charAt(i)] = 2;
            cache[s1.charAt(i) - 'a' + 'A'] = 2;
        }
        List<String> list = new ArrayList<>();
        for (String word : words) {
            if( valid(word, cache)) list.add(word);
        }
        String[] rets = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            rets[i] = list.get(i);
        }
        return rets;
    }

    private boolean valid(String word, int[] cache) {
        int idx = cache[word.charAt(0)];
        for (int i = 0; i < word.length(); i++) {
            if( cache[word.charAt(i)] != idx) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode500 lc = new LeetCode500();
//        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        String[] words = {"omk"};
        String[] rets = lc.findWords(words);
        for (String ret : rets) {
            System.out.print(ret + " ");
        }
        System.out.println();
    }

}
