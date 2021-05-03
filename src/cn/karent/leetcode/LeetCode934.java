package cn.karent.leetcode;

import java.util.*;

/**
 * 最短的桥
 */
public class LeetCode934 {

    private int m;

    private int n;

    private int ret = Integer.MAX_VALUE / 2;

    private int[] rows = {0, 0, 1, -1};

    private int[] colums = {1, -1, 0, 0};

    // 架桥  TLE
    private void dfs(int[][] island, int x, int y, int path) {
        if( x >= m || y >= n || x < 0 || y < 0 || path >= ret || island[x][y] == -1) {
            return;
        }
        if( island[x][y] == 0) {
            path++;
        }
        if( island[x][y] == 1) {
            ret = Math.min(ret, path);
        }
        int t = island[x][y];
        island[x][y] = -1;
        for (int i = 0; i < 4; i++) {
            int nx = x + rows[i];
            int ny = y + colums[i];
            dfs(island, nx, ny, path);
        }
        island[x][y] = t;
    }

    // TLE
    public int shortestBridge1(int[][] A) {
        m = A.length;
        if( m == 0) {
            return 0;
        }
        n = A[0].length;
        boolean flag = false;
        for (int i = 0; i < m; i++) {
            if( flag ) {
                return ret;
            }
            for (int j = 0; j < n; j++) {
                if( A[i][j] == 1) {
                    color(A, i, j, 2);
                    dfs(A, i, j, 0);
                    flag = true;
                    break;
                }
            }
        }
        return 0;
    }

    // 着色
    private void color(int[][] island, int x, int y, int c) {
        if( x >= m || y >= n || x < 0 || y < 0 || island[x][y] == 0 || island[x][y] == c) {
            return;
        }
        island[x][y] = c;
        for (int i = 0; i < 4; i++) {
            int nx = x + rows[i];
            int ny = y + colums[i];
            color(island, nx, ny, c);
        }

    }

   // 使用 DFS + BFS
    public int shortestBridge(int[][] A) {
        m = A.length;
        if( m == 0) {
            return 0;
        }
        n = A[0].length;
        boolean flag = false;
        Queue<Pair> que = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < m; i++) {
            if( flag ) {
                return ret;
            }
            for (int j = 0; j < n; j++) {
                if( A[i][j] == 1) {
                    dfs(que, visited, A, i, j);
                    ret = bfs(que, visited, A);
                    flag = true;
                    break;
                }
            }
        }
        return 0;
    }

    class Pair{
        private int x;
        private int y;
        private int path;

        public Pair() {
        }

        public Pair(int x, int y, int path) {
            this.x = x;
            this.y = y;
            this.path = path;
        }

    }

    private void dfs(Queue<Pair> que, Set<String> visited, int[][] island, int x, int y) {
        if( x < 0 || x >= m || y < 0 || y >= n || island[x][y] == 2 || island[x][y] == 0) {
            return;
        }
        Pair pair = new Pair(x, y, 0);
        que.offer(pair);
        visited.add(x + "-" + y);
        island[x][y] = 2;
        for (int i = 0; i < 4; i++) {
            int nx = x + rows[i];
            int ny = y + colums[i];
            dfs(que, visited, island, nx, ny);
        }
    }

    private int bfs(Queue<Pair> que, Set<String> visited, int[][] island) {
        String key = null;
        boolean flag = false;
        Pair p = null;
        int ret = Integer.MAX_VALUE;
        while( !que.isEmpty() && !flag) {
            for(int i = 0; i < que.size(); i++) {
                p = que.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = p.x + rows[j];
                    int ny = p.y + colums[j];
                    if( nx >= 0 && nx < m && ny >= 0 && ny < n ) {
                        if( island[nx][ny] == 1) {
                            flag = true;
                            ret = Math.min(ret, p.path);
                        }
                        Pair next = new Pair(nx, ny, p.path + 1);
                        if( island[nx][ny] == 2) {
                            next.path--;
                        }
                        key = nx + "-" + ny;
                        if( visited.contains(key) ) {
                            continue;
                        }
                        que.offer(next);
                        visited.add(key);
                    }
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode934 lc = new LeetCode934();
//        int[][] island = {{0,1},{1,0}};
//        int[][] island = {{0,1,0},{0,0,0},{0,0,1}};
//        int[][] island = {{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}};
//        int[][] island = {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,1,1,0,1,1,0,0,0,0},{0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,0,1,1,0},{0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,0,0,0},{0,0,0,0,0,0,0,0,0,1,0,1,1,0,0,1,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,0,1,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,1,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,1,1,1,0},{0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,0},{0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0}};
//        int[][] island = {{0,1,0,0,0},{0,1,0,1,1},{0,0,0,0,1},{0,0,0,0,0},{0,0,0,0,0}};
        int[][] island = {{0,1,0,0,0,0},{0,1,1,1,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{1,1,0,0,0,0}};
//        int[][] island = {{0,0,0,0,0,0,0},{1,0,0,0,0,0,0},{1,0,0,0,0,0,0},{1,1,0,0,0,0,0},{0,1,0,1,1,1,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0}};
        int ret = lc.shortestBridge(island);
        System.out.println(ret);
    }

}
