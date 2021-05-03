package cn.karent.leetcode_v2;

import java.util.*;

/**
 * 检查边长度限制的路径是否存在
 * 似乎是使用并查集来操作
 * @author wan
 * @date 2021.04.06
 */
public class LeetCode1697 {

    static class DSU {

        private int n;
        private int[] parent;

        public DSU(int n) {
            this.n = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int idx) {
            return parent[idx] == idx ? idx : (parent[idx] = find(parent[idx]));
        }

        public void union(int x1, int x2) {
            int px1 = find(x1);
            int px2 = find(x2);
            if( px1 != px2) {
                parent[px1] = px2;
            }
        }

        public boolean isConnected(int x1, int x2) {
            int px1 = find(x1);
            int px2 = find(x2);
            return px1 == px2;
        }

    }

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Arrays.sort(edgeList, (k1, k2) -> {
            return k1[2] - k2[2];
        });
        Integer[] indices = new Integer[queries.length];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (k1, k2) -> {
            int[] q1 = queries[k1];
            int[] q2 = queries[k2];
            return q1[2] - q2[2];
        });
        DSU dsu = new DSU(n);
        int i = 0;
        boolean[] rets = new boolean[queries.length];
        for (int j = 0; j < queries.length; j++) {
            int idx = indices[j];
            int[] query = queries[idx];
            while (i < edgeList.length && edgeList[i][2] < query[2]) {
                dsu.union(edgeList[i][0], edgeList[i][1]);
                i++;
            }
            rets[idx] = dsu.isConnected(query[0], query[1]);
        }
        return rets;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] edgeList = {{0,1,2},{1,2,4},{2,0,8},{1,0,16}};
        int[][] queries = {{0,1,2},{0,2,5}};
//        int n = 5;
//        int[][] edgeList = {{0,1,10},{1,2,5},{2,3,9},{3,4,13}};
//        int[][] queries = {{0,4,14},{1,4,13}};
        LeetCode1697 lc = new LeetCode1697();
        boolean[] rets = lc.distanceLimitedPathsExist(n, edgeList, queries);
        for (boolean ret : rets) {
            System.out.print(ret + " ");
        }
        System.out.println();
    }

}
