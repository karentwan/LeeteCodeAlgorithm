package cn.karent.leetcode_v6;

import java.util.*;

/***********************************************
 * description: 最美子字符串的数目
 *     前缀和+哈希
 * @author wan
 * @date 2021.07.31
 ***********************************************/
public class LeetCode1915 {

    public long wonderfulSubstrings(String word) {
        Map<Integer, Long> map = new HashMap<>();
        map.put(0, 1L);
        int mask = 0;
        char[] chs = word.toCharArray();
        long ret = 0;
        for (int i = 0; i < chs.length; i++) {
            int idx = chs[i] - 'a';
            mask ^= (1 << idx);
            Long val = map.getOrDefault(mask, 0L);
            ret += val;
            for (int j = 0; j < 10; j++) {
                int prev = mask ^ ( 1 << j);
                ret += map.getOrDefault(prev, 0L);
            }
            map.put(mask, val + 1);
        }
        return ret;
    }

    public static void main(String[] args) {

    }

}
