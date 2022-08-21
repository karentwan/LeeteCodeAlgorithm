package cn.karent.leetcode_v7.weeklycontest307;

import java.util.*;

/******************************************
 * 找出数组的第k大和
 * @author wan
 * @date 2022.08.21 12:45
 ******************************************/
public class LeetCode6155 {

    public long kSum(int[] nums, int k) {
        long sum = 0l;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) sum += nums[i];
            else nums[i] = -nums[i];
        }
        Arrays.sort(nums);
        PriorityQueue<long[]> pq = new PriorityQueue<>((k1, k2) -> Long.compare(k2[0], k1[0]));
        pq.offer(new long[]{sum, 0});
        while (--k > 0) {
            long[] p = pq.poll();
            long s = p[0];
            int i = (int) p[1];
            if (i < nums.length) {
                pq.offer(new long[]{s - nums[i], i+1});
                if (i > 0) pq.offer(new long[]{s - nums[i] + nums[i-1], i+1});
            }
        }
        return pq.peek()[0];
    }

    public static void main(String[] args) {
        LeetCode6155 lc = new LeetCode6155();
//        int[] nums = {2,4,-2};
//        int k = 5;
        int[] nums = {1,-2,3,4,-10,12};
        int k = 16;
        System.out.println(lc.kSum(nums, k));
    }

}
