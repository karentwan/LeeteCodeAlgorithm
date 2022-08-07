package cn.karent.leetcode_v1.weeklycontest305;

import java.util.*;

/******************************************
 * 受限条件下可到达节点的数目
 * @author wan
 * @date 2022.08.07 10:34
 ******************************************/
public class LeetCode6139 {

    private int cnt = 0;

    private void dfs(List[] edgeList, int idx, int parent, boolean hasRestric, Set<Integer> restics) {
        hasRestric = hasRestric || restics.contains(idx);
        if ( hasRestric) {
            cnt++;
        }
        List<Integer> edges = edgeList[idx];
        for (Integer edge : edges) {
            if (edge != parent) {
                dfs(edgeList, edge, idx, hasRestric, restics);
            }
        }
    }

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List[] edgeList = new List[n];
        for (int i = 0; i < n; i++) {
            edgeList[i] = new ArrayList();
        }
        for (int[] edge : edges) {
            edgeList[edge[0]].add(edge[1]);
            edgeList[edge[1]].add(edge[0]);
        }
        Set<Integer> restrics = new HashSet<>();
        for (int t : restricted) {
            restrics.add(t);
        }
        dfs(edgeList, 0, -1,false, restrics);
        return n - cnt;
    }

    public static void main(String[] args) {
        LeetCode6139 lc = new LeetCode6139();
        int n = 7;
        int[][] edges = {{0,1},{0,2},{0,5},{0,4},{3,2},{6,5}};
        int[] resticted = {4,2,1};
        System.out.println(lc.reachableNodes(n, edges, resticted));
    }

}
