package cn.karent.leetcode_v6;

import java.util.*;

/***********************************************
 * description: 最长递增子序列的长度
 * @author wan
 * @date 2021.09.20
 ***********************************************/
public class LeetCode673 {
/*
    private int binarySearch(int[] tmps, int n, int target) {
        int l = 0, r = n-1;
        while (l <= r) {
            int m = l + ( r - l)/2;
            if( tmps[m] >= target) {
                r = m-1;
            } else {
                l = m+1;
            }
        }
        return l;
    }

    private void insert(List<Integer> arr, int v) {
        int size = arr.size();
        arr.add(v);
        int i = size-1;
        for (; i >= 0 && v < arr.get(i); i--) {
            arr.set(i+1, arr.get(i));
        }
        arr.set(i+1, v);
    }

    private int binarySearch(List<int[]> arr, int target) {
        int l = 0, r = arr.size() - 1;
        while (l <= r) {
            int m = l + (r - l)/2;
            if( arr.get(m)[0] >= target) {
                r = m-1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public int findNumberOfLIS(int[] nums) {
        int ret = 0, len = 0, n = nums.length;
        int[] tmps = new int[n];
        List<Integer> last = new ArrayList<>();  // 最长结尾的元素个数
        for (int num : nums) {
            int idx = binarySearch(tmps, len, num);
            tmps[idx] = num;
            if( idx == len-1) {
                ret++;
                insert(last, num);
            } else if( idx == len) {
                ret = Math.max(binarySearch(last, num), 1);
                last.clear();
                insert(last, num);
            }
            len = Math.max(idx+1, len);
        }
        return ret;
    }

   */
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if( n == 0) return 0;
        int[] dp = new int[n];
        int[] cnts = new int[n];
        dp[0] = 1;cnts[0] = 1;
        int ret = 1, len = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1; cnts[i] = 1;
            for (int j = 0; j < i; j++) {
                if( nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        cnts[i] = cnts[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        cnts[i] += cnts[j];
                    }
                }
            }
            // 统计
            if( dp[i] == len) {
                ret += cnts[i];
            } else if( dp[i] > len) {
                ret = cnts[i];
                len = dp[i];
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode673 lc = new LeetCode673();
//        int[] arr = {1,3,5,4,7};
//        int[] arr = {3,1,2};
//        int[] arr = {8,7,6,5,3,2,1,4};
        int[] arr = {2,2,2,2,2};
//        int[] arr = {1,2,4,3,5,4,7,2};
        int ret = lc.findNumberOfLIS(arr);
        System.out.println(ret);
    }

}
