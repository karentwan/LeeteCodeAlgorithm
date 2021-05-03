package cn.karent.leetcode;

import java.util.*;
import cn.karent.util.*;

/**
 * 单词拆分 二
 * 记忆化
 */
public class LeetCode140 {

    Set<String> words = null;

    List<String>[] memo = null;

    List<String> dfs(String s, int idx) {
        if( idx >= s.length()) {
           return null;
        }
        if( memo[idx] != null) {
            return memo[idx];
        }
        List<String> ret = new ArrayList<>();
        for(int i = idx+1; i <= s.length(); i++) {
            String tmp = s.substring(idx, i);
            if( words.contains(tmp) ) {
                List<String> list = dfs(s, i);
                if( list == null) {
                    ret.add(tmp);
                } else {
                    for(String str : list) {
                        ret.add(tmp + " " + str);
                    }
                }
            }
        }
        memo[idx] = ret;
        return ret;
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        words = new HashSet<>(wordDict);
        memo = new List[s.length()];
        List<String> ret = dfs(s, 0);
        return ret;
    }

    public static void main(String[] args) {
        LeetCode140 lc = new LeetCode140();
        String s = "catsanddog";
        String[] arr = {"cat", "cats", "and", "sand", "dog"};
        List<String> wordDict = LeetCodeUtil.arr2list(arr);
        List<String> ret = lc.wordBreak(s, wordDict);
        System.out.println(ret);
    }
}
