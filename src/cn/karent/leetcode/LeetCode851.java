package cn.karent.leetcode;

import java.util.*;

/**
 * 喧闹和富有
 * 以图的形式进行搜索
 */
public class LeetCode851 {

    private int[] ret = null;

    private int dfs(List<List<Integer>> edges, int idx, int[] quiet) {
        if( ret[idx] != -1) {
            return ret[idx];
        }
        int val = idx;
        for(int edge : edges.get(idx)) {
            int tmp = dfs(edges, edge, quiet);
            if( quiet[tmp] < quiet[val]) {
                val = tmp;
            }
        }
        ret[idx] = val;
        return val;
    }

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        List<List<Integer>> edges = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        for(int[] rich : richer) {
            edges.get(rich[1]).add(rich[0]);
        }
        ret = new int[n];
        Arrays.fill(ret, -1);
        for(int i = 0; i < n; i++) {
            if( ret[i] == -1) {
                dfs(edges, i, quiet);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode851 lc = new LeetCode851();
        int[][] richer = {{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}};
        int[] quiet = {3,2,5,4,6,1,7,0};
        int[] ret = lc.loudAndRich(richer, quiet);
        for(int i : ret) {
            System.out.print(i + " ");
        }
    }
}
