package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 构建回文串检测
 * @author wan
 * @date 2021.05.30
 ********************************************/
public class LeetCode1177 {

    private boolean palindrome(int[] tmps, int k) {
        int odd = 0;
        for (int i = 0; i < tmps.length; i++) {
            if( tmps[i] % 2 != 0) odd++;
        }
        if( odd <= 1 || odd - k * 2 <= 1) return true;
        return false;
    }

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> rets = new ArrayList<>();
        int n = s.length();
        int[][] dp = new int[n+1][26];
        for (int i = 1; i <= n; i++) {
//            char ch = s.charAt(i-1);
            int idx = s.charAt(i-1) - 'a';
            for (int j = 0; j < 26; j++) {
                if( idx == j)  dp[i][idx] = dp[i-1][idx] + 1;
                else dp[i][j] = dp[i-1][j];
            }

        }
        for (int[] q : queries) {
            int left = q[0];
            int right = q[1];
            int k = q[2];
            int[] tmps = new int[26];
            for (int i = 0; i < 26; i++) {
                tmps[i] = dp[right+1][i] - dp[left][i];
            }
            rets.add(palindrome(tmps, k));
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode1177 lc = new LeetCode1177();
        String s = "abcda";
        int[][] queries = {{3,3,0},{1,2,0},{0,3,1},{0,3,2},{0,4,1}};
        List<Boolean> rets = lc.canMakePaliQueries(s, queries);
        System.out.println(rets);
    }

}
