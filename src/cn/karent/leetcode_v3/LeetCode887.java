package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 鸡蛋掉落
 * @author wan
 * @date 2021.04.20
 */
public class LeetCode887 {

    public int superEggDrop(int K, int N) {
        // dp
        int[][] dp = new int[N+1][K+1];
        // 只有一个鸡蛋的时候, 只能一个一个去试
        for (int i = 1; i < N+1; i++) {
            dp[i][1] = i;
        }
        // 当只有一层的时候, 无论多少个鸡蛋都只需要一次就能找出F
        for (int i = 1; i < K+1; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i < N+1; i++) {
            for (int j = 2; j < K+1; j++) {
                dp[i][j] = Integer.MAX_VALUE / 2;
//                for (int k = 1; k <= i; k++) {
//                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k-1][j-1], dp[i-k][j]) + 1);
//                    System.out.print("dp[" + i + "][" + j + "]:" + dp[i][j] + " ");
//                }
//                System.out.println("dp[" + i + "][" + j + "]:" + dp[i][j]);
                int l = 1, r = i;
                while (l < r) {
                    int m = l + (r - l)/2;
                    if( dp[i-m][j] < dp[m-1][j-1]) r = m;
                    else l = m+1;
                }
                l--;
                dp[i][j] = Math.max(dp[l-1][j-1], dp[i-l][j]) + 1;
            }
        }
        return dp[N][K];
    }

    public static void main(String[] args) {
        LeetCode887 lc = new LeetCode887();
        int k = 1;
        int n = 2;
//        int k = 2;
//        int n = 6;
        int ret = lc.superEggDrop(k, n);
        System.out.println(ret);
    }

}
