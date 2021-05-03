package cn.karent.leetcode;

import java.util.*;

/**
 * 最大人工岛
 */
public class LeetCode827 {

    /**********************************************************************
     * 使用并查集算法
     **********************************************************************/
    class DSU {

        private int n = 0;
        private int[] parent = null;
        private int[] rank = null;

        public DSU(int n) {
            this.n = n;
            parent = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
            }
            rank = new int[n];
            Arrays.fill(rank, 1);
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
            if( px1 == px2) {
                return;
            }
            if( rank[px1] < rank[px2]) {
                int tmp = px1;
                px1 = px2;
                px2 = tmp;
            }
            parent[px2] = px1;
            rank[px1] += rank[px2];
        }

        public int get(int x) {
            int px = find(x);
            return rank[px];
        }

    }

    /**
     * 使用并查集
     * @param grid
     * @return
     */
    public int largestIsland1(int[][] grid) {
        int m = grid.length;
        if( m == 0) {
            return 0;
        }
        int n = grid[0].length;
        DSU dsu = new DSU(m * n);
        int ret = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if( grid[i][j] == 1) {
                    int x = i * n + j;
                    // 左
                    if( j > 0 && grid[i][j-1] == 1) {
                        dsu.union(x, x-1);
                    }
                    if( i > 0 && grid[i-1][j] == 1) {
                        dsu.union(x, x - n);
                    }
                    ret = Math.max(ret, dsu.get(x));
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if( grid[i][j] == 0) {
                    int x = i * n + j;
                    int val = 1;
                    int px = -1;
                    // 左
                    if( j > 0 && grid[i][j-1] == 1) {
                        px = dsu.find(x - 1);
                        if( !set.contains(px)) {
                            val += dsu.get(x - 1);
                            set.add(px);
                        }
                    }
                    // 右
                    if( j+1 < n && grid[i][j+1] == 1) {
                        px = dsu.find(x + 1);
                        if( !set.contains(px)) {
                            val += dsu.get(x+1);
                            set.add(px);
                        }
                    }
                    // 上
                    if( i > 0 && grid[i-1][j] == 1) {
                        px = dsu.find(x - n);
                        if( !set.contains(px)) {
                            val += dsu.get(x-n);
                            set.add(px);
                        }
                    }
                    // 下
                    if( i+1 < m && grid[i+1][j] == 1) {
                        px = dsu.find(x + n);
                        if( !set.contains(px)) {
                            val += dsu.get(x+n);
                            set.add(px);
                        }
                    }
                    ret = Math.max(ret, val);
                    set.clear();
                }
            }
        }
        return ret;
    }
    /***********************************************************************************************
     * 使用深度优先遍历的方法, 先给每个连通块分配一个不同的编号, 然后第二次遍历的使用给统计每个联通块的大小
     *
    ************************************************************************************************/

    int[] rd = {1, -1, 0, 0};
    int[] cd = {0, 0, 1, -1};
    int[] sns = null;

    private void dfs(int[][] grid, int x, int y, int m, int n, int sn, boolean[][] visited) {
        if( x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0 || visited[x][y]) {
            return ;
        }
        visited[x][y] = true;
        grid[x][y] = sn;
        for(int i = 0; i < 4; i++) {
            dfs(grid, x+rd[i], y+cd[i], m, n, sn, visited);
        }
    }

    private void dfsCnt(int[][] grid, int x, int y, int m, int n, int sn, boolean[][] visited) {
        if( x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != sn || visited[x][y]) {
            return;
        }
        visited[x][y] = true;
//        int val = 1;
        sns[sn]++;
        for(int i = 0; i < 4; i++) {
            dfsCnt(grid, x + rd[i], y + cd[i], m, n, sn, visited);
        }
//        return val;
    }

    private int cntNeighbor(int[][] grid, int x, int y, int m, int n, boolean[][] visited) {
        int val = 1;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < 4; i++) {
            int nx = x + rd[i];
            int ny = y + cd[i];
            if( nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] == 0) {
                continue;
            }
            int idx = grid[nx][ny];
            if( !set.contains(idx)) {
                val += sns[idx];
                set.add(idx);
            }
        }
        return val;
    }

    public int largestIsland(int[][] grid) {
        int m = grid.length;
        if( m == 0) {
            return 0;
        }
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int sn = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if( grid[i][j] == 1 && !visited[i][j] ) {
                    dfs(grid, i, j, m, n, sn, visited);
                    sn++;
                }
            }
        }
        visited = new boolean[m][n];
        int ret = 0;
        sns = new int[sn];
        // 统计岛屿的数量
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if( grid[i][j] != 0) {
                    dfsCnt(grid, i, j, m, n, grid[i][j], visited);
                }
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if( grid[i][j] == 0 ) {
                    ret = Math.max(ret , cntNeighbor(grid, i, j, m, n, visited));
                }
            }
        }
        return ret == 0 ? sns[1] : ret;
    }

    public static void main(String[] args) {
        LeetCode827 lc = new LeetCode827();
//        int[][] grid = {{1, 0}, {0,1}};
//        int[][] grid = {{1, 1}, {1, 0}};
//        int[][] grid = {{1,0},{1,0}};
//        int[][] grid = {{1}};
//        int[][] grid = {{1}};
        int[][] grid = {{1,1},{1,1}};
        int ret = lc.largestIsland(grid);
        System.out.println(ret);
    }

}
