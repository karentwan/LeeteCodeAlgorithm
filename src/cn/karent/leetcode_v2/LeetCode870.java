package cn.karent.leetcode_v2;

import java.util.*;

/**
 * 优势洗牌
 * @author wan
 * @date 2021.04.08
 */
public class LeetCode870 {

    public int[] advantageCount(int[] A, int[] B) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        Integer[] indices = new Integer[B.length];
        for (int i = 0; i < B.length; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (k1, k2) -> {
            return B[k1] - B[k2];
        });
        for (int i : A) {
            pq1.offer(i);
        }
        int i = 0;
        int[] rets = new int[B.length];
        while (i < B.length && !pq1.isEmpty()) {
            while (!pq1.isEmpty() && pq1.peek() <= B[indices[i]]) {
                pq2.offer(pq1.poll());
            }
            if( !pq1.isEmpty() ) {
                rets[indices[i++]] = pq1.poll();
            }
        }
        while ( i < B.length && !pq2.isEmpty()) {
            rets[indices[i++]] = pq2.poll();
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode870 lc = new LeetCode870();
//        int[] A = {2,7,11,15};
//        int[] B = {1,10,4,11};
        int[] A = {12,24,8,32};
        int[] B = {13,25,32,11};
//        int[] A = {2,0,4,1,2};
//        int[] B = {1,3,0,0,2};
        int[] rets = lc.advantageCount(A,B);
        for (int ret : rets) {
            System.out.print(ret + " ");
        }
        System.out.println();
    }

}
