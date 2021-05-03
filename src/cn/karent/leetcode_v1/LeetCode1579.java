package cn.karent.leetcode_v1;

import java.util.*;

/**
 * 保证图可完全遍历
 */
public class LeetCode1579 {

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

        public int union(int x1, int x2) {
            int px1 = find(x1);
            int px2 = find(x2);
            if( px1 != px2) {
                parent[px1] = px2;
                return 0;
            }
            return 1;
        }

        public int count() {
            int ret = 0;
            for(int i = 0; i < n; i++) {
                if( parent[i] == i) {
                    ret++;
                }
            }
            return ret;
        }

    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        // 先给边排个序, 让第三种类型的边在前
        Arrays.sort(edges, (int[] edge1, int[] edge2) -> {
            return edge2[0] - edge1[0];
        });
        DSU alice = new DSU(n);
        DSU bob = new DSU(n);
        int ret = 0;
        for(int[] edge : edges) {
            if( edge[0] == 1) {
                ret += alice.union(edge[1]-1, edge[2]-1);
            } else if( edge[0] == 2) {
                ret += bob.union(edge[1]-1, edge[2]-1);
            } else {
                ret += alice.union(edge[1]-1, edge[2]-1);
                bob.union(edge[1]-1, edge[2]-1);
            }
        }
        return alice.count() == 1 && bob.count() == 1 ? ret : -1;
    }

    public static void main(String[] args) {
        LeetCode1579 lc = new LeetCode1579();
        int n = 4;
//        int[][] edges = {{3,1,2},{3,2,3},{1,1,3},{1,2,4},{1,1,2},{2,3,4}};
        int[][] edges = {{3,1,2},{3,2,3},{1,1,4},{2,1,4}};
        int ret = lc.maxNumEdgesToRemove(n, edges);
        System.out.println(ret);
    }
}
