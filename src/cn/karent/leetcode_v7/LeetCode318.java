package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 最大单词长度乘积
 * @author wan
 * @date 2022.11.25 11:26
 ******************************************/
public class LeetCode318 {

    public int maxProduct1(String[] words) {
        Set[] map = new Set[26];
        for (int i = 0; i < 26; i++) {
            map[i] = new HashSet<Integer>();
        }
        for (int i = 0; i < words.length; i++) {
            char[] chs = words[i].toCharArray();
            for (int j = 0; j < chs.length; j++) {
                int idx = chs[j] - 'a';
                map[idx].add(i);
            }
        }
        int ret = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j) {
                    boolean flag = false;
                    for (int k = 0; k < 26; k++) {
                        if (map[k].contains(i) && map[k].contains(j)) {
                            flag = true;break;
                        }
                    }
                    if (!flag) {
                        ret = Math.max(ret, words[i].length() * words[j].length());
                    }
                }
            }
        }
        return ret;
    }

    public int maxProduct(String[] words) {
        int size = words.length;
        int[] mask = new int[size];
        int[] len = new int[size];
        for (int i = 0; i < words.length; i++) {
            len[i] = words[i].length();
            int t = 0;
            for (int j = 0; j < words[i].length(); j++) {
                t |= 1 << (words[i].charAt(j) - 'a');
            }
            mask[i] = t;
        }
        int ret = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i+1; j < size; j++) {
                if ((mask[i] & mask[j]) == 0) {
                    ret = Math.max(ret, len[i] * len[j]);
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode318 lc = new LeetCode318();
        String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        System.out.println(lc.maxProduct(words));
    }

}
