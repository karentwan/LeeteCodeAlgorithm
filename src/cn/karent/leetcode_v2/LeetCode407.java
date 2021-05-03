package cn.karent.leetcode_v2;

import java.util.*;

/**
 * 接雨水 二
 * @author wan
 * @date 2021.04.06
 */
public class LeetCode407 {

    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        if(m == 0) return 0;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((k1, k2) -> k1[2] - k2[2]);
        int ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if( i == 0 || j == 0 || i == m-1 || j == n-1) {
                    pq.offer(new int[]{i, j, heightMap[i][j]});
                    visited[i][j] = true;
                }
            }
        }
        int[] rows = {1, -1, 0, 0};
        int[] cols = {0, 0, 1, -1};
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            for (int i = 0; i < 4; i++) {
                int newx = poll[0] + rows[i];
                int newy = poll[1] + cols[i];
                if( newx >= 0 && newy >= 0 && newx < m && newy < n && !visited[newx][newy]) {
                    ret += Math.max(poll[2] - heightMap[newx][newy], 0);
                    pq.offer(new int[]{newx, newy, Math.max(poll[2], heightMap[newx][newy])});
                    visited[newx][newy] = true;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,4,3,1,3,2}, {3,2,1,3,2,4}, {2,3,3,2,3,1}};
        LeetCode407 lc = new LeetCode407();
        int ret = lc.trapRainWater(nums);
        System.out.println(ret);
    }

}
