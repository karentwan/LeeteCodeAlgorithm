package cn.karent.leetcode_v6;

import java.util.*;

/*******************************************
 * @author wan
 * @date: 2022-03-17 07:51
 * @description: 词典中最长的单词
 *******************************************/
public class LeetCode720 {

    public String longestWord(String[] words) {
        String ret = "";
        Arrays.sort(words, (k1, k2) -> k1.length() == k2.length() ? k1.compareTo(k2) : k1.length() - k2.length());
        Map<String, Boolean> map = new HashMap<>();
        map.put("", true);
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            String s1 = words[i].substring(0, words[i].length()-1);
            if (map.containsKey(s1) && map.get(s1)) {
                map.put(s, true);
            } else {
                map.put(s, false);
            }
            if (map.get(s) && s.length() > ret.length()) {
                ret = s;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode720 lc = new LeetCode720();
//        String[] words = {"wo", "w", "ap", "wor", "world", "worl"};
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
//        Arrays.sort(words);
//        for (String word : words) {
//            System.out.println(word);
//        }
        System.out.println(lc.longestWord(words));
    }

}
