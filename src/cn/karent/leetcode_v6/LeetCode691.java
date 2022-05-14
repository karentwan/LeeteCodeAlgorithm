package cn.karent.leetcode_v6;

import java.util.*;

/*******************************************
 * @author wan
 * @date: 2022-05-14 10:29
 * @description: 贴纸拼词
 *******************************************/
public class LeetCode691 {

    public int minStickers(String[] stickers, String target) {
        int m = target.length();
        int[] memo = new int[1 << m];  // 一共有2^n种可能
        Arrays.fill(memo, -1);
        memo[0] = 0;
        // mask表示所有选中的可能
        int ret = dfs(stickers, target, memo, (1 << m) - 1);
        return ret <= m ? ret : -1;
    }

    private int dfs(String[] stickers, String target, int[] memo, int mask) {
        int m = target.length();
        if (memo[mask] < 0) {
            int ret = m+1;
            // 遍历每一个sticker
            for (String sticker : stickers) {
                int left = mask;
                int[] cnt = new int[26];
                for (int i = 0; i < sticker.length(); i++) {
                    cnt[sticker.charAt(i) - 'a']++;
                }
                for (int i = 0; i < target.length(); i++) {
                    char c = target.charAt(i);
                    if (((mask >> i) & 1) == 1 && cnt[c - 'a'] > 0) {
                        cnt[c - 'a'] --;
                        left ^= 1 << i;   // 将第i位置于0, 其他位不变
                    }
                }
                if (left < mask) {
                    ret = Math.min(ret, dfs(stickers, target, memo, left) + 1);
                }
            }
            memo[mask] = ret;
        }
        return memo[mask];
    }

    public static void main(String[] args) {
        LeetCode691 lc = new LeetCode691();
        String[] stickers = {"with", "example", "science"};
        String target = "thehat";
        System.out.println(lc.minStickers(stickers, target));

    }

}
