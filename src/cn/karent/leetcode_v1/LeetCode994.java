package cn.karent.leetcode_v1;

import java.util.*;

/**
 * 腐烂的橘子
 */
public class LeetCode994 {

    class Node {
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x &&
                    y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<Node> que = new LinkedList<>();
        int[] rows = {1, -1, 0, 0};
        int[] cols = {0, 0, 1, -1};
        int m = grid.length;
        if( m == 0 ) {
            return 0;
        }
        int n = grid[0].length;
        Set<Node> visited = new HashSet<>();
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if( grid[i][j] == 2 ) {
                    Node node = new Node(i, j);
                    que.offer(node);
                    visited.add(node);
                } else if( grid[i][j] == 1) {
                    cnt++;
                }
            }
        }
        int ret = 0;
        while( !que.isEmpty() && cnt > 0) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                Node node = que.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = node.x + rows[j];
                    int ny = node.y + cols[j];
                    if( nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                        Node tmp = new Node(nx, ny);
                        if( visited.contains(tmp)) {
                            continue;
                        }
                        grid[nx][ny] = 2;
                        que.offer(tmp);
                        visited.add(tmp);
                        cnt--;
                    }
                }
            }
            ret++;
        }
        return cnt == 0 ? ret : -1;
    }

    public static void main(String[] args) {
        LeetCode994 lc = new LeetCode994();
//        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        int[][] grid = {{2,1,1},{0,1,1},{1,0,1}};
//        int[][] grid = {{0}};
        int ret = lc.orangesRotting(grid);
        System.out.println(ret);
    }

}
