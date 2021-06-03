package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 连续的子数组和
 * @author wan
 * @date 2021.06.02
 ********************************************/
public class LeetCode523 {
/*
    // 前缀和的思路超时
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n+1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i-1] + nums[i-1];
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i-2; j >= 0; j--) {
                int t = sum[i] - sum[j];
                if( (k != 0 && t % k == 0) || (k == 0 && t == 0))
                    return true;
            }
        }
        return false;
    }
   */

    // 子数组和满足k的倍数一般使用同余定理
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if( n < 2) return false;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        // sum[i] - sum[j] 是k的倍数表示sum[i]与sum[j]同余k
        int rm = 0;
        for (int i = 0; i < n; i++) {
            rm = (rm + nums[i]) % k;
            if( map.containsKey(rm) ) {
                if( i - map.get(rm) >= 2)
                    return true;
            } else map.put(rm, i);
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode523 lc = new LeetCode523();
//        int[] arr = {};
//        int k = 0;
        int[] arr = {0,1,0,3,0,4,0,4,0};
        int k = 5;
        System.out.println(lc.checkSubarraySum(arr, k));
    }

}
