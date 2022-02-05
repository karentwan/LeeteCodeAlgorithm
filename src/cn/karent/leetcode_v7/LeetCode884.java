package cn.karent.leetcode_v7;

import java.util.*;

/***********************************************
 * description: 两句话中的不常见单词
 * @author wan
 * @date 2022.01.30
 ***********************************************/
public class LeetCode884 {

    public String[] uncommonFromSentences1(String s1, String s2) {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        List<String> list = new ArrayList<>();
        for (String s : s1.split(" ")) {
            if (set1.contains(s)) {
                set2.add(s);
            } else {
                set1.add(s);
            }
        }
        for (String s : s2.split(" ")) {
            if (set2.contains(s)) {
                set1.add(s);
            } else {
            set2.add(s);
            }
        }
        for (String s : set1) {
            if (!set2.contains(s)) {
                list.add(s);
            }
        }
        for (String s : set2) {
            if (!set1.contains(s)) {
                list.add(s);
            }
        }
        return list.toArray(new String[list.size()]);
    }

    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : s1.split(" ")) {
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        for (String s : s2.split(" ")) {
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();
        List<String> list = new ArrayList<>();
        while (iter.hasNext()) {
            Map.Entry<String, Integer> kv = iter.next();
            if (kv.getValue() == 1) {
                list.add(kv.getKey());
            }
        }
        return list.toArray(new String[list.size()]);
    }

    public static void main(String[] args) {
        LeetCode884 lc = new LeetCode884();
        String s1 = "apple apple";
        String s2 = "banana";
        String[] ret = lc.uncommonFromSentences(s1, s2);
        for (String s : ret) {
            System.out.print(s + " ");
        }
    }

}
