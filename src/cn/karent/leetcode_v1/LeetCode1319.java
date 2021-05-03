package cn.karent.leetcode_v1;

public class LeetCode1319 {

    class DSU {

        private int[] parent = null;

        private int n = 0;

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

        public int union(int[] connection) {
            int px1 = find(connection[0]);
            int px2 = find(connection[1]);
            if( px1 != px2) {
                parent[px1] = px2;
                return 0;
            }
            return 1;
        }

        public int count(int rdt) {
            int cnt = 0;
            for(int i = 0; i < n; i++) {
                if( parent[i] == i) {
                    cnt++;
                }
            }
            if( rdt >= cnt-1) {
                return cnt - 1;
            }
            return -1;
        }

    }

    public int makeConnected(int n, int[][] connections) {
        DSU dsu = new DSU(n);
        int rdt = 0;
        for(int[] connection : connections) {
            rdt += dsu.union(connection);
        }
        return dsu.count(rdt);
    }

    public static void main(String[] args) {
        LeetCode1319 lc = new LeetCode1319();
//        int n = 6;
//        int[][] connections = {{0,1},{0,2},{0,3},{1,2},{1,3}};
        int n = 6;
        int[][] connections =  {{0,1},{0,2},{0,3},{1,2}};
        int ret = lc.makeConnected(n, connections);
        System.out.println(ret);
    }

}
