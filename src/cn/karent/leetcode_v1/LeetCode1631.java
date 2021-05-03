package cn.karent.leetcode_v1;

import java.util.*;

/**
 * 最小体力消耗路径
 */
public class LeetCode1631 {

    class DSU {

        private int n = 0;
        private int[] parent = null;

        public DSU(int n) {
            this.n = n;
            parent = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int idx) {
            if( parent[idx] == idx) {
                return idx;
            }
            parent[idx] = find(parent[idx]);
            return parent[idx];
        }

        public void union(Edge edge) {
            int px1 = find(edge.from);
            int px2 = find(edge.to);
            if( px1 != px2) {
                parent[px2] = px1;
            }
        }

        public boolean connect(int x1, int x2) {
            int px1 = find(x1);
            int px2 = find(x2);
            return px1 == px2;
        }

    }

    class Edge {
        private int from = 0;
        private int to = 0;
        private int weight = 0;
        public Edge() {

        }

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        if( m == 0) {
            return 0;
        }
        int n = heights[0].length;
        List<Edge> edges = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int nx = i + 1, ny = j;
                if( nx < m) {
                    edges.add(new Edge(i * n + j, nx * n + ny,
                            Math.abs(heights[nx][ny] - heights[i][j])));
                }
                nx = i;
                ny = j+1;
                if( ny < n) {
                    edges.add(new Edge(i * n+j, nx * n + ny,
                            Math.abs(heights[nx][ny]-heights[i][j])));
                }
            }
        }
        Collections.sort(edges, (Edge e1, Edge e2) -> {
           return e1.weight - e2.weight;
        });
        DSU dsu = new DSU(m * n);
        int end = m * n - 1;
        int ret = 0;
        for(int i = 0; i < edges.size(); i++) {
            Edge edge = edges.get(i);
            dsu.union(edge);
            if( dsu.connect(0, end) ) {
                ret = edge.weight;
                break;
            }
        }
        return ret;
    }

    /**********************************dfs尝试 error, 不满足最优子结构, 无法使用记忆化*****************************************/
    private int[][] memo = null;

    private int dfs(int[][] heights, int x, int y, int m, int n, boolean[][] visited) {
        if( x == m-1 && y == n-1) {
            return 0;
        }
        if( memo[x][y] != Integer.MAX_VALUE) {
            return memo[x][y];
        }
        int[] rd = {1, -1, 0, 0};
        int[] cd = {0, 0, 1, -1};
        visited[x][y] = true;
        for(int i = 0; i < 4; i++) {
            int nx = x + rd[i];
            int ny = y + cd[i];
            if( nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                memo[x][y] = Math.min(memo[x][y], Math.max(dfs(heights, nx, ny, m, n, visited),
                        Math.abs(heights[x][y]-heights[nx][ny])));
            }
        }
        visited[x][y] = false;
        return memo[x][y];
    }

    public int minimumEffortPath1(int[][] heights) {
        int m = heights.length;
        if( m == 0) {
            return 0;
        }
        int n = heights[0].length;
        memo = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }
        int ret = dfs(heights, 0, 0, m, n, new boolean[m][n]);
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1631 lc = new LeetCode1631();
//        int[][] heights = {{1,2,2},{3,8,2},{5,3,5}};
//        int[][] heights = {{3}};
        int[][] heights = {{1,10,6,7,9,10,4,9}};
//        int[][] heights = {{7,9},{3,6},{6,9},{3,6}};
        int ret = lc.minimumEffortPath(heights);
        System.out.println(ret);
        ret = lc.minimumEffortPath1(heights);
        System.out.println(ret);
    }

}
