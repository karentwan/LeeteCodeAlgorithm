package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 子数组的最小值之和
 * @author wan
 * @date 2021.05.14
 ********************************************/
public class LeetCode907 {

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);
        Arrays.fill(left, -1);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while ( !st.isEmpty() && arr[i] <= arr[st.peek()]) {
                right[st.pop()] = i;
            }
            st.push(i);
        }
        st.clear();
        for (int i = n-1; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
                left[st.pop()] = i;
            }
            st.push(i);
        }
        long ret = 0;
        int MOD = ((int) (1e9 + 7));
        for (int i = 0; i < n; i++) {
            long l = i - left[i] - 1;
            long r = (right[i] - i) - 1;
            ret = (ret + (l + r + 1 + l * r) * arr[i]) % MOD;
        }
        return ((int) ret);
    }

    public static void main(String[] args) {
        LeetCode907 lc = new LeetCode907();
//        int[] arr = {3, 1, 2, 4};
//        int[] arr = {11,81,94,43,3};
        int[] arr = {71,55,82,55};
        int ret = lc.sumSubarrayMins(arr);
        System.out.println(ret);
    }

}
