package cn.karent.leetcode_v1;

import java.util.*;

/**
 * T秒后青蛙的位置
 */
public class LeetCode1377 {

    private double dfs(List<List<Integer>> edges, int idx, int target, int t, boolean[] visited) {
        if( t < 0) {
            return 0.0;
        }
        if( t == 0 && idx == target) {
            return 1.0;
        }
        List<Integer> edge = edges.get(idx);
        double val = 0;
        double p = 0;
        for(int e : edge) {
            if( !visited[e]) {
                visited[e] = true;
                val = Math.max(val, dfs(edges, e, target, t-1, visited));
                p++;
            }
        }
        if( idx == target && p == 0) {
            return 1.0;
        }
        p = p == 0 ? 0 : 1 / p;
        return val * p;
    }

    public double frogPosition(int n, int[][] edges, int t, int target) {
        List<List<Integer>> edgeList = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            edgeList.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            edgeList.get(edge[0]).add(edge[1]);
            edgeList.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        double p = dfs(edgeList, 1, target, t, visited);
        return p;
    }

    public static void main(String[] args) {
        LeetCode1377 lc = new LeetCode1377();
        int n = 7;
        int[][] edges = {{1,2},{1,3},{1,7},{2,4},{2,6},{3,5}};
        int target = 4;
        int t = 20;
//        int n = 8;
//        int[][] edges = {{2,1},{3,2},{4,1},{5,1},{6,4},{7,1},{8,7}};
//        int target = 7;
//        int t = 7;
        double p = lc.frogPosition(n, edges, t, target);
        System.out.println(p);
    }

}
