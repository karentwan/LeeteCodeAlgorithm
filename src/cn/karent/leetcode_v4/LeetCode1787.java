package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 使所有区间的异或结果为零
 * @author wan
 * @date 2021.05.25
 ********************************************/
public class LeetCode1787 {

    public int minChanges(int[] nums, int k) {
        int m = 1 << 10;
        int[][] dp = new int[k][m];
        int[] g = new int[k];
        for (int i = 0; i < k; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE/2);
        }
        Arrays.fill(g, Integer.MAX_VALUE/2);
        for (int i = 0; i < k; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            int size = 0;
            for (int j = i; j < nums.length; j+=k) {
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
                size++;
            }
            if( i == 0) {
                for (int j = 0; j < m; j++) {
                    dp[0][j] = size - map.getOrDefault(j, 0);
                    g[0] = Math.min(g[0], dp[0][j]);
                }
            } else {
                for (int j = 0; j < m; j++) {
                    dp[i][j] = g[i-1] + size;
                    for (Integer key : map.keySet()) {
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][j ^ key] + size - map.get(key));
                    }
                    g[i] = Math.min(g[i], dp[i][j]);
                }
            }
        }
        return dp[k-1][0];
    }

    public static void main(String[] args) {
        LeetCode1787 lc = new LeetCode1787();
//        int[] arr = {1, 2, 0, 3, 0};
//        int k = 1;
        int[] arr = {3,4,5,2,1,7,3,4,7};
        int k = 3;
        int ret = lc.minChanges(arr, k);
        System.out.println(ret);
    }

}
