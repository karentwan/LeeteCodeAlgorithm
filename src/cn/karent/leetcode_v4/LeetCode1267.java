package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 统计参与通信的服务器
 * @author wan
 * @date 2021.05.26
 ********************************************/
public class LeetCode1267 {

    class DSU {
        private int[] parent;
        private int[] rank;
        private int n;

        public DSU(int n) {
            this.n = n;
            parent = new int[n];
            rank = new int[n];
            Arrays.fill(rank, 1);
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int idx) {
            return idx == parent[idx] ? idx :
                    (parent[idx] = find(parent[idx]));
        }

        public void union(int x1, int x2) {
            int px1 = find(x1);
            int px2 = find(x2);
            if( px1 != px2) {
                parent[px2] = px1;
                rank[px1] += rank[px2];
            }
        }

        public int count() {
            int ret = 0;
            for (int i = 0; i < this.n; i++) {
                if( parent[i] == i && rank[i] > 1) {
                    ret += rank[i];
                }
            }
            return ret;
        }

    }

    public int countServers(int[][] grid) {
        int m = grid.length;
        if( m == 0) return 0;
        int n = grid[0].length;
        DSU dsu = new DSU(m * n);
        for (int i = 0; i < m; i++) {
            int j = 0, k = 0;
            while (j < n && grid[i][j] == 0) {
                j++;
            }
            k = j+1;
            while (k < n) {
                if( grid[i][k] == 1) {
                    dsu.union(i * n + j, i * n + k);
                }
                k++;
            }
        }
        for (int i = 0; i < n; i++) {
            int j = 0, k = 0;
            while (j < m && grid[j][i] == 0) {
                j++;
            }
            k = j+1;
            while ( k < m) {
                if( grid[k][i] == 1) {
                    dsu.union(j * n + i, k * n + i);
                }
                k++;
            }
        }
        return dsu.count();
    }

    public static void main(String[] args) {
        LeetCode1267 lc = new LeetCode1267();
        int[][] arr = {{1,1,0,0},{0,0,1,0},{0,0,1,0},{0,0,0,1}};
        int ret = lc.countServers(arr);
        System.out.println(ret);
    }

}
