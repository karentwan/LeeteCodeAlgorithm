package cn.karent.leetcode_v2;

import java.util.*;
import cn.karent.util.*;

/**
 * 秋叶收藏集
 * @author wan
 * @date 2021.04.05
 */
public class LCP19 {

    public int minimumOperations(String leaves) {
        if( leaves.length() == 0) {
            return 0;
        }
        int[][] dp = new int[3][leaves.length()];
        dp[0][0] = leaves.charAt(0) == 'y' ? 1 : 0;
        dp[2][0] = dp[1][0] = Integer.MAX_VALUE / 2;
        for (int i = 1; i < leaves.length(); i++) {
            if( leaves.charAt(i) == 'r') {
                dp[0][i] = dp[0][i-1];
                dp[1][i] = Math.min(dp[0][i-1], dp[1][i-1]) + 1;
                dp[2][i] = Math.min(dp[1][i-1], dp[2][i-1]);
            } else {
                dp[0][i] = dp[0][i-1] + 1;
                dp[1][i] = Math.min(dp[0][i-1], dp[1][i-1]);
                dp[2][i] = Math.min(dp[1][i-1], dp[2][i-1]) + 1;
            }
        }
        return dp[2][leaves.length()-1];
    }

    public static void main(String[] args) {
//        String leaves = "rrryyyrryyyrr";
        String leaves = "ryr";
//        String leaves = "yry";
        LCP19 lcp = new LCP19();
        int ret = lcp.minimumOperations(leaves);
        System.out.println(ret);
    }

}
