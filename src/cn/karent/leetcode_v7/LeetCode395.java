package cn.karent.leetcode_v7;

import java.util.*;

/***********************************************
 * description: 至少有k个重复字符的最长子串
 * @author wan
 * @date 2022.02.02
 ***********************************************/
public class LeetCode395 {

    public int longestSubstring(String s, int k) {
        int sBit = 0;
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            sBit |= (1 << chs[i] - 'a');
        }
        int typeNum = Integer.bitCount(sBit);
        int ans = 0;
        for (int type = 1; type <= typeNum; type++) {
            int cnt = 0, kCnt = 0;  // 字符种类, 满足数量等于k的字符种类
            int[] cache = new int[26];
            for (int i = 0, j = 0; j < chs.length; j++) {
                int idx = chs[j] - 'a';
                cache[idx]++;
                if (cache[idx] == 1) {
                    cnt++;
                }
                if (cache[idx] == k) {
                    kCnt++;
                }
                for (; cnt > type; i++) {
                    int t = chs[i] - 'a';
                    if (cache[t] == 1) {
                        cnt--;
                    }
                    if (cache[t] == k) {
                        kCnt--;
                    }
                    cache[t]--;
                }
                if (kCnt == type) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode395 lc = new LeetCode395();
//        String s = "aaabb";
//        int k = 3;
        String s = "bbaaacbd";
        int k = 3;
        System.out.println(lc.longestSubstring(s, k));
    }

}
