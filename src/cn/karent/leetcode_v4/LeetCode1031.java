package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 两个非重叠子数组的最大和
 * @author wan
 * @date 2021.05.19
 ********************************************/
public class LeetCode1031 {

    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] wndL = new int[n];
        int[] wndM = new int[n];
        int i = 0, wnd = 0;
        while (i < n && i < firstLen-1) wnd += nums[i++];
        for (; i < n; i++) {
            wnd += nums[i];
            wndL[i] = wnd;
            wnd -= nums[i-firstLen+1];
        }
        i = 0;
        wnd = 0;
        while (i < n && i < secondLen-1) wnd += nums[i++];
        for (; i < n; i++) {
            wnd += nums[i];
            wndM[i] = wnd;
            wnd -= nums[i-secondLen+1];
        }
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, Integer.MIN_VALUE/2);
        Arrays.fill(right, Integer.MIN_VALUE/2);
        int j = 0;
        int max = 0;
        for (i = firstLen + secondLen - 1, j = secondLen-1; i < n; i++, j++) {
            max = Math.max(max, wndM[j]);
            left[i] = max;
        }
        max = 0;
        for (j = n-1, i = n - secondLen - 1; i >= firstLen-1; i--, j--) {
            max = Math.max(max, wndM[j]);
            right[i] = max;
        }
        int ret = 0;
        for (int k = 0; k < n; k++) {
            ret = Math.max(ret, Math.max(wndL[k] + left[k], wndL[k] + right[k]));
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1031 lc = new LeetCode1031();
//        int[] arr = {0, 6, 5, 2, 2, 5, 1, 9, 4};
//        int l = 1;
//        int m = 2;
        int[] arr = {};
        int l = 3;
        int m = 2;
        int ret = lc.maxSumTwoNoOverlap(arr, l, m);
        System.out.println(ret);
    }

}
