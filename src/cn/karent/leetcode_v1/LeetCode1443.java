package cn.karent.leetcode_v1;

import cn.karent.util.LeetCodeUtil;

import java.util.*;

/**
 * 收集树上所有苹果的最少时间
 */
public class LeetCode1443 {

    private int dfs(List<List<Integer>> edges, int idx, List<Boolean> hasApple, boolean[] visited) {
        List<Integer> edge = edges.get(idx);
        int ret = 0;
        for (int e : edge) {
            if( !visited[e]) {
                visited[e] = true;
                ret += dfs(edges, e, hasApple, visited);
            }
        }
        if( ret != 0 ) {
            return ret + 1;
        }
        return hasApple.get(idx) ? 1 : 0;
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        if( n == 0) {
            return 0;
        }
        List<List<Integer>> edge = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edge.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            edge.get(e[0]).add(e[1]);
            edge.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[n];
        visited[0] = true;
        int ret = dfs(edge, 0, hasApple, visited) - 1;
        return ret > 0 ? ret * 2 : 0;
    }

    public static void main(String[] args) {
        LeetCode1443 lc = new LeetCode1443();
//        int n = 7;
//        int[][] edges = {{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}};
//        Boolean[] arr = {false,false,true,false,true,true,false};
//        int n = 7;
//        int[][] edges = {{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}};
//        Boolean[] arr = {false,false,true,false,false,true,false};
//        int n = 7;
//        int[][] edges = {{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}};
//        Boolean[] arr = {false,false,false,false,false,false,false};
        int n = 3;
        int[][] edges = {{0,2},{1,2}};
        Boolean[] arr = {false, true, false};
        List<Boolean> hasApple = LeetCodeUtil.arr2list(arr);
        int ret = lc.minTime(n, edges, hasApple);
        System.out.println(ret);
    }

}
