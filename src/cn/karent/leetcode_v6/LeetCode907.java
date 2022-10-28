package cn.karent.leetcode_v6;

import java.util.*;

/******************************************
 * 子数组的最小值之和
 * @author wan
 * @date 2022.10.28 10:37
 ******************************************/
public class LeetCode907 {

    public int sumSubarrayMins(int[] arr) {
        int size = arr.length;
        int[] left = new int[size];
        Deque<Integer> st = new ArrayDeque<>();
        Arrays.fill(left, size);
        for (int i = 0; i < size; i++) {
            while (!st.isEmpty() && arr[i] < arr[st.peekLast()]) {
                left[st.pollLast()] = i;
            }
            st.offerLast(i);
        }
        int[] right = new int[size];
        Arrays.fill(right, -1);
        st.clear();
        for (int i = size-1; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] <= arr[st.peekLast()]) {
                right[st.pollLast()] = i;
            }
            st.offerLast(i);
        }
        int mod = 1000_000_007;
        long ret = 0;
        for (int i = 0; i < size; i++) {
            ret += arr[i] * (left[i] - i) * 1L * (i - right[i]);
        }
        return (int) (ret % mod);
    }

    public static void main(String[] args) {
        LeetCode907 lc = new LeetCode907();
//        int[] arr = {3,1,2,4};
        int[] arr = {11,81,94,43,3};
        System.out.println(lc.sumSubarrayMins(arr));
    }

}
