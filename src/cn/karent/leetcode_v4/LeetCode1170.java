package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 比较字符串最小字母出现频次
 * @author wan
 * @date 2021.05.27
 ********************************************/
public class LeetCode1170 {

    private int count(String s) {
        char[] chs = s.toCharArray();
        int[] cache = new int[128];
        for (int i = 0; i < chs.length; i++) {
            cache[chs[i]]++;
        }
        int ret = 0;
        for (int i = 0; i < 128 && ret == 0; i++) {
            ret = cache[i];
        }
        return ret;
    }

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int m = queries.length;
        int n = words.length;
        int[] queryFreq = new int[m];
        int[] wordFreq = new int[n];
        for (int i = 0; i < m; i++) {
            queryFreq[i] = count(queries[i]);
        }
        for (int i = 0; i < n; i++) {
            wordFreq[i] = count(words[i]);
        }
        Integer[] indices = new Integer[m];
        for (int i = 0; i < m; i++) {
            indices[i] = i;
        }
        Arrays.sort(wordFreq);
        Arrays.sort(indices, (k1, k2)-> queryFreq[k1] - queryFreq[k2]);
        int[] rets = new int[m];
        for (int i = 0, j = 0; i < m; i++) {
            int idx = indices[i];
            int cnt = queryFreq[idx];
            while (j < n && wordFreq[j] <= cnt) {
                j++;
            }
            rets[idx] = n - j;
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode1170 lc = new LeetCode1170();
//        String[] queries = {"bbb", "cc"};
//        String[] words = {"a", "aa", "aaa", "aaaa"};
        String[] queries = {"cbd"};
        String[] words = {"zaaaz"};
        int[] rets = lc.numSmallerByFrequency(queries, words);
        for (int ret : rets) {
            System.out.print(ret + " ");
        }
    }

}
