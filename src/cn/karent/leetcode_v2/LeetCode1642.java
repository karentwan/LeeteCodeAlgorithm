package cn.karent.leetcode_v2;

import java.util.*;

/**
 * 可以到达的最远建筑
 * @author wan
 * @date 2021.04.06
 */
public class LeetCode1642 {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sumH = 0;
        for (int i = 1; i < heights.length; i++) {
            int deltaH = heights[i] - heights[i-1];
            if( deltaH > 0) {
                pq.offer(deltaH);
                if( pq.size() > ladders) {
                    sumH += pq.poll();
                }
                if( sumH > bricks) {
                    return i-1;
                }
            }
        }
        return heights.length-1;
    }

    public static void main(String[] args) {

    }

}
