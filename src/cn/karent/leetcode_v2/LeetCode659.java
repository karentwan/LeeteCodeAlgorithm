package cn.karent.leetcode_v2;

import java.util.*;

/**
 * 分割数组为连续子序列
 * @author wan
 * @date 2021.04.08
 */
public class LeetCode659 {

    public boolean isPossible(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int num : nums) {
            PriorityQueue<Integer> prev = map.getOrDefault(num-1, null);
            int length = 0;
            if( prev != null && prev.size() > 0) {
                length = prev.poll();
            }
            map.computeIfAbsent(num, (key) -> new PriorityQueue<>()).offer(length+1);
        }
        for(int key : map.keySet()) {
            PriorityQueue<Integer> pq = map.get(key);
            if( !pq.isEmpty() && pq.peek() < 3) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode659 lc = new LeetCode659();
//        int[] nums = {1,2,3,3,4,5};
//        int[] nums = {1,2,3,3,4,4,5,5};
        int[] nums = {1,2,3,4,4,5};
        boolean ret = lc.isPossible(nums);
        System.out.println(ret);
    }

}
