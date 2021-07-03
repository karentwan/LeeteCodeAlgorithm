package cn.karent.leetcode_v6;

import java.util.*;

/***********************************************
 * description: 根据字符出现频率排序
 * @author wan
 * @date 2021.07.03
 ***********************************************/
public class LeetCode451 {

    public String frequencySort(String s) {
        Character[] chs = new Character[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            chs[i] = ch;
        }
        Arrays.sort(chs, (k1 ,k2)-> {
            int v1 = map.get(k1);
            int v2 = map.get(k2);
            return v1 == v2 ? k1 - k2 : v2 - v1;
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chs.length; i++) {
            sb.append(chs[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }

}
