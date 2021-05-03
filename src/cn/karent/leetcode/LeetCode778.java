package cn.karent.leetcode;

import java.util.*;

/**
 * 水位上升的泳池中游泳
 */
public class LeetCode778 {

    /**
     * 这里不能回溯, 否则会超时, 已经遍历过了, 其他节点就不用遍历过来了, 浪费时间
     * @param grid
     * @param x
     * @param y
     * @param n
     * @param mid
     * @param visited
     * @return
     */
    private boolean dfs(int[][] grid, int x, int y, int n, int mid, boolean[][] visited) {
        if( x < 0 || x >= n || y < 0 || y >= n || visited[x][y] || grid[x][y] > mid) {
            return false;
        }
        if( x == n-1 && y == n-1) {
            return true;
        }
        int[] rd = {-1, 1, 0, 0};
        int[] cd = {0, 0, -1, 1};
        visited[x][y] = true;
        for(int i = 0; i < 4; i++) {
            int nx = x + rd[i];
            int ny = y + cd[i];
            if( dfs(grid, nx, ny, n, mid, visited)) {
                return true;
            }
        }
//        grid[x][y] = tmp;
        return false;
    }

    /**
     * 二分查找加depth first search
     * @param grid
     * @return
     */
    public int swimInWater1(int[][] grid) {
        int n = grid.length;
        if( n == 0) {
            return 0;
        }
        int left = 0, right = n * n;
        while( left < right ) {
            int mid = left + (right - left) / 2;
            if( dfs(grid, 0, 0, n, mid, new boolean[n][n])) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }

    class Edge {
        public int from = 0;
        public int to = 0;
        public int weight = 0;
        public Edge() {}
        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    class DSU {
        private int n = 0;
        private int[] parent = null;
        public DSU(int n) {
            this.parent = new int[n];
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

        public void union(int x1, int x2) {
            int px1 = find(x1);
            int px2 = find(x2);
            if( px1 != px2) {
                parent[px2] = px1;
            }
        }

        public boolean isConnect(int x1, int x2) {
            int px1 = find(x1);
            int px2 = find(x2);
            return px1 == px2;
        }
    }

    /**
     * 使用并查集
     * @param grid
     * @return
     */
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        if( n == 0) {
            return 0;
        }
        List<Edge> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int nx = i + 1, ny = j;
                if( nx < n) {
                    list.add(new Edge(i * n + j, nx * n + ny, Math.max(grid[i][j], grid[nx][ny])));
                }
                nx = i;
                ny = j+1;
                if( ny < n) {
                    list.add(new Edge(i * n + j, nx * n + ny, Math.max(grid[i][j], grid[nx][ny])));
                }
            }
        }
        Collections.sort(list, (Edge e1, Edge e2) -> {
            return e1.weight - e2.weight;
        });
        int ret = 0;
        DSU dsu = new DSU(n * n);
        for(int i = 0; i < list.size(); i++) {
            Edge edge = list.get(i);
            dsu.union(edge.from, edge.to);
            if( dsu.isConnect(0, n*n-1)) {
                ret = edge.weight;
                break;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode778 lc = new LeetCode778();
//        int[][] grid = {{0,2},{1,3}};
        int[][] grid = {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};
//        int[][] grid = {{26,99,80,1,89,86,54,90,47,87},{9,59,61,49,14,55,77,3,83,79},{42,22,15,5,95,38,74,12,92,71},{58,40,64,62,24,85,30,6,96,52},{10,70,57,19,44,27,98,16,25,65},{13,0,76,32,29,45,28,69,53,41},{18,8,21,67,46,36,56,50,51,72},{39,78,48,63,68,91,34,4,11,31},{97,23,60,17,66,37,43,33,84,35},{75,88,82,20,7,73,2,94,93,81}};
        int ret = lc.swimInWater(grid);
        System.out.println(ret);
    }

}
