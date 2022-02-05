package cn.karent.leetcode_v7;

import java.util.*;

/***********************************************
 * description: 最长的美好子字符串
 * @author wan
 * @date 2022.02.01
 ***********************************************/
public class LeetCode1763 {

    private boolean nice(String s) {
        char[] chs = s.toCharArray();
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];
        for (int i = 0; i < chs.length; i++) {
            if ( chs[i] >= 'a' && chs[i] <= 'z') {
                int idx = chs[i] - 'a';
                lower[idx] = true;
            } else {
                int idx = chs[i] - 'A';
                upper[idx] = true;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (upper[i] ^ lower[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 暴力枚举
     * @param s
     * @return
     */
    public String longestNiceSubstring1(String s) {
        int ans = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length(); j > i; j--) {
                if (nice(s.substring(i, j))) {
                    if (j - i > ans) {
                        ans = j - i;
                        start = i;
                    }
                }
            }
        }
        return ans == 0 ? "" : s.substring(start, start + ans);
    }

    private int start;
    private int size;

    private Set<String> vis = new HashSet<>();

    private void dfs(char[] chs, int s, int e) {
        if (s >= e) {
            return;
        }
        String key = s + "-" + e;
        if (vis.contains(key)) {
            return;
        }
        vis.add(key);
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];
        for (int i = s; i <= e; i++) {
            if (Character.isLowerCase(chs[i])) {
                lower[chs[i] - 'a'] = true;
            } else {
                upper[chs[i] - 'A'] = true;
            }
        }
        boolean flag = false;
        for (int i = 0; i < 26 && !flag; i++) {
            if (lower[i] ^ upper[i]) {
                flag = true;
            }
        }
        if (!flag) {
            if (e-s+1 > size || (e-s+1 == size && s < start)) {
                start = s;
                size = e - s + 1;
            }
        }
        for (int i = s; i <= e; i++) {
            if (Character.isLowerCase(chs[i]) && !upper[chs[i] - 'a']) {
                dfs(chs, s, i-1);
                dfs(chs, i+1, e);
            } else if (Character.isUpperCase(chs[i]) && !lower[chs[i] - 'A']) {
                dfs(chs, s, i-1);
                dfs(chs, i+1, e);
            }
        }
    }

    /**
     * 使用分治解法, 求出每个非法字符, 然后将其划分
     * @param s
     * @return
     */
    public String longestNiceSubstring2(String s) {
        dfs(s.toCharArray(), 0, s.length()-1);
        return size == 0 ? "" : s.substring(start, start+size);
    }


    /**
     * 滑动窗口解法
     * @param s
     * @return
     */
    public String longestNiceSubstring(String s) {
        char[] chs = s.toCharArray();
        int sBit = 0;
        for (int i = 0; i < chs.length; i++) {
            if (Character.isLowerCase(chs[i])) {
                sBit |= (1 << chs[i] - 'a');
            } else {
                sBit |= (1 << chs[i] - 'A');
            }
        }
        int typeNum = Integer.bitCount(sBit);
        int start = 0, size = 0;
        for (int type = 1; type <= typeNum; type++) {
            // 滑动窗口
            int[] lowerCnt = new int[26];
            int[] upperCnt = new int[26];
            int cnt = 0, total = 0;
            for (int i = 0, j = 0; j < chs.length; j++) {
                int idx = -1;
                if (Character.isLowerCase(chs[j])) {
                    idx = chs[j] - 'a';
                    lowerCnt[idx]++;
                    if (lowerCnt[idx] == 1 && upperCnt[idx] > 0) {
                        cnt++;
                    } else if (lowerCnt[idx] + upperCnt[idx] == 1) {
                        total++;
                    }
                } else {
                    idx = chs[j] - 'A';
                    upperCnt[idx]++;
                    if (upperCnt[idx] == 1 && lowerCnt[idx] > 0) {
                        cnt++;
                    } else if (lowerCnt[idx] + upperCnt[idx] == 1) {
                        total++;
                    }
                }
                while ( i <= j && total > type) {
                    if (Character.isLowerCase(chs[i])) {
                        idx = chs[i] - 'a';
                        lowerCnt[idx]--;
                        if (lowerCnt[idx] == 0 && upperCnt[idx] == 0) {
                            total--;
                        } else if (lowerCnt[idx] == 0) {
                            cnt--;
                        }
                    } else {
                        idx = chs[i] - 'A';
                        upperCnt[idx]--;
                        if (lowerCnt[idx] == 0 && upperCnt[idx] == 0) {
                            total--;
                        } else if (upperCnt[idx] == 0) {
                            cnt--;
                        }
                    }
                    i++;
                }
                if (cnt == type ) {
                    if (j-i+1 > size || (j-i+1==size && i < start)) {
                        start = i;
                        size = j - i + 1;
                    }
                }
            }
        }
        return size == 0 ? "" : s.substring(start, start + size);
    }

    public static void main(String[] args) {
        LeetCode1763 lc = new LeetCode1763();
        String s = "YazaAay";
//        String s = "qOocYChQHnyN";
        System.out.println(lc.longestNiceSubstring(s));
    }

}
