package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 雇佣k名工人的最低成本
 * @author wan
 * @date 2022.09.11 10:59
 ******************************************/
public class LeetCode857 {

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        Integer[] indices = new Integer[quality.length];
        for (int i = 0; i < quality.length; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (k1, k2)-> {
            return wage[k1] * quality[k2] - wage[k2] * quality[k1];
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>((k1, k2)-> k2 - k1);
        int sumQ = 0;
        for (int i = 0; i < k; i++) {
            pq.offer(quality[indices[i]]);
            sumQ += quality[indices[i]];
        }
        double ret = sumQ * ((double)wage[indices[k-1]] / quality[indices[k-1]]);
        for (int i = k; i < quality.length; i++) {
            int q = quality[indices[i]];
            if (q < pq.peek()) {
                sumQ -= pq.poll() - q;
                pq.offer(quality[indices[i]]);
                ret = Math.min(ret, sumQ * ((double)wage[indices[i]] / quality[indices[i]]));
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode857 lc = new LeetCode857();
//        int[] quality = {10, 20, 5};
//        int[] wage = {70,50,30};
//        int k = 2;
        int[] quality = {3,1,10,10,1};
        int[] wage = {4,8,2,2,7};
        int k = 3;
        System.out.println(lc.mincostToHireWorkers(quality, wage, k));
    }

}
