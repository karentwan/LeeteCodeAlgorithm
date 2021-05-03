package cn.karent.leetcode_v2;

import java.util.*;

/**
 * 重新规划路线
 */
public class LeetCode1466 {

    private int ret = 0;

    private void dfs(List<List<int[]>> edges, int idx, int father) {
        List<int[]> edge = edges.get(idx);
        for (int[] e : edge) {
            if( e[0] == father) {
                continue;
            }
            ret = e[1] == 1 ? ret+1 : ret;
            dfs(edges, e[0], idx);
        }
    }

    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] connection : connections) {
            edges.get(connection[0]).add(new int[]{connection[1], 1});
            edges.get(connection[1]).add(new int[]{connection[0], 0});  // 0 假边
        }
        dfs(edges, 0, -1);
        return ret;
    }


    public static void main(String[] args) {
        LeetCode1466 lc = new LeetCode1466();
//        int n = 6;
//        int[][] connections = {{0,1},{1,3},{2,3},{4,0},{4,5}};
        int n = 5;
        int[][] connections = {{1,0},{1,2},{3,2},{3,4}};
        int ret = lc.minReorder(n, connections);
        System.out.println(ret);
    }

}
