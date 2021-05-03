package cn.karent.leetcode_v1;

import java.util.*;
import cn.karent.util.*;

/**
 * 猜字谜
 */
public class LeetCode1178 {

    private int word2bit(String word) {
        int ret = 0;
        for (int i = 0; i < word.length(); i++) {
            int offset = word.charAt(i) - 'a';
            ret |= (1 << offset);
        }
        return ret;
    }

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Integer> rets = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        // 1. 将words映射成为一个bit
        for (String word : words) {
            int b = word2bit(word);
            map.put(b, map.getOrDefault(b, 0) + 1);
        }
        // 2. 枚举每一个puzzle, 并查找他们的子集
        for (String puzzle : puzzles) {
            int ret = 0;
            // 求puzzle的子集
            int bitmask = word2bit(puzzle);
            int subset = bitmask;
            int k = (1 << puzzle.charAt(0) - 'a');
            while( subset > 0) {
                if( ( subset & k) > 0 && map.getOrDefault(subset, 0) > 0) {
                    ret += map.get(subset);
                }
                subset = (subset - 1) & bitmask;
            }
            rets.add(ret);
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode1178 lc = new LeetCode1178();
        String[] words = {"aaaa","asas","able","ability","actt","actor","access"};
        String[] puzzles = {"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"};
        List<Integer> rets = lc.findNumOfValidWords(words, puzzles);
        LeetCodeUtil.print(rets);
    }
}
