package cn.karent.leetcode;

import cn.karent.util.*;
import java.util.*;

/**
 * 树中距离之和
 */
public class LeetCode834 {

    private int[] distance = null;

    private int[] nodeNum = null;

    private int N = 0;

    private void dfs(List<Integer>[] edges, int idx, int parent) {
        List<Integer> edge = edges[idx];
        for(int e : edge) {
            if( e == parent) {
                continue;
            }
            dfs(edges, e, idx);
            nodeNum[idx] += nodeNum[e];
            distance[idx] += nodeNum[e] + distance[e];
        }
        nodeNum[idx]++;
    }

    private void preOrder(List<Integer>[] edges, int idx, int parent) {
        if( parent >= 0) {
            distance[idx] = distance[parent] - nodeNum[idx] + (N - nodeNum[idx]);
        }
        List<Integer> edge = edges[idx];
        for(int e : edge) {
            if( e == parent) {
                continue;
            }
            preOrder(edges, e, idx);
        }
    }

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        distance = new int[N];
        nodeNum = new int[N];
        this.N = N;
        List<Integer>[] edgeList = new List[N];
        for(int i = 0; i < N; i++) {
            edgeList[i] = new ArrayList<>();
        }
        for(int[] edge : edges) {
            edgeList[edge[0]].add(edge[1]);
            edgeList[edge[1]].add(edge[0]);
        }
        dfs(edgeList, 0, -1);
        preOrder(edgeList, 0, -1);
        return distance;
    }

    public static void main(String[] args) {
        LeetCode834 lc = new LeetCode834();
        int N = 6;
        int[][] edges = {{0,1},{0,2},{2,3},{2,4},{2,5}};
        int[] rets = lc.sumOfDistancesInTree(N, edges);
        for(int ret : rets) {
            System.out.print(ret + " ");
        }
    }
}
