package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 不同的子序列二
 * @author wan
 * @date 2022.10.14 09:10
 ******************************************/
public class LeetCode940 {

    public int distinctSubseqII(String s) {
        int mod = 1000_000_007;
        int[] last = new int[26];
        Arrays.fill(last, -1);
        int n = s.length();
        int[] f = new int[n];
        Arrays.fill(f, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                if (last[j] != -1) {
                    f[i] = (f[i] + f[last[j]]) % mod;
                }
            }
            last[s.charAt(i) - 'a'] = i;
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (last[i] != -1) {
                ans = (ans + f[last[i]]) % mod;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode940 lc = new LeetCode940();
        String s = "aba";
        System.out.println(lc.distinctSubseqII(s));
    }

}
