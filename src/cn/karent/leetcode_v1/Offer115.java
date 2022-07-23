package cn.karent.leetcode_v1;

import java.util.*;

/******************************************
 * 重建序列
 * @author wan
 * @date 2022.07.23 11:00
 ******************************************/
public class Offer115 {

    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        int n = nums.length;
        int[] indegrees = new int[n+1];
        Set<Integer>[] graph = new Set[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new HashSet<>();
        }
        for (int[] sequence : sequences) {
            int size = sequence.length;
            for (int i = 1; i < size; i++) {
                int prev = sequence[i-1], next = sequence[i];
                if (graph[prev].add(next)) {
                    indegrees[next]++;
                }
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            if (queue.size() > 1) {
                return false;
            }
            int num = queue.poll();
            Set<Integer> set = graph[num];
            for (int next : set) {
                indegrees[next]--;
                if (indegrees[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Offer115 lc = new Offer115();
        int[] nums = {1,2,3,4};
        int[][] sequences = {{1,2}, {1,3}, {1,2,3}};
        System.out.println(lc.sequenceReconstruction(nums, sequences));
    }

}
