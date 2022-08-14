package cn.karent.leetcode_v7.weeklycontest306;

import java.util.*;

/******************************************
 * 统计特殊整数
 * @author wan
 * @date 2022.08.14 11:13
 ******************************************/
public class LeetCode6151 {

    private int[][] dp;

    private int dfs(char[] chs, int idx, boolean isLimited, int mask, boolean zero) {
        if (idx == chs.length) {
            return zero ? 0 : 1;
        }
        if (!isLimited && !zero && dp[idx][mask] > -1) return dp[idx][mask];
        int ret = 0;
        if (zero) {  // 前面全是0且当前位置也不选
            ret = dfs(chs, idx+1, false, mask, true);
        }
        // 上界
        int up = isLimited ? chs[idx] - '0' : 9;
        // 当前位置选值
        for (int i = zero ? 1 : 0; i <= up; i++) {
            if ((mask & (1 << i)) == 0) {  // i这个元素未选
                ret += dfs(chs, idx+1, isLimited && i == up, mask | (1 << i), false);
            }
        }
        if (!isLimited && !zero)
            dp[idx][mask] = ret;
        return ret;
    }

    public int countSpecialNumbers(int n) {
        // 排列组合
        String s = String.valueOf(n);
        char[] chs = s.toCharArray();
        dp = new int[chs.length][1 << 10];
        for (int i = 0; i < chs.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(chs, 0, true, 0, true);
    }

    public static void main(String[] args) {
        LeetCode6151 lc = new LeetCode6151();
        int n = 135;
        System.out.println(lc.countSpecialNumbers(n));
    }

}
