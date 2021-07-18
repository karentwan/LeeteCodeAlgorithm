package cn.karent.leetcode_v6;

import java.util.*;

/***********************************************
 * description: 变位词组
 * @author wan
 * @date 2021.07.18
 ***********************************************/
public class Offer1002 {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> rets = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] cache = new int[26];
            char[] chs = str.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                cache[chs[i] - 'a']++;
            }
            String key = "";
            for (int i = 0; i < 26; i++) {
                key += cache[i];
            }
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        map.forEach((k,v)->{
            rets.add(v);
        });
        return rets;
    }

    public static void main(String[] args) {

    }

}
