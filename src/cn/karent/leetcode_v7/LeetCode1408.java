package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 数组中的字符串匹配
 * @author wan
 * @date 2022.08.06 09:45
 ******************************************/
public class LeetCode1408 {

    public List<String> stringMatching(String[] words) {
        List<String> rets = new ArrayList<>();
        Set<String> tmps = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (j == i) continue;
                if (words[i].contains(words[j])) tmps.add(words[j]);
            }
        }
        rets.addAll(tmps);
        return rets;
    }

    public static void main(String[] args) {
        LeetCode1408 lc = new LeetCode1408();
    }

}
