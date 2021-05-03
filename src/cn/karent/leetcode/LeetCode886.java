package cn.karent.leetcode;

import java.util.*;

/**
 * 可能的二分法
 */
public class LeetCode886 {

    private boolean dfs(List<List<Integer>> edges, int idx, int color, int[] visited) {
        if( visited[idx] != 0) {
            return visited[idx] == color;
        }
        List<Integer> edge = edges.get(idx);
        visited[idx] = color;
        for(int e : edge) {
            if( !dfs(edges, e, -color, visited)) {
                return false;
            }
        }
        return true;
    }

    public boolean possibleBipartition(int N, int[][] dislikes) {
        List<List<Integer>> edges = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }
        for(int[] dl : dislikes) {
            edges.get(dl[0]).add(dl[1]);
            edges.get(dl[1]).add(dl[0]);
        }
        int[] visited = new int[N+1];
        for(int i = 1; i <= N; i++) {
            if( visited[i] == 0 && !dfs(edges, i, 1, visited)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode886 lc = new LeetCode886();
//        int N = 4;
//        int[][] dislikes = {{1,2},{1,3},{2,4}};
        int N = 3;
        int[][] dislikes =  {{1,2},{1,3},{2,3}};
        boolean ret = lc.possibleBipartition(N, dislikes);
        System.out.println(ret);
    }

}
