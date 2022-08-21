package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 最小k个数
 * @author wan
 * @date 2022.08.21 14:43
 ******************************************/
public class Offer1714 {

    public int[] smallestK(int[] arr, int k) {
        if (k == 0) return new int[0];
        PriorityQueue<Integer> pq = new PriorityQueue<>((k1, k2)->k2 - k1);
        for (int i = 0; i < arr.length; i++) {
            if (pq.size() < k) pq.offer(arr[i]);
            else if (pq.peek() > arr[i]) {
                pq.poll();
                pq.offer(arr[i]);
            }
        }
        int[] rets = new int[k];
        for (int i = 0; i < k; i++) {
            rets[i] = pq.poll();
        }
        return rets;
    }

    public static void main(String[] args) {
        Offer1714 lc = new Offer1714();
    }

}
