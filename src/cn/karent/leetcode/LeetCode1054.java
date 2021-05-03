package cn.karent.leetcode;

import java.util.*;

/**
 * 距离相等的条形码
 */
public class LeetCode1054 {

    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int barcode : barcodes) {
            map.put(barcode, map.getOrDefault(barcode, 0)+1);
        }
        PriorityQueue<Integer> que = new PriorityQueue<>((k1, k2) -> {
            return map.get(k2) - map.get(k1);
        });
        for (Integer integer : map.keySet()) {
            if( map.get(integer) > 0) {
                que.offer(integer);
            }
        }
        int[] rets = new int[barcodes.length];
        int i = 0;
        while( que.size() >= 2 ) {
            int t1 = que.poll();
            int t2 = que.poll();
            rets[i++] = t1;
            rets[i++] = t2;
            map.put(t1, map.get(t1)-1);
            map.put(t2, map.get(t2)-1);
            if( map.get(t1) > 0) {
                que.offer(t1);
            }
            if( map.get(t2) > 0) {
                que.offer(t2);
            }
        }
        if( !que.isEmpty()) {
            rets[i++] = que.poll();
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode1054 lc = new LeetCode1054();
//        int[] nums = {1,1,1,2,2,2};
        int[] nums = {1,1,1,1, 2,2,3,3};
//        int[] nums = {1,1,2};
//        int[] nums = {1};
        int[] ret = lc.rearrangeBarcodes(nums);
        for (int i : ret) {
            System.out.print(i + " ");
        }
    }

}
