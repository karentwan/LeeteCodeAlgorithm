package cn.karent.leetcode_v6;

import java.util.*;

/*******************************************
 * @author wan
 * @date: 2022-01-29 08:00
 * @description: 地图中的最高点
 *  使用广度优先, 因为高度差不能大于1, 所有先从最低开始安排高度, 然后慢慢往上累加
 *******************************************/
public class LeetCode1765 {

    public int[][] highestPeak(int[][] isWater) {
        Queue<int[]> que = new LinkedList<>();
        int m = isWater.length;
        if (m == 0) {
            return new int[0][0];
        }
        int n = isWater[0].length;
        Set<Integer> vis = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    int[] t = new int[]{i * n + j, 0};
                    que.offer(t);
                    isWater[i][j] = 0;  // 将水域的高度安排为0
                    vis.add(i * n + j);
                }
            }
        }
        int[] dirs = {1, 0, -1, 0, 1};
        while (!que.isEmpty()) {
            int[] t = que.poll();
            int row = t[0] / n, col = t[0] % n;
            for (int i = 1; i < dirs.length; i++) {
                int newRow = row + dirs[i-1];
                int newCol = col + dirs[i];
                int v = newRow * n + newCol;
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !vis.contains(v)) {
                    isWater[newRow][newCol] = t[1] + 1;
                    que.offer(new int[]{v, t[1]+1});
                    vis.add(v);
                }
            }
        }
        return isWater;
    }

    public static void main(String[] args) {
        LeetCode1765 lc = new LeetCode1765();
        int[][] water = {{0,1},{0,0}};
        int[][] rets = lc.highestPeak(water);
        for (int[] ret : rets) {
            for (int i : ret) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}
