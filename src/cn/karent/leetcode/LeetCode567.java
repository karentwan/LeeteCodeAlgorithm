package cn.karent.leetcode;

/**
 * 字符串的排列
 */
public class LeetCode567 {

    public boolean checkInclusion(String s1, String s2) {
        int[] smap = new int[26];
        for(int i = 0; i < s1.length(); i++) {
            smap[s1.charAt(i) - 'a']++;
        }
        int[] tmap = new int[26];
        int l = 0, r = 0;
        while( r < s2.length()) {
            tmap[s2.charAt(r) - 'a']++;
            r++;
            if( valid(smap, tmap)) {
                return true;
            }
            if( r - l == s1.length()) {
                tmap[s2.charAt(l) - 'a']--;
                l++;
            }
        }
        return false;
    }

    private boolean valid(int[] smap, int[] tmap) {
        for(int i = 0; i < 26; i++) {
            if( smap[i] != tmap[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode567 lc = new LeetCode567();
//        String s1 = "ab";
//        String s2 = "eidbaooo";
        String s1 = "ab";
        String s2 = "eidboaoo";
        boolean ret = lc.checkInclusion(s1, s2);
        System.out.println(ret);
    }

}
