package cn.karent.leetcode_v3.weeklycontest237;

import java.util.*;

/**
 * 判断句子是否为全字母
 * @author wan
 * @date 2021.04.18
 */
public class Algo5734 {

    public boolean checkIfPangram(String sentence) {
        int[] cache = new int[26];
        char[] chs = sentence.toCharArray();
        int ret = 0;
        for (int i = 0; i < sentence.length(); i++) {
            int idx = chs[i] - 'a';
            cache[idx]++;
            if( cache[idx] == 1) ret++;
        }
        return ret == 26;
    }

    public static void main(String[] args) {
        Algo5734 lc = new Algo5734();
//        String sentence = "thequickbrownfoxjumpsoverthelazydog";
        String sentence = "leetcodeddddddddddddddddddddddddddddddddd";
        boolean ret = lc.checkIfPangram(sentence);
        System.out.println(ret);
    }

}
