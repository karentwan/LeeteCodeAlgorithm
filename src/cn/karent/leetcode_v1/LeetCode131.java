package cn.karent.leetcode_v1;

import java.util.*;

/**
 * 分割回文串
 */
public class LeetCode131 {

    private List[] memo = null;

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if( s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private List<List<String>> dfs(String s, int start) {
        if( start >= s.length() ) {
            return new ArrayList<>();
        }
        if( memo[start] != null) {
            return ((List<List<String>>) memo[start]);
        }
        List<List<String>> rets = new ArrayList<>();
        for (int i = start; i < s.length(); i++) {
            if( isPalindrome(s, start, i) ) {
                List<List<String>> tmp = dfs(s, i+1);
                String str = s.substring(start, i+1);
                if( tmp.isEmpty() ) {
                    List<String> ret = new ArrayList<>();
                    ret.add(str);
                    rets.add(ret);
                } else {
                    for (List<String> r : tmp) {
                        List<String> ret = new ArrayList<>();
                        ret.add(str);
                        ret.addAll(r);
                        rets.add(ret);
                    }
                }
            }
        }
        memo[start] = rets;
        return rets;
    }

    public List<List<String>> partition(String s) {
        memo = new List[s.length()];
        return dfs(s, 0);
    }

    public static void main(String[] args) {
        LeetCode131 lc = new LeetCode131();
//        String s = "aab";
        String s = "cdd";
        List<List<String>> rets = lc.partition(s);
        for (List<String> ret : rets) {
            System.out.println(ret);
        }
    }

}
