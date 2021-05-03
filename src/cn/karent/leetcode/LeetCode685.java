package cn.karent.leetcode;

/**
 * 冗余连接 二
 */
public class LeetCode685 {

    class DSU {

        private int n = 0;
        private int[] parent = null;
        private int[] p = null;  // 直接父类

        public DSU(int n) {
            this.n = n;
            parent = new int[n];
            p = new int[n];

            for(int i = 0; i < n; i++) {
                parent[i] = i;
                p[i] = i;
            }
        }

        private int find(int idx) {
            if( parent[idx] == idx) {
                return idx;
            }
            parent[idx] = find(parent[idx]);
            return parent[idx];
        }

        public int union(int x1, int x2) {
            int px1 = find(x1);
            int px2 = find(x2);
            if( px1 == px2) {  // 环路
                return 1;
            } else if( x2 != px2) {  // 冲突边
                return 2;
            }
            parent[px2] = px1;
            p[x2] = x1;
            return 0;
        }

        public int getFather(int x) {
            return p[x];
        }

    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        DSU dsu = new DSU(n);
        int[] ret = new int[2];
        int conflict = -1;
        int cycle = -1;
        for(int i = 0; i < n; i++) {
            int x1 = edges[i][0], x2 = edges[i][1];
            int status = dsu.union(x1-1, x2-1);
            if( status == 1) {
                cycle = i;
            } else if( status == 2) {
                conflict = i;
            }
        }
        if( conflict < 0) {  // 如果没有冲突边
            ret[0] = edges[cycle][0];
            ret[1] = edges[cycle][1];
        } else {
            if( cycle < 0) {  // 如果没有环, 那么冲突边就是多余边
                ret[0] = edges[conflict][0];
                ret[1] = edges[conflict][1];
            } else {
                int x1 = edges[conflict][0];
                int x2 = edges[conflict][1];
                ret[0] = dsu.getFather(x2-1)+1;
                ret[1] = x2;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode685 lc = new LeetCode685();
//        int[][] edges = {{1,2}, {1,3}, {2,3}};
//        int[][] edges = {{1,2}, {2,3}, {3,4}, {4,1}, {1,5}};
        int[][] edges = {{2,1},{3,1},{4,2},{1,4}};
        int[] ret = lc.findRedundantDirectedConnection(edges);
        if( ret == null) {
            System.out.println("error");
            return;
        }
        System.out.println("(" + ret[0] + "," + ret[1] + ")");
    }


}
