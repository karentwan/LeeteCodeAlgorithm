package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 分割数组为连续子序列
 * @author wan
 * @date 2021.04.16
 */
public class LeetCode659 {

    public boolean isPossible(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int num : nums) {
            int len = 0;
            if( map.containsKey(num-1) ) {
                len = map.get(num-1).poll();
                if( map.get(num-1).isEmpty() ) map.remove(num-1);
            }
            map.computeIfAbsent(num, (k) -> new PriorityQueue<>()).offer(len+1);
        }
        for (int key : map.keySet()) {
            PriorityQueue<Integer> pq = map.get(key);
            while (!pq.isEmpty()) {
                if( pq.poll() < 3) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode659 lc = new LeetCode659();
//        int[] nums = {1, 2, 3, 3, 4, 5};
//        int[] nums = {1,2,3,3,4,4,5,5};
        int[] nums = {1,2,3,4,4,5};
        boolean ret = lc.isPossible(nums);
        System.out.println(ret);
    }

}
