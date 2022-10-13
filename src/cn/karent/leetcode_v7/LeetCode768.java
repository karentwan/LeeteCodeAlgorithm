package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 最多能完成排序的块 二
 * @author wan
 * @date 2022.08.13 08:37
 ******************************************/
public class LeetCode768 {

    public int maxChunksToSorted(int[] arr) {
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            if (st.isEmpty() || arr[i] >= st.peekLast()) {
                st.offerLast(arr[i]);
            } else {
                int t = st.pollLast();
                while (!st.isEmpty() && arr[i] < st.peekLast()) {
                    st.pollLast();
                }
                st.offerLast(t);
            }
        }
        return st.size();
    }

    public static void main(String[] args) {
        LeetCode768 lc = new LeetCode768();
//        int[] arr = {5,4,3,2,1};
//        int[] arr = {0,0,1,1,1};
        int[] arr = {1,0,1,3,2};
//        int[] arr = {2, 1, 3, 4, 4};
//        int[] arr = {2,0,1};
//        int[] arr = {4,2,2,1,1};
        System.out.println(lc.maxChunksToSorted(arr));
    }

}
