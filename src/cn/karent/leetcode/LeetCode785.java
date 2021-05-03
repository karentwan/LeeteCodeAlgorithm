package cn.karent.leetcode;

/**
 * 判断二分图
 */
public class LeetCode785 {

    private boolean dfs(int[][] graph, int idx, int color, int[] visited) {
        if( visited[idx] != 0 ) {
            return (visited[idx] == color);
        }
        int[] edges = graph[idx];
        visited[idx] = color;
        for(int e : edges) {
            if( !dfs(graph, e, -color, visited)) {
                return false;
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        if( n == 0) {
            return true;
        }
        int[] visited = new int[n];
        // 判断多个连通区域
        for(int i = 0; i < n; i++) {
            if( visited[i] == 0 && !dfs(graph, i, 1, visited)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode785 lc = new LeetCode785();
//        int[][] graph = {{1,3}, {0,2}, {1,3}, {0,2}};
//        int[][] graph = {{1,2,3}, {0,2}, {0,1,3}, {0,2}};
        int[][] graph = {{},{2,4,6},{1,4,8,9},{7,8},{1,2,8,9},{6,9},{1,5,7,8,9},{3,6,9},{2,3,4,6,9},{2,4,5,6,7,8}};
        boolean ret = lc.isBipartite(graph);
        System.out.println(ret);
    }

}
