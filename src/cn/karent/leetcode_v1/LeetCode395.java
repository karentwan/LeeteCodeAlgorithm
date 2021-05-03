package cn.karent.leetcode_v1;

/**
 * 至少有k个重复字符的最长子串
 */
public class LeetCode395 {

    public int longestSubstring(String s, int k) {
        int ret = 0;
        for (int i = 0; i < 26; i++) {
            int[] cache = new int[26];
            int l = 0, r = 0;
            int total = 0;
            int less = 0;
            while( r < s.length() ) {
                char ch = s.charAt(r);
                cache[ch - 'a']++;
                r++;
                if( cache[ch - 'a'] == 1) {
                    total++;
                    less++;
                }
                if( cache[ch - 'a'] == k) {
                    less--;
                }
                while( total > i) {
                    ch = s.charAt(l);
                    cache[ch - 'a']--;
                    if( cache[ch - 'a'] == 0) {
                        total--;
                        less--;
                    }
                    if( cache[ch - 'a'] == k-1) {
                        less++;
                    }
                    l++;
                }
                if( less == 0) {
                    ret = Math.max(ret, r - l);
                }
            }
        }
        return ret;
    }

}
