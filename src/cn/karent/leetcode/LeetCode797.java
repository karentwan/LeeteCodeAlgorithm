package cn.karent.leetcode;

import java.util.*;

/**
 * 所有可能的路径
 */
public class LeetCode797 {

    public void dfs(List<List<Integer>> edges, int idx, int end, List<List<Integer>> rets, List<Integer> ret, boolean[] visited) {
        ret.add(idx);
        if( idx == end) {
            rets.add(new ArrayList<>(ret));
            ret.remove(ret.size()-1);
            return;
        }
        for(int e : edges.get(idx)) {
            if( !visited[e]) {
                visited[e] = true;
//                ret.add(e);
                dfs(edges, e, end, rets, ret, visited);
//                ret.remove(ret.size()-1);
                visited[e] = false;
            }
        }
        ret.remove(ret.size()-1);
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> rets = new ArrayList<>();
        if( n == 0) {
            return rets;
        }
        List<List<Integer>> edges = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        for(int i = 0; i < graph.length; i++) {
            for(int e : graph[i]) {
                edges.get(i).add(e);
            }
        }
//        List<Integer> ret = new Array
        dfs(edges, 0, n-1, rets, new ArrayList<>(), new boolean[n]);
        return rets;
    }

}
