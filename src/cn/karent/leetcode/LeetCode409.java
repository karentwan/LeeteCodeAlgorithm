package cn.karent.leetcode;

/**
 * 最长回文串
 */
public class LeetCode409 {

    // 没必要使用所有的元素
    public int longestPalindrome(String s) {
        int[] capital = new int[26];
        int[] lowercase = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if( ch >= 'a' && ch <= 'z') {
                lowercase[ch - 'a']++;
            } else {
                capital[ch - 'A']++;
            }
        }
        int ret = 0;
        for (int i = 0; i < 26; i++) {
            ret += capital[i] - (capital[i] & 1);
            ret += lowercase[i] - (lowercase[i] & 1);
        }
        return ret < s.length() ? ret + 1 : ret;
    }

    public static void main(String[] args) {
        LeetCode409 lc = new LeetCode409();
        String s = "abccccdd";
        int ret = lc.longestPalindrome(s);
        System.out.println(ret);
    }

}
