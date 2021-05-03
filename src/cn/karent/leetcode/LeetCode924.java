package cn.karent.leetcode;

import java.util.*;

/**
 * 尽量减少恶意软件的传播
 */
public class LeetCode924 {

    class DSU {

        private int n = 0;
        private int[] parent = null;
        private int[] sz = null;

        public DSU(int n) {
            this.n = n;
            parent = new int[n];
            sz = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
            }
            Arrays.fill(sz, 1);
        }

        public int find(int idx) {
            if( parent[idx] == idx) {
                return idx;
            }
            parent[idx] = find(parent[idx]);
            return parent[idx];
        }

        public void union(int x1, int x2) {
            int px1 = find(x1);
            int px2 = find(x2);
            if( px1 != px2) {
                parent[px2] = px1;
                sz[px1] += sz[px2];
            }
        }

        public int getSize(int x) {
            int px = find(x);
            return sz[px];
        }

    }

    public int minMalwareSpread(int[][] graph, int[] initial) {
        int m = graph.length;
        DSU dsu = new DSU(m);
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < m; j++) {
                if( graph[i][j] == 1) {
                    dsu.union(i, j);
                }
            }
        }
        int[] cnts = new int[m];
        for(int vertex : initial) {
            cnts[dsu.find(vertex)]++;
        }
        int ans = -1, sz = -1;
        for(int vertex : initial) {
            int root = dsu.find(vertex);
            int ts = dsu.getSize(root);
            if( cnts[root] == 1) {  // unique vertex
                if( ts > sz || (ts == sz && vertex < ans)) {
                    ans = vertex;
                    sz = ts;
                }
            }
        }
        if( ans == -1) {
            ans = Integer.MAX_VALUE;
            for(int vertex : initial) {
                ans = Math.min(ans, vertex);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode924 lc = new LeetCode924();
//        int[][] graph = {{1,0,0,0},{0,1,0,0},{0,0,1,1},{0,0,1,1}};
//        int[] initial = {3,1};
        int[][] graph = {{1,0,0,0,0,0},{0,1,0,0,1,0},{0,0,1,1,0,0},{0,0,1,1,0,0},{0,1,0,0,1,0},{0,0,0,0,0,1}};
        int[] initial = {1,2,5};
        int ans = lc.minMalwareSpread(graph, initial);
        System.out.println(ans);
    }

}
