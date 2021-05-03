package cn.karent.leetcode;

/**
 * 由斜杠划分的区域
 */
public class LeetCode959 {
    class DSU {

        private int[] parent = null;

        private int n;

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

        public void union(int x1, int x2) {
            int px1 = find(x1);
            int px2 = find(x2);
            if( px1 != px2) {
                parent[px1] = px2;
            }
        }

        public int count() {
            int cnt = 0;
            for(int i = 0; i < n; i++) {
                if( parent[i] == i) {
                    cnt++;
                }
            }
            return cnt;
        }

    }

    public int regionsBySlashes(String[] grid) {
        int N = grid.length;
        int size = 4 * N * N;
        DSU dsu = new DSU(size);
        for(int i = 0; i < N; i++) {
            String s = grid[i];
            for(int j = 0; j < N; j++) {
                // 单元格
                char ch = s.charAt(j);
                int idx = 4 * (i * N + j);
                if( ch == '/') {
                    dsu.union(idx, idx+1);
                    dsu.union(idx+2, idx+3);
                } else if( ch == '\\') {
                    dsu.union(idx+1, idx+2);
                    dsu.union(idx, idx+3);
                } else {
                    dsu.union(idx, idx+1);
                    dsu.union(idx+2, idx+3);
                    dsu.union(idx, idx+3);
                }
                // 单元格之间合并
                int right = idx+4;
                int down = 4 * ((i+1) * N + j);
                if( j + 1 < N) {
                    dsu.union(idx+2, right);
                }
                if( i + 1 < N) {
                    dsu.union(idx+3, down+1);
                }
            }
        }
        return dsu.count();
    }

    public static void main(String[] args) {
        LeetCode959 lc = new LeetCode959();
        String[] grid = {" /", "/ "};
        int ret = lc.regionsBySlashes(grid);
        System.out.println(ret);
    }

}
