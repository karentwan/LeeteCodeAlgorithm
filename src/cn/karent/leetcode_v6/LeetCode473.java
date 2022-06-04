package cn.karent.leetcode_v6;

import java.util.Arrays;

/******************************************
 * @author wan
 * @date 2022.06.02 21:48
 * @descripton 火柴拼正方形
 ******************************************/
public class LeetCode473 {

    public boolean makesquare(int[] matchsticks) {
        int totalLen = Arrays.stream(matchsticks).sum();
        if (totalLen % 4 != 0) {
            return false;
        }
        int len = totalLen / 4, n = matchsticks.length;
        int[] dp = new int[1 << n];  // 当前
        Arrays.fill(dp, -1);
        dp[0] = 0;
        // 枚举火柴的各种选择情况
        for (int s = 1; s < (1 << n); s++) {
            for (int k = 0; k < n; k++) {
                if ((s & (1 << k)) == 0) {  // 如果s的第k个位置未选中则跳过
                    continue;
                }
                int s1 = s ^ (1<<k);
                if (dp[s1] >= 0 && dp[s1] + matchsticks[k] <= len) {
                    dp[s] = (dp[s1] + matchsticks[k]) % len;
                    break;
                }
            }
        }
        return dp[(1 << n) - 1] == 0;
    }

    public static void main(String[] args) {
        LeetCode473 lc = new LeetCode473();
        int[] matchsticks = {1,1,2,2,2};
        System.out.println(lc.makesquare(matchsticks));
    }

}
