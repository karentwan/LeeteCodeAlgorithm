package cn.karent.util;

/**
 * 并查集
 */
public class DSU {

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

}
