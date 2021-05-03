package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 无重复字符的最长子串
 * @author wan
 * @date 2021.04.09
 */
public class LeetCode3 {
/*
    private void del(Map<Character, Integer> map, String s, int i) {
        map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
        if( map.get(s.charAt(i)) == 0) {
            map.remove(s.charAt(i));
        }
    }

    private void add(Map<Character, Integer> map, String s, int i) {
        map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
    }

    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        Map<Character, Integer> map = new HashMap<>();
        int ret = 0;
        for (int j = 0; j < s.length(); j++) {
            while ( map.containsKey(s.charAt(j))) {
                del(map, s, i);
                i++;
            }
            add(map, s, j);
            ret = Math.max(ret, j - i + 1);
        }
        return ret;
    }

  */
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int[] cache = new int[128];
        int ret = 0;
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            while (cache[ch] > 0) {
                cache[s.charAt(i)]--;
                i++;
            }
            cache[ch]++;
            ret = Math.max(ret, j - i + 1);
        }
        return ret;
    }

    public static void main(String[] args) {
        String s =  "abcabcbb";
//        String s =  "bbbbb";
//        String s =  "pwwkew";
        LeetCode3 lc = new LeetCode3();
        int ret = lc.lengthOfLongestSubstring(s);
        System.out.println(ret);
    }

}
