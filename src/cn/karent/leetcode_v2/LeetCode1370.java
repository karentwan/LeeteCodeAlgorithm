package cn.karent.leetcode_v2;

import java.util.*;

/**
 * 上升下降字符串
 */
public class LeetCode1370 {

    public String sortString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while ( i < s.length()) {
            // 升序
            for (char ch = 'a'; ch <= 'z' && i < s.length(); ch++) {
                if( map.getOrDefault(ch, 0) > 0) {
                    sb.append(ch);
                    map.put(ch, map.get(ch)-1);
                    i++;
                }
            }
            // 降序
            for (char ch = 'z'; ch >= 'a' && i < s.length(); ch--) {
                if( map.getOrDefault(ch, 0) > 0) {
                    sb.append(ch);
                    map.put(ch, map.get(ch)-1);
                    i++;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode1370 lc = new LeetCode1370();
        String s = "aaaabbbbcccc";
        String ret = lc.sortString(s);
        System.out.println(ret);
    }

}
