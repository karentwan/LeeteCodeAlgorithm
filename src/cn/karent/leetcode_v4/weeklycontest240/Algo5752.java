package cn.karent.leetcode_v4.weeklycontest240;

import java.util.*;

/********************************************
 * description: 子数组最小乘积的最大值
 * @author wan
 * @date 2021.05.09
 ********************************************/
public class Algo5752 {

    public int maxSumMinProduct(int[] nums) {
        long ret = 0;
        int n = nums.length;
        int MOD = ((int) (1e9 + 7));
        Stack<Integer> st = new Stack<>();
        // 右边界
        int[] right = new int[n];
        Arrays.fill(right, n);
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[i] < nums[st.peek()]) {
                right[st.pop()] = i;
            }
            st.push(i);
        }
        int[] left = new int[n];
        Arrays.fill(left, -1);
        st.clear();
        for(int i = n-1; i >= 0; i--) {
            while (!st.isEmpty() && nums[i] < nums[st.peek()]) {
                left[st.pop()] = i;
            }
            st.push(i);
        }
        long[] prevSum = new long[n+1];
        for (int i = 1; i <= n; i++) {
            prevSum[i] += prevSum[i-1] + nums[i-1];
        }
        for (int i = 0; i < n; i++) {
            int l = left[i];
            int r = right[i];
            long sum = prevSum[r] - prevSum[l+1];
            ret = Math.max(ret, sum * nums[i]);
        }
        return ((int) (ret % MOD));
    }

    public static void main(String[] args) {
        Algo5752 lc = new Algo5752();
        int[] nums = {1, 2, 3, 2};
//        int[] nums = {2,3,3,1,2};
//        int[] nums = {3,1,5,6,4,2};
        int ret = lc.maxSumMinProduct(nums);
        System.out.println(ret);
    }

}
