package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 至少有1位重复的数字
 * @author wan
 * @date 2022.08.14 16:34
 ******************************************/
public class LeetCode1012 {

    private int[][] dp;

    private char[] chs;

    private int dfs(int idx, boolean isLimited, boolean isNum, int mask) {
        if (idx == chs.length) {
            return isNum ? 1 : 0;
        }
        if (!isLimited && isNum && dp[idx][mask] > -1) return dp[idx][mask];
        // 1. 当前位不选
        int ret = 0;
        if (!isNum) {
            ret = dfs(idx+1, false, false, mask);
        }
        // 当前位选, 但是上下界都需要需要分情况讨论
        // 下界, 前面没选, 这里只能从1开始, 因为0的情况前面已经算了
        // 上界: 如果前面选的都是指定最大界, 这里就只能选最大界
        int up = isLimited ? chs[idx] - '0' : 9;
        for (int i = isNum ? 0 : 1; i <= up; i++) {
            if ((mask & (1 << i)) == 0) {
                ret += dfs(idx + 1, isLimited && i == up, true, mask | (1 << i));
            }
        }
        if (!isLimited && isNum) {
            dp[idx][mask] = ret;
        }
        return ret;
    }


    public int numDupDigitsAtMostN(int n) {
        String s = String.valueOf(n);
        chs = s.toCharArray();
        dp = new int[chs.length][1 << 10];
        for (int i = 0; i < chs.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ret = dfs(0, true, false, 0);
//        System.out.println(ret);
        return n - ret;
    }

    public static void main(String[] args) {
        LeetCode1012 lc = new LeetCode1012();
        int n = 135;
        System.out.println(lc.numDupDigitsAtMostN(n));
    }

}
