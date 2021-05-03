package cn.karent.leetcode;

import java.util.*;

/**
 * K个不同整数的子数组
 */
public class LeetCode992 {

    /**
     * 最多包含k个子数组
     * 每一个确定的左边界, 它的右边界是确定的,
     * @param A
     * @param k
     * @return
     */
    private int atMostSubarrays(int[] A, int k) {
        int[] wnd = new int[A.length+1];
        int ans = 0;
        int cnt = 0;
        int left = 0, right = 0;
        while( right < A.length) {
            if( wnd[A[right]] == 0) {
                cnt++;
            }
            wnd[A[right]]++;
            right++;
            while( cnt > k) {
                wnd[A[left]]--;
                if( wnd[A[left]] == 0) {
                    cnt--;
                }
                left++;
            }
            ans += right - left;
        }
        return ans;
    }

    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostSubarrays(A, K) - atMostSubarrays(A, K-1);
    }

    public static void main(String[] args) {
        LeetCode992 lc = new LeetCode992();
        int[] nums = {1,2,1,2,3};
        int k = 2;
        int ret = lc.subarraysWithKDistinct(nums, k);
        System.out.println(ret);
    }

}
