package cn.karent.leetcode_v6;

import java.util.*;

/******************************************
 * 串联所有单词的子串
 * @author wan
 * @date 2022.06.23 22:00
 ******************************************/
public class LeetCode30 {
/*
    // 该方法可行
    public List<Integer> findSubstring(String s, String[] words) {
        int m = s.length(), n = words[0].length(), size = words.length;
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<Integer> rets = new ArrayList<>();
        for (int i = 0; i + n * size <= m; i++) {
            Map<String, Integer> tmp = new HashMap<>();
            // 遍历得到一组字符串
            for (int j = 0; j < size; j++) {
                String key = s.substring(i + j * n, i + (j + 1) * n);
                tmp.put(key, tmp.getOrDefault(key, 0)+1);
            }
            if (map.equals(tmp)) {
                rets.add(i);
            }
        }
        return rets;
    }
  */

    // 滑动窗口解法
    public List<Integer> findSubstring(String s, String[] words) {
        int m = s.length(), n = words[0].length(), size = words.length;
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<Integer> rets = new ArrayList<>();
        // 每次移动一个单词的长度, 这样就可以使用滑动窗口
        for (int i = 0; i < n; i++) {
            Map<String, Integer> tmp = new HashMap<>();
            for (int j = i; j + n <= m; j += n) {
                String key = s.substring(j, j+n);
                tmp.put(key, tmp.getOrDefault(key, 0) + 1);
                if (j >= i + n * size) {  // 可以开始窗口右移了
                    int idx = j - n * size;
                    key = s.substring(idx, idx+n);
                    if (tmp.get(key) == 1) tmp.remove(key);
                    else
                        tmp.put(key, tmp.get(key)-1);
                }
                if (tmp.equals(map)) {
                    rets.add(j - n * (size-1));
                }
            }
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode30 lc = new LeetCode30();
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        List<Integer> rets = lc.findSubstring(s, words);
        for (Integer ret : rets) {
            System.out.print(ret + " ");
        }
    }
}
