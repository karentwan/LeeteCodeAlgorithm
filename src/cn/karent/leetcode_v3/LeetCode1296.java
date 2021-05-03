package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 划分数组为连续数字的集合
 * @author wan
 * @date 2021.04.16
 */
public class LeetCode1296 {

    public boolean isPossibleDivide(int[] nums, int k) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        Comparator<Integer> cmp = (k1, k2) -> k2 - k1;
        Arrays.sort(nums);
        if( nums.length % k != 0) return false;
        for (int num : nums) {
            int len = 0;
            if( map.containsKey(num-1)) {
                PriorityQueue<Integer> pq = map.get(num-1);
                while (!pq.isEmpty() && pq.peek() == k) {
                    pq.poll();
                }
                if( !pq.isEmpty()) len = pq.poll();
            }
            map.computeIfAbsent(num, (key) -> new PriorityQueue<>(cmp)).offer(len+1);
        }
        for (int key : map.keySet()) {
            PriorityQueue<Integer> pq = map.get(key);
            while (!pq.isEmpty()) {
                if( pq.poll() != k) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode1296 lc = new LeetCode1296();
//        int[] nums = {1,2,3,3,4,4,5,6};
//        int k = 4;
//        int[] nums = {3,2,1,2,3,4,3,4,5,9,10,11};
//        int k = 3;
//        int[] nums = {3,3,2,2,1,1};
//        int k = 3;
        int[] nums = {1,2,3,4};
        int k = 3;
        boolean ret = lc.isPossibleDivide(nums, k);
        System.out.println(ret);
    }

}
